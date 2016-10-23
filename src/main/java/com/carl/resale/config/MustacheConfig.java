package com.carl.resale.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;

import java.nio.charset.Charset;

/**
 * @author Carl
 * @date 2016/10/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Configuration
@EnableWebMvc
public class MustacheConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.scriptTemplate().suffix(".xhtml").viewNames("mustache/*").prefix("WEB-INF/views/");
    }

    @Bean
    public ScriptTemplateConfigurer configurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngineName("nashorn");
        configurer.setScripts("/WEB-INF/resource/scripts/lib/mustache/mustache.min.js");
        configurer.setRenderObject("Mustache");
        configurer.setRenderFunction("render");
        configurer.setCharset(Charset.forName("UTF-8"));
        configurer.setResourceLoaderPath("/");
        return configurer;
    }
}
