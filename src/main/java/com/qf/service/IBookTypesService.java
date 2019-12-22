package com.qf.service;

import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import com.qf.util.Page;

import java.util.List;

public interface IBookTypesService {
    //增,已测试
    int insertBookTypes(BookTypes bookTypes);
    //删,已测试
    int deleteBookTypes(Integer bookTypeId);
    //改,已测试
    int updateBookTypes(Integer bookTypeId,BookTypes bookTypes);
    //查询书本的所有类目
    Page<BookTypes> selectAllBookTypes(Integer currentPage,Integer pageSize);
    //通过类目ID 查询对应的书本信息
    Page<Books> selectBooksByBookTypesId(Integer currentPage,Integer pageSize,Integer bookTypeId);
}
