package com.qf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.annotation.Before;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-18 16:31
 **/
@Configuration
@MapperScan(value = "com.qf.mapper")
public class MybatisConfig {

    @Bean
    public DataSource dataSource(PropertyConfig propertyConfig){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(propertyConfig.getUsername());
        dataSource.setPassword(propertyConfig.getPassword());
        dataSource.setUrl(propertyConfig.getUrl());
        dataSource.setDriverClassName(propertyConfig.getDriver());
        return dataSource;
    }


    /**
     * 配置核心Mybatis核心工厂
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //配置数据源
        bean.setDataSource(dataSource);
        // 设置实体类别名
        bean.setTypeAliasesPackage("com.qf.entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //配置Mapper映射文件的路径
        bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        //设置分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        //创建插件需要的参数集合
        Properties properties = new Properties();
        //配置数据库方言
        properties.setProperty("helperDialect", "mysql");
        //配置风云的合理化数据
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        bean.setPlugins(new Interceptor[]{pageInterceptor});
        return bean;
    }

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


    /**
     * 配置分页插件
     * @return
     */
   /* @Bean
   public PageInterceptor pageInterceptor(){
       PageInterceptor pageInterceptor = new PageInterceptor();
       return pageInterceptor;
   }*/


    @Bean
    public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
