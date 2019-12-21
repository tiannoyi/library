package com.xiong.test.com.jie.borrows;

import com.qf.entity.Borrows;
import com.qf.service.IBorrowsService;
import com.xiong.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: OkaMe1o
 * @className: BorrowsInsertTest
 * @description: TODO
 * @createTime: 2019/12/20 16:26
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class BorrowsInsertAndUpdateTest {
    @Autowired
    IBorrowsService borrowsService;

    @Test
    public void insertBorrowsTest() {
        Borrows borrows = new Borrows();
        borrows.setBorrowTime(new Date());
        borrows.setRepayTime(null);
        borrows.setRenew((byte) 0);
        borrows.setOverdue((byte) 0);
        borrows.setReaderId(0);
        borrows.setBookStateId(0);
        borrows.setFine((float) 2.1);
        Integer integer = borrowsService.insertBorrows(borrows);
        System.out.println("插入结果：" + integer);
    }

    @Test
    public void updateTest() {
        Borrows borrows = new Borrows();
        borrows.setBorrowId(1);
        borrows.setBorrowTime(new Date());
        borrows.setRepayTime(null);
        borrows.setRenew((byte) 0);
        borrows.setOverdue((byte) 0);
        borrows.setBookStateId(0);
        borrows.setFine((float) 32.1);
        System.out.println("更新----------结果：" + borrowsService.updateBorrows(borrows));
    }

}
