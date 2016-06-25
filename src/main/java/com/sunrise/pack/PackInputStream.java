package com.sunrise.pack;

import com.sun.istack.internal.NotNull;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 打包读取流
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class PackInputStream extends FilterInputStream {

    private InputStream in;
    private IPackCrypter crypter;

    protected PackInputStream(InputStream in, @NotNull IPackCrypter crypter) {
        super(in);

        this.in = in;
        this.crypter = crypter;
    }

    @Override
    public int read() throws IOException {
        int i = this.in.read();
        return crypter.update(i);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = this.in.read(b, off, len);
        for (int i = off; i < off + len; i++) {
            b[i] = crypter.update(b[i]);
        }
        return read;
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }
}
