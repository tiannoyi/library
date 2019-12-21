package com.qf.initializer;


import com.qf.config.EncodingFilter;
import com.qf.config.MybatisConfig;
import com.qf.config.RootConfig;
import com.qf.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 22:10
 **/
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Spring IoC环境配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 配置Spring IoC资源
        return new Class<?>[]{RootConfig.class, MybatisConfig.class};//获取Spring Ioc容器的java配置类，用以装载各类Spring Bean
    }

    // DispatcherServlet环境配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 加载Java配置类
        return new Class<?>[]{WebConfig.class};//获取各类Spring MVC的URI和控制器的配置关系类
    }

    //获取DispatcherServlet的映射信息
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    @Override
    protected String[] getServletMappings() {
        //定义DispatcherServlet拦截的请求
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        //return super.getServletFilters();
        return  new Filter[]{new EncodingFilter()};
    }

    /* //Servlet上传文件配置.
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //配置上传路径
        String filePath = "e:mvc/uploads";
        //限制请求当个文件5mb
        Long singleMax = (long)(5 * Math.pow(2, 20));
        //总文件10mb
        Long totalMax = (long)(10 * Math.pow(2, 20));
        //设置上传文件配置
        registration.setMultipartConfig(new MultipartConfigElement(filePath,singleMax,totalMax,0));
        //super.customizeRegistration(registration);
    }*/
}
