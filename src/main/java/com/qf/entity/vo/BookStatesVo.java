package com.qf.entity.vo;

import com.qf.entity.BookStates;
import com.qf.entity.Books;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookStatesVo extends BookStates {
    //通过书本的在馆id查询对应得书本信息, 多对多
    private List<Books> books = new ArrayList<>();
}
