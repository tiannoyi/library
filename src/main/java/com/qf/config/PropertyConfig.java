package com.qf.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-18 16:17
 **/
@PropertySource("classpath:db.properties")
@Data
@Configuration
public class PropertyConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClass}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

}

