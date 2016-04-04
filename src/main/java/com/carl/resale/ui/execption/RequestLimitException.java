package com.carl.resale.ui.execption;

/**
 * @author Carl
 * @date 2016/4/4
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class RequestLimitException extends Exception {
    private static final long serialVersionUID = 1364225358754654702L;
    public RequestLimitException() {
        super("HTTP请求超出设定的限制");
    }
    public RequestLimitException(String message) {
        super(message);
    }
}
