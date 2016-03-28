package com.carl.resale.core;

import com.carl.resale.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class FrameworkConfig {
    //单例
    private static FrameworkConfig _config;
    private Log log = LogFactory.getLog(this.getClass());
    //根目录
    private String rootDir;
    //配置文件
    private String file;
    //存储参数
    private Map<String, String> params = new HashMap<String, String>();

    //参数是否可写
    private boolean paramWritable = false;

    private FrameworkConfig(final String rootDir, final String file) throws Exception {
        this.rootDir = rootDir;
        this.file = file;
        load();
    }

    /**
     * 出去配置
     *
     * @throws Exception
     */
    private void load() throws Exception {
        try {
            File f = new File(this.rootDir, this.file);
            if (!f.exists() || !f.isFile()) {
                log.warn("配置文件 [" + this.file + "] 不存在，无法初始化配置");
            }

            SAXParserFactory.newInstance().newSAXParser().parse(f, new FrameworkConfig.ConfigHandler());
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * 获取单例对象
     *
     * @param rootDir
     * @param file
     * @param paramWritable
     * @return
     * @throws Exception
     */
    public static FrameworkConfig getInstance(String rootDir, String file, boolean paramWritable) throws Exception {
        if (_config == null) {
            _config = new FrameworkConfig(rootDir, file);
            _config.paramWritable = paramWritable;
        }

        return _config;
    }

    public static FrameworkConfig getInstance(String rootDir, String file) throws Exception {
        return getInstance(rootDir, file, false);
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static FrameworkConfig getInstance() {
        if (_config == null) {
            throw new RuntimeException("框架未初始化，请尝试重新启动");
        } else {
            return _config;
        }
    }

    /**
     * 获取参数
     *
     * @param name
     * @param defaultValue
     * @return
     */
    public String getParam(String name, String defaultValue) {
        String v = (String) this.params.get(name);
        return StringUtil.isNull(v) ? defaultValue : v;
    }

    /**
     * 设置参数
     *
     * @param name
     * @param value
     */
    public void setParam(String name, String value) {
        if (this.paramWritable) {
            this.params.put(name, value);
        }
    }

    /**
     * 配置读取项
     */
    private class ConfigHandler extends DefaultHandler {
        private StringBuilder tmpContent;
        private String paramName;

        private ConfigHandler() {
            this.tmpContent = new StringBuilder();
            this.paramName = null;
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            this.tmpContent.setLength(0);
            if ("param".equalsIgnoreCase(qName)) {
                this.paramName = attributes.getValue("name");
            }

        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("param".equalsIgnoreCase(qName)) {
                if (this.paramName != null) {
                    FrameworkConfig.this.params.put(this.paramName, this.tmpContent.toString().trim());
                }
                this.paramName = null;
            }

        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);
            if (!StringUtil.isNull(str)) {
                this.tmpContent.append(str);
            }
        }
    }
}
