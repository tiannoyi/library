package com.xiong;

import com.qf.config.MybatisConfig;
import com.qf.config.PropertyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-18 16:24
 **/
public class dbTest {
    @Test
    public void dbTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyConfig.class);
        PropertyConfig bean = applicationContext.getBean(PropertyConfig.class);
        System.out.println(bean);
    }
    @Test
    public void DatasourceTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MybatisConfig.class);
       // MybatisConfig bean = applicationContext.getBean(MybatisConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
