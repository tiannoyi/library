package com.qf.config;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-24 19:30
 **/
@WebFilter(filterName = "shiroFilter",urlPatterns = "/*",initParams = {
        @WebInitParam(name = "targetFilterLifecycle",value = "true")
})
public class ShiroFilterConfig extends DelegatingFilterProxy {
}
