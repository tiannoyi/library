package com.qf.entity.vo;

import com.qf.entity.BookStates;
import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BooksVo extends Books {
    //通过书本id 查到对应的在馆信息, 多对多
    private List<BookStates> bookStates = new ArrayList<>();
    //通过书本id 查询到对应的书本类型, 多对一
    private List<BookTypes> bookTypes = new ArrayList<>();
}
