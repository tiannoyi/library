package com.qf.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-23 11:49
 **/
@PropertySource("classpath:application.properties")
@Data
@Configuration
public class ImgesConfig {
    @Value("${upload-path}")
    private String path;

    @Value("${imagePath}")
    private String imagePath;
}
