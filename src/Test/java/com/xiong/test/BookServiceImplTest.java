package com.xiong.test;

import com.github.pagehelper.PageInfo;
import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.entity.BooksWithBLOBs;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBooksService;
import com.qf.service.impl.BooksServiceImpl;
import com.qf.util.Page;
import com.xiong.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
@Configuration
public class BookServiceImplTest {

    @Autowired
    IBooksService booksService;

    @Autowired
    BooksMapper booksMapper;

    @Test
    public void Test(){
        /*BooksExample booksExample = new BooksExample();
        BooksWithBLOBs booksWithBLOBs = new BooksWithBLOBs();*/
        System.out.println(booksService.deleteBookByBookId(10));
        //System.out.println("--------------------"+booksService.selectBooksAll());
    }


}
