package com.qf.config;

import org.apache.commons.lang3.CharSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 21:18
 **/
//不扫描Controller
@Configuration
@ComponentScan(value = "com.qf",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
//使用事务驱动管理器
@EnableTransactionManagement
//实现接口TransactionManagementConfigurer，这样可以配置注解驱动事务
//implements TransactionManagementConfigurer
public class RootConfig  {


   /* @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }*/

   @Bean
   public StringHttpMessageConverter stringHttpMessageConverter(){
      StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
      ArrayList<MediaType> mediaTypes= new ArrayList<>();
      mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
      /*mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
      mediaTypes.add(MediaType.TEXT_HTML);
      mediaTypes.add(MediaType.TEXT_PLAIN);
      mediaTypes.add(MediaType.APPLICATION_XML);*/
      mediaTypes.add(new MediaType("text","html", Charset.defaultCharset()));
      mediaTypes.add(new MediaType("text","plain",Charset.defaultCharset()));
      stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
      return stringHttpMessageConverter;
   }
 }
