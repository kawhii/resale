package com.sunrise.pack;

import com.sun.istack.internal.NotNull;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 打包可加密输出流
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class PackOutputStream extends FilterOutputStream {

    private OutputStream out;
    private IPackCrypter crypter;

    public PackOutputStream(OutputStream out, @NotNull IPackCrypter crypter) {
        super(out);

        this.out = out;
        this.crypter = crypter;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(crypter.update(b));
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            b[i] = crypter.update(b[i]);
        }
        out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        try {
            flush();
        } catch (IOException ex) {
        }
        out.close();
    }
}
