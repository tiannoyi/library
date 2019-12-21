package com.xiong.test.com.jie.borrows;

import com.qf.entity.Borrows;
import com.xiong.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: JunJie
 * @classBelongTo: library.com.xiong.test.com.jie.borrows
 * @description: TODO
 * @createTime: 2019/12/20 21:20
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class MakeDivideTest {

    @Test
    public void test() {
        Borrows borrows = new Borrows();

        System.out.println("-------------------------");
        System.out.println("=================borrowid" + (borrows.getBorrowId() == null));
        System.out.println("=================readerid" + borrows.getReaderId());
        System.out.println("=================bookstateid" + borrows.getBookStateId());
        System.out.println("-------------------------");
    }
}
