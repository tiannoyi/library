package com.qf.entity.vo;

import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookTypesVo extends BookTypes {
    //通过书的类型查询到对应的书本信息, 一对多
    private List<Books> books = new ArrayList<>();
}
