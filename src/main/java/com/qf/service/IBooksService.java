package com.qf.service;

import com.qf.entity.Books;

import java.util.List;

public interface IBooksService {

    //通过ISBN查询 对应的 books，Isbn 是唯一的
    Books selectBookByIsbn(String Isbn);
}
