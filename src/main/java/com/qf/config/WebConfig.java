package com.qf.config;

import com.qf.interceptor.LoginInterceptor;
import org.springframework.context.annotation.*;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 22:00
 **/
//只扫描Controller
//useDefaultFilters 禁用默认的规则
@Configuration
@ComponentScan(value = "com.qf" ,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
@EnableWebMvc
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer  {
//WebMvcConfigurationSupport

    /**
     * 拦截器
     * @param registry
     */
   /* @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }

    /**
     * 当首页或者登陆页的页面对外暴露，不需要加载任何的配置的时候，
     * 这些页面将不通过接口层，而是直接访问，这时，
     * 就需要配置ViewController指定请求路径直接到页面。
     * @param registry
     */
   /* @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/index");
        //实现一个请求到视图的映射，而无需书写controller
        registry.addViewController("/").setViewName("forward:/index.html");
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        //实现一个请求到视图的映射，而无需书写controller
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    /**
     * 消息内容转换配置
     * 配置fastJson返回json转换
     * @param converters
     */
    /* @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
       //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改放回内容过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        //将fastjson添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);
    }*/

    /**
     * 通过注解 @Bean 初始化视图解析器
     * @return 视图解析器
     */
    @Bean
    public ViewResolver resourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");

        //请求视图文件的后缀
        internalResourceViewResolver.setSuffix(".jsp");
        //internalResourceViewResolver.setPrefix("/html/");
        //internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    /**
     * 视图解析器
     * @param registry
     */
    /*@Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从 /WEB-INF/ xxx .jsp
       // registry.jsp();
        registry.jsp("/WEB-INF/jsp/", ".jsp");

    }*/

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    /**
     * 跨域cors配置
     * @param registry
     */
    /*@Override
    protected void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedHeaders("/**")
                .allowedMethods("POST","GET")
                .allowedOrigins("http://...")
                .allowCredentials(true);
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("/**")
                .allowedMethods("POST","GET")
                .allowedOrigins("http://...")
                .allowCredentials(true);
    }

    /**
     *  当请求的参数中带有日期的参数的时候，可以在此配置formatter使得接收到日期参数格式统一。
     * @param registry
     */
   /* @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<Date>() {

            @Override
            public String print(Date date, Locale locale) {
                return Long.valueOf(date.getTime()).toString();
            }

            @Override
            public Date parse(String date, Locale locale) throws ParseException {
                return new Date(Long.parseLong(date));

            }
        } );
    }*/

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<Date>() {

            @Override
            public String print(Date date, Locale locale) {
                return Long.valueOf(date.getTime()).toString();
            }

            @Override
            public Date parse(String date, Locale locale) throws ParseException {
                return new Date(Long.parseLong(date));

            }
        } );
    }

    /**
     * 自定义静态资源映射
     * @param registry
     */
 /*   @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/**")
                .addResourceLocations("classpath:/public/**")
                .addResourceLocations("classpath:/resources/**");
    }*/
    /**
     * 静态资源
     * @param configurer
     */
    /* @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }





   /* @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");
        registry.addResourceHandler("/html/**")
                .addResourceLocations("/html/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/");
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");
        registry.addResourceHandler("/html/**")
                .addResourceLocations("/html/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/");
    }


    /**
     * 配置路径匹配参数
     * @param configurer
     */
   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }*/
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }


   /* @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //super.configureContentNegotiation(configurer);
        configurer.mediaType("json", MediaType.APPLICATION_JSON_UTF8);
    }*/

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("json", MediaType.APPLICATION_JSON_UTF8);
    }

    @Bean(name = "multipartResolver")
    // 文件上传bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        return new CommonsMultipartResolver();
    }



}
