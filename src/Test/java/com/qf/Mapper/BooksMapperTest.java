package com.qf.Mapper;


import com.qf.config.TestConfig;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBooksService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class BooksMapperTest {
    @Autowired
    BooksMapper booksMapper;

    @Test
    public void select1(){

    }
}
