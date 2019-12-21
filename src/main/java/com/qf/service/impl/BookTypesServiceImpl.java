package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.BookTypes;
import com.qf.entity.BookTypesExample;
import com.qf.entity.Books;
import com.qf.mapper.BookTypesMapper;
import com.qf.service.IBookTypesService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypesServiceImpl implements IBookTypesService {
    @Autowired
    private BookTypesMapper bookTypesMapper;

    //添加已测试
    @Override
    public int insertBookTypes(BookTypes bookTypes) {
        return bookTypesMapper.insertSelective(bookTypes);
    }

    //删除已测试
    @Override
    public int deleteBookTypes(Integer bookTypeId) {
        BookTypes bookTypes = new BookTypes();
        bookTypes.setBookTypeId(bookTypeId);
        bookTypes.setIsDelete(0);
        return bookTypesMapper.updateByPrimaryKeySelective(bookTypes);
    }

    //修改已测试
    @Override
    public int updateBookTypes(Integer bookTypeId,BookTypes bookTypes) {
        BookTypesExample bookTypesExample = new BookTypesExample();
        BookTypesExample.Criteria criteria = bookTypesExample.createCriteria();
        criteria.andBookTypeIdEqualTo(bookTypeId);
        return bookTypesMapper.updateByExampleSelective(bookTypes,bookTypesExample);
    }

    //查询书本的所有类目,已测试
    @Override
    public Page<BookTypes> selectAllBookTypes(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        BookTypesExample bookTypesExample = new BookTypesExample();
        BookTypesExample.Criteria criteria = bookTypesExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        List<BookTypes> bookTypes = bookTypesMapper.selectByExample(bookTypesExample);
        int count = bookTypesMapper.countByExample(bookTypesExample);
        Page<BookTypes> bookTypesPage = new Page<>(currentPage, pageSize, count);
        bookTypesPage.setList(bookTypes);
        return bookTypesPage;
    }
}
