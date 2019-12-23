package com.qf.Service.impl;

import com.qf.config.TestConfig;
import com.qf.entity.BookTypes;
import com.qf.service.IBookTypesService;
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
public class BookTypesServiceImplTest {
    @Autowired
    IBookTypesService bookTypesService;

    @Test
    public void add(){
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeName("php");
        bookTypes.setClassNumber("003");
        bookTypes.setFatherNode("22");
        bookTypesService.insertBookTypes(bookTypes);
    }

    @Test
    public void delete(){
        bookTypesService.deleteBookTypes(7);
    }

    @Test
    public void update(){
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeName("web");
        bookTypesService.updateBookTypes(6,bookTypes);
    }

    @Test
    public void select1(){
        System.out.println(bookTypesService.selectBooksByBookTypesId(1,2,1));
    }
}
