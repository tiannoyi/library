package com.qf.service.impl;

import com.qf.mapper.BookTypesMapper;
import com.qf.service.IBookTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookTypesServiceImpl implements IBookTypesService {
    @Autowired
    private BookTypesMapper bookTypesMapper;

}
