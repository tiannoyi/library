package com.qf.service;

import com.qf.entity.BookStates;
import com.qf.util.Page;

public interface IBookStatesService {
    //增
    int insertBookStates(BookStates bookStates);
    //删
    int deleteBookStates(Integer bookStateId);
    //改
    int updateBookStates(Integer bookStateId,BookStates bookStates);
    //查
    Page<BookStates> selectAllBookStates(Integer currentPage, Integer pageSize);
    //通过在馆ID 查找书本在馆信息
    BookStates selectStateByBookStateId(Integer bookStateId);
}
