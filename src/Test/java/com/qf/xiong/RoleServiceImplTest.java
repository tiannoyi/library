package com.qf.xiong;

import com.qf.config.TestConfig;
import com.qf.entity.Roles;
import com.qf.mapper.SystemMapper;
import com.qf.service.impl.RoleServiceImpl;
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
 * @create: 2019-12-21 15:59
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class RoleServiceImplTest {
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    SystemMapper systemMapper;

    @Test
    public void testSelectAll(){
        int pageLine = systemMapper.getPageLine();
       Page<Roles> rolesPage = roleService.selectAll(1, pageLine);
       System.out.println(rolesPage);

    }
}
