package com.qf.Service.impl;

import com.qf.config.TestConfig;
import com.qf.service.IReadersService;

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
public class ReadersServiceImplTest {
    @Autowired
    IReadersService readersService;

    @Test
    public void delete(){
        int[] re = {1, 2, 3};
        readersService.deleteBatch(re);
    }

}
