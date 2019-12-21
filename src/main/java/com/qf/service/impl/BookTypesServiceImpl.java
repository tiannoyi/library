package com.qf.service.impl;

import com.qf.entity.BookTypes;
import com.qf.entity.Books;
import com.qf.mapper.BookTypesMapper;
import com.qf.service.IBookTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypesServiceImpl implements IBookTypesService {
    @Autowired
    private BookTypesMapper bookTypesMapper;

    @Override
    public int insertBookTypes(BookTypes bookTypes) {
        return bookTypesMapper.insertSelective(bookTypes);
    }

    @Override
    public int deleteBookTypes(Integer bookTypeId) {
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeId(bookTypeId);
        bookTypes.setIsDelete(0);
        return bookTypesMapper.updateByPrimaryKeySelective(bookTypes);
    }

    @Override
    public int updateBookTypes(Integer bookTypeId) {
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeId(bookTypeId);
        return bookTypesMapper.updateByPrimaryKeySelective(bookTypes);
    }

    @Override
    public List<Books> getBooksByBookTypeId(Integer bookTypeId) {
        return null;
    }
}
