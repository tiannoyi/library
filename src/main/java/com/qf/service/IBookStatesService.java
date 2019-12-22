package com.qf.service;

import com.qf.entity.BookStates;
import com.qf.entity.Books;
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
    //通过在馆ID 查找书本在馆信息并查出对应的书本信息
    BookStates selectStateByBookStateId(Integer bookStateId);
    //查询在馆的所有书本信息 -- 先通过是否在馆查询到所有的书本id,再通过id查询到书本信息
    Page<Books> selectBooksByState(Integer state,Integer currentPage,Integer pageSize);

}
