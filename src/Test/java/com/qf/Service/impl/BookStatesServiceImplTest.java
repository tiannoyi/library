package com.qf.Service.impl;

import com.qf.config.TestConfig;
import com.qf.entity.BookStates;
import com.qf.entity.Books;
import com.qf.service.IBookStatesService;
import com.qf.util.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
@Slf4j
public class BookStatesServiceImplTest {
    @Autowired
    IBookStatesService bookStatesService;

    @Test
    public void insertBookStates() {
        BookStates bookStates = new BookStates();
        bookStates.setBookId(2);
        bookStates.setBarCode("3");
        bookStatesService.insertBookStates(bookStates);
    }

    @Test
    public void deleteBookStates() {
        bookStatesService.deleteBookStates(10);
    }

    @Test
    public void updateBookStates() {
        BookStates bookStates = new BookStates();
        bookStates.setIsDelete(1);
        bookStates.setBarCode("006");
        bookStatesService.updateBookStates(10,bookStates);
    }

    @Test
    public void selectAll() {
        Page<Books> booksPage = bookStatesService.selectBooksByState(0, 1, 3);
        log.debug(""+booksPage);
    }
}