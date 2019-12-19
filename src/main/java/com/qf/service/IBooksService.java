package com.qf.service;

import com.qf.entity.Books;

import java.util.List;

public interface IBooksService {

    //通过 ISBN 查询对应的 books，Isbn 是唯一的
    Books selectBookByIsbn(String Isbn);

    //查询所有的书本数据
    List<Books> selectAll();

    //添加 Books

    //删除

    //修改

}
