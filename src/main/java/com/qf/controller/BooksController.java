package com.qf.controller;


import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Books;
import com.qf.entity.BooksWithBLOBs;
import com.qf.mapper.SystemMapper;
import com.qf.service.IBooksService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController extends Base {
    @Autowired
    IBooksService booksService;
    @Autowired
    SystemMapper systemMapper;

    //通过 ISBN 查询对应的书种,已测试
    @GetMapping("/selectBooksByIsbn")
    public State<Object> selectBooksByIsbn(String Isbn,Integer currentPage, Integer pageSize){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<Books> booksPage = booksService.selectBookByIsbn(Isbn, currentPage,pageSize);
        if (booksPage.getList() == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",booksPage);
        }
    }

    //多条件查询,已测试
    @GetMapping("/selectBooksByCondition")
    public State<Object> selectBooksByCondition(Books books,Integer currentPage, Integer pageSize){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<Books> page = booksService.selectBooksByCondition(books, currentPage, pageSize);
        if (page.getList() == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",page);
        }
    }

    //添加书本
    @PostMapping("/insertBooks")
    public State<Object> insertBooks(BooksWithBLOBs booksWithBLOBs){
        int i = booksService.insertBooks(booksWithBLOBs);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"插入成功",i);
        }else {
            return packaging(StateCode.SUCCESS,"插入失败",null);
        }
    }
    /*@PostMapping("/insertBooks")
    public State<Object> insertBooks(BooksWithBLOBs booksWithBLOBs, MultipartFile upload, HttpServletRequest request) throws IOException {
        //获取文件路径到upload文件夹
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        String filename = upload.getOriginalFilename();
        filename = UUID.randomUUID().toString()+"_"+filename;
        upload.transferTo(new File(filename));
        String bookName = request.getParameter("bookName");
        booksWithBLOBs.setBookName(bookName);
        booksWithBLOBs.setImgPath(filename);
        int i = booksService.insertBooks(booksWithBLOBs);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"插入成功",i);
        }else {
            return packaging(StateCode.SUCCESS,"插入失败",null);
        }
    }*/

    @GetMapping("/selectAllBooks")
    public State<Object> selectAllBooks(Integer currentPage,Integer pageSize){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<Books> page = booksService.selectAllBooks(1, 2);
        if (page.getList() == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"查询成功",page);
        }
    }

    //通过 id 修改对应的书本信息
    @GetMapping("/updateBooksById")
    public State<Object> updateBooksById(BooksWithBLOBs booksWithBLOBs,Integer bookId){
        int i = booksService.updateBookById(booksWithBLOBs,bookId);
        if (i != 0){
            return packaging(StateCode.SUCCESS,"修改成功",i);
        } else {
            return packaging(StateCode.FAIL,"修改失败",null);
        }
    }

    //通过修改 is_delete 为0进行删除,已测试
    @PutMapping("/deleteBook")
    public State<Object> deleteBookByBookId(Integer bookId){
        int i = booksService.deleteBookByBookId(bookId);
        if (i != 0){
            return  packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return  packaging(StateCode.FAIL,"删除失败",null);
        }
    }


    @PutMapping("/deleteBatch")
    public State<Object> deleteBatch(int[] bookIds){
        int i = booksService.deleteBatch(bookIds);
        if (i == bookIds.length){
            return  packaging(StateCode.SUCCESS,"删除成功",i);
        }else {
            return  packaging(StateCode.FAIL,"删除失败",null);
        }
    }
}
