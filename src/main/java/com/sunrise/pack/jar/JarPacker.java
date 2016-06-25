package com.sunrise.pack.jar;

import com.sunrise.pack.BasePacker;
import org.apache.commons.io.FilenameUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * jar包打包
 *
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JarPacker extends BasePacker<JarPackFileIndex, JarPackFileInfo> {
    private String version;//版本号
    private String sequence;//序列号

    /**
     * 版本号
     *
     * @param version
     * @return
     */
    public JarPacker version(String version) {
        this.version = version;
        return this;
    }

    /**
     * 序列号
     *
     * @param sequence
     * @return
     */
    public JarPacker sequence(String sequence) {
        this.sequence = sequence;
        return this;
    }

    @Override
    public JarPackFileIndex index(File packFile) throws IOException {
        DataInputStream in = buildInputStream(packFile);
        JarPackFileIndex index = JarPackFileIndex.create(packFile);
        long shouldReadLen;
        try {
            shouldReadLen = readeIndexHeader(index, in);
        } catch (IllegalAccessException e) {
            throw new IOException(e);
        }
        long read = shouldReadLen;
        while (read < index.length()) {
            JarPackFileInfo info = new JarPackFileInfo();
            info.index(index);
            long infoRead = readFileInfo(info, in);
            index.add(info);
            read += infoRead;
        }
        in.close();
        return index;
    }

    @Override
    public JarPackFileInfo fileInfo(File packFile, String name) throws IOException {
        JarPackFileIndex index = readIndex(packFile);
        for (JarPackFileInfo jar : index.files()) {
            if (name.equals(jar.name())) {
                return jar;
            }
        }
        return null;
    }

    @Override
    protected void packFiles(String path) throws Exception {
        File dir = new File(path);
        Collection<File> allFiles = allFiles(dir);
        if (allFiles != null && allFiles.size() > 0) {
            //打包文件不存在进行创建
            File outputFile = getOutput();
            if (!outputFile.exists()) {
                outputFile.mkdirs();
            }
            //打包文件
            File packFile = new File(outputFile, getFullPackName());
            //打包文件索引
            JarPackFileIndex index = buildIndex(path, allFiles, packFile);
            DataOutputStream outputStream = buildOutputStream(packFile);

            //输出索引并且输出文件信息
            write(index, allFiles, outputStream);
        }
    }

    /**
     * 构建索引
     *
     * @param path     根路径
     * @param allFiles 全部文件
     * @param packFile 打包文件
     * @return
     */
    private JarPackFileIndex buildIndex(String path, Collection<File> allFiles, File packFile) {
        //构建索引
        JarPackFileIndex index = JarPackFileIndex.create(packFile)
                .version(version)//版本号
                .sequence(sequence);//序列号
        for (File file : allFiles) {
            String name = getName(file, path);
            JarPackFileInfo fileInfo = new JarPackFileInfo()
                    .name(name)
                    .lastModified(file.lastModified())
                    .length(file.length());
            index.file(fileInfo);
        }
        return index;
    }


    /**
     * @param file
     * @return
     */
    private String getName(File file, String rootPath) {
        String fileFullPath = file.getAbsolutePath();
        fileFullPath = fileFullPath.replace('\\', '/');
        int subIndex = fileFullPath.indexOf(rootPath);
        String fileEndPath = fileFullPath.substring(subIndex < 0 ? 0 : subIndex + rootPath.length());
        String ext = FilenameUtils.getExtension(file.getName());
        //如果为class文件，路径改为全部.
        if ("class".equals(ext) || "java".equals(ext)) {
            fileEndPath = fileEndPath.replace('/', '.');
        }
        if (fileEndPath.startsWith(".") || fileEndPath.startsWith("\\")) {
            fileEndPath = fileEndPath.substring(1);
        }
        return fileEndPath;
    }

    @Override
    protected void writeIndexHeaderExtend(JarPackFileIndex index, DataOutputStream outputStream) throws IOException {
        outputStream.writeInt(index.versionLen());
        outputStream.write(index.version().getBytes());
        outputStream.writeInt(index.sequenceLen());
        outputStream.write(index.sequence().getBytes());
        outputStream.flush();
    }

    @Override
    protected long readIndexHeaderExtend(JarPackFileIndex index, DataInputStream in) throws IOException {
        //读取版本长度
        int versionLen = in.readInt();
        //读取版本
        byte[] versionBuf = new byte[versionLen];
        in.read(versionBuf, 0, versionBuf.length);
        //读取序列号长度
        int sequenceLen = in.readInt();
        //读取序列号
        byte[] sequenceBuf = new byte[sequenceLen];
        in.read(sequenceBuf, 0, sequenceBuf.length);
        index.version(new String(versionBuf));
        index.sequence(new String(sequenceBuf));
        return 4 + versionLen + 4 + sequenceLen;
    }
}
