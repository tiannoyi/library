package com.qf.Service.impl;

import com.qf.config.TestConfig;
import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import com.qf.entity.BooksWithBLOBs;
import com.qf.entity.vo.BooksVo;
import com.qf.mapper.AdminMapper;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBooksService;
import com.qf.service.impl.AdminServiceImpl;
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

    @Test
    public void add(){
        BooksWithBLOBs booksWithBLOBs = new BooksWithBLOBs();
        booksWithBLOBs.setBookName("asdff");
        int i = booksService.insertBooks(booksWithBLOBs);
        System.out.println(booksWithBLOBs.getBookId());
    }

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
        booksService.selectAllVo(1,4);
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

    @Autowired
    BooksMapper booksMapper;
    @Test
    public void sdf(){
        Books books = booksService.selectBookById(9);
    }
    @Test
    public void select1231(){
        Books books = new Books();
        books.setBookName("厚黑学");
        booksService.selectBookVo(books);
        //booksMapper.selectBookVo(books);
    }
    @Test
    public void select12334(){
        //booksMapper.selectAllVo();
        booksService.selectAllVo(1,5);
    }

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AdminServiceImpl adminService;
    @Test
    public void select123(){
        adminService.selectAllVo(1,2);
    }
}
