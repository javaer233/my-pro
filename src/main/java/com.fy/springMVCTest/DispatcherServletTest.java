package com.fy.springMVCTest;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by yk on 2018/07/23
 * 用于配置DispatcherServlet
 */
public class DispatcherServletTest extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到/
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
