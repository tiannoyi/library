package com.qf.Service.impl;

import com.qf.config.TestConfig;
import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import com.qf.entity.BooksWithBLOBs;
import com.qf.service.IBooksService;
import com.qf.util.Page;
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
public class BooksServiceImplTest {
    @Autowired
    IBooksService booksService;

 /*   @Test
    public void add(){
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeName("php");
        bookTypes.setClassNumber("003");
        bookTypes.setFatherNode("22");
        bookTypesService.insertBookTypes(bookTypes);
    }*/

    @Test
    public void delete(){
        int[] ids = {9, 10, 11, 12};
        booksService.deleteBatch(ids);
        //booksService.deleteBookByBookId(11);
    }

    @Test
    public void update(){
        BooksWithBLOBs booksWithBLOBs = new BooksWithBLOBs();
        booksWithBLOBs.setBookName("小鱼儿与花无缺");
        booksWithBLOBs.setAuthor("未知");
        booksWithBLOBs.setPrice("66元");
        booksService.updateBookById(booksWithBLOBs,12);
    }

    @Test
    public void select1(){
        booksService.selectBooksAll();
    }

    @Test
    public void  select2(){
        Page<Books> page = booksService.selectAllBooks(1, 5);
        for (Books b : page.getList()){
            System.out.println(b);
        }
    }

    @Test
    public void selectBY(){
        Books books = new Books();
        books.setBookName("天才在左 疯子在右");
        Page<Books> page = booksService.selectBooksByCondition(books, 1, 2);
        for (Books b : page.getList()){
            System.out.println(b);
        }
    }
}
