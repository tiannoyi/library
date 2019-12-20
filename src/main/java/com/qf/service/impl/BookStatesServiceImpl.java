package com.qf.service.impl;

import com.qf.mapper.BookStatesMapper;
import com.qf.service.IBookStatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookStatesServiceImpl implements IBookStatesService {
    @Autowired
    private BookStatesMapper bookStatesMapper;

}
