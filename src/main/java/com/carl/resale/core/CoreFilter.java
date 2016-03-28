package com.carl.resale.core;

import com.carl.resale.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 初始化过滤器，加载配置资源
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class CoreFilter implements Filter {
    private static CoreFilter _INST;
    protected final Log logger = LogFactory.getLog(getClass());
    private FrameworkConfig frmConfig;
    private String webRoot;
    private String sysEncoding = "UTF-8";

    public CoreFilter() {
    }

    public static CoreFilter instance() {
        return _INST;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        _INST = this;
        logger.debug("初始化CARL框架过滤器...");
        this.webRoot = filterConfig.getServletContext().getRealPath("/");

        Constants.setWebRoot(this.webRoot);
        Constants.setEncoding(this.sysEncoding);
        String frameworkConfigFile = filterConfig.getInitParameter("config-file");
        if (StringUtil.isNull(frameworkConfigFile)) {
            frameworkConfigFile = "WEB-INF/framework.xml";
        }

        try {
            this.frmConfig = FrameworkConfig.getInstance(Constants.getWebRoot(), frameworkConfigFile);
        } catch (Exception var14) {
            throw new ServletException(var14);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        _INST = null;
    }
}
