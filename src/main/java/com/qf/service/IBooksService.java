package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.entity.Books;
import com.qf.entity.BooksWithBLOBs;
import com.qf.util.Page;

import java.util.List;

public interface IBooksService {

    //通过 ISBN 查询对应的 books，Isbn 是唯一的
    Books selectBookByIsbn(String Isbn);

    //查询所有的书本数据
    List<Books> selectBooksAll();

    //多条件查询对应的书
    List<Books> selectBooksByCondition(Books books);

    //添加 Books
    int insertBooks(BooksWithBLOBs booksWithBLOBs);

    //删除
    int deleteBookByBookId(Integer bookId);

    //修改
    int updateBookById(BooksWithBLOBs booksWithBLOBs, Integer bookId);

    //查询所有书本
    Page<Books> selectBooksList(Integer currentPage, Integer pageSize);


}
