package com.qf.xiong;

import com.qf.config.TestConfig;
import com.qf.service.IPermissionsService;
import com.qf.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 21:57
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class PermissionsServiceImplTest {
    @Autowired
    IPermissionsService permissionsService;
    @Test
    public void selectAllTest(){
        Page page = permissionsService.selectAll(1, 10);
        System.out.println(page);
    }
}
