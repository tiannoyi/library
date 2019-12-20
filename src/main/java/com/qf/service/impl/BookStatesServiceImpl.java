package com.qf.service.impl;

import com.qf.entity.BookStates;
import com.qf.mapper.BookStatesMapper;
import com.qf.service.IBookStatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookStatesServiceImpl implements IBookStatesService {
    @Autowired
    private BookStatesMapper bookStatesMapper;

    @Override
    public int addBookStates() {
        return 0;
    }

    @Override
    public int deleteBookStates(Integer bookStateId) {
        BookStates bookStates = new BookStates();
        bookStates.setBookStateId(bookStateId);
        bookStates.setIsDelete(0);
        return bookStatesMapper.updateByPrimaryKeySelective(bookStates);
    }

    @Override
    public int updateBookStates(Integer bookStateId) {
        BookStates bookStates = new BookStates();
        bookStates.setBookStateId(bookStateId);
        return bookStatesMapper.updateByPrimaryKeySelective(bookStates);
    }
}
