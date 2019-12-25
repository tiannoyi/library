package com.qf.xiong;

import com.qf.aspect.OperationLogger;
import com.qf.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-25 20:24
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class TestAop {
    @OperationLogger(modelName = "测试",opEntity = "ceshi",option = "/test/tewst")
    @Test
    public void test(){
        System.out.println("----------->");
    }
}
