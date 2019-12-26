package com.qf.service;

import com.qf.entity.Books;
import com.qf.entity.BooksWithBLOBs;
import com.qf.entity.vo.BooksVo;
import com.qf.util.Page;

import java.util.List;

public interface IBooksService {

    //通过 ISBN 查询对应的 books
    Page<Books> selectBookByIsbn(String Isbn,Integer currentPage, Integer pageSize);
    Books selectBookByIsbn(String Isbn);
    Books selectBookById(Integer bookId);
    //二表单条件连查
    BooksVo selectBookVo(Books books);

    //查询所有的书本数据
    List<Books> selectBooksAll();

    //多条件查询对应的书
    Page<Books> selectBooksByCondition(Books books,Integer currentPage, Integer pageSize);

    //查询所有书本
    Page<Books> selectAllBooks(Integer currentPage, Integer pageSize);

    //er表连查,查询对应的关联信息
    Page<BooksVo> selectAllVo(Integer currentPage, Integer pageSize);

    //添加 Books
    int insertBooks(BooksWithBLOBs booksWithBLOBs);

    //删除
    int deleteBookByBookId(Integer bookId);

    //修改
    int updateBookById(BooksWithBLOBs booksWithBLOBs, Integer bookId);

    //通过书名查询书本的 id
    int selectBookIdByBookName(String bookName);

    //批量删除
    int deleteBatch(int[] bookIds);

    //批量添加
    int insertBatch(BooksWithBLOBs[] booksWithBLOBs);
}
