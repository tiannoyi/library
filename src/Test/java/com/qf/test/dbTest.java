package com.qf.test;

import com.qf.mapper.AdminMapper;
import com.qf.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringUtils;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-18 16:24
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class dbTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void test(){
        boolean empty = StringUtils.isEmpty(adminMapper);
        System.out.println("================================================================>"+empty);
    }

}
