package com.qf.controller;


import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Books;
import com.qf.service.IBooksService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController extends Base {
    @Autowired
    IBooksService booksService;

    @GetMapping("/select")
    private State<Object> selectBooksByIsbn(){
        Books books = booksService.selectBookByIsbn("9787307075429");
        return packaging(StateCode.SUCCESS,"查询成功",books);
    }
}
