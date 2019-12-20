package com.qf.service;

import com.qf.entity.BookTypes;
import com.qf.entity.Books;

import java.util.List;

public interface IBookTypesService {
    //增
    int insertBookTypes(BookTypes bookTypes);
    //删
    int deleteBookTypes(Integer bookTypeId);
    //改
    int updateBookTypes(Integer bookTypeId);
    //查
    List<Books> getBooksByBookTypeId(Integer bookTypeId);
}
