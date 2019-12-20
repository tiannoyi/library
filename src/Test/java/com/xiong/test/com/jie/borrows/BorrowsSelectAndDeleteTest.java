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

import java.util.List;

/**
 * @author: OkaMe1o
 * @className: BorrowsSelectByIdTest
 * @description: TODO
 * @createTime: 2019/12/20 17:12
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class BorrowsSelectAndDeleteTest {
    @Autowired
    IBorrowsService borrowsService;

    @Test
    public void selectedByIdTest(){
        Borrows borrows = borrowsService.selectBorrowsByBorrowId(2);
        System.out.println(borrows);
    }

    @Test
    public void selectedAllTest(){
        List<Borrows> borrowsList = borrowsService.selectAll();
        System.out.println(borrowsList);
    }

    @Test
    public void deleteSingleTest(){
        Borrows borrows = new Borrows();
        borrows.setBorrowId(1);
        Integer integer = borrowsService.deleteBorrowsByBorrowId(borrows.getBorrowId());
        System.out.println(integer);
    }

}
