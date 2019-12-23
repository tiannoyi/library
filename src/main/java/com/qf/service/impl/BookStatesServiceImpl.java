package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.BookStates;
import com.qf.entity.BookStatesExample;
import com.qf.mapper.BookStatesMapper;
import com.qf.service.IBookStatesService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatesServiceImpl implements IBookStatesService {
    @Autowired
    private BookStatesMapper bookStatesMapper;

    //选择性内容添加,已测试
    @Override
    public int insertBookStates(BookStates bookStates) {
        return bookStatesMapper.insertSelective(bookStates);
    }

    //删除已测试
    @Override
    public int deleteBookStates(Integer bookStateId) {
        BookStates bookStates = new BookStates();
        bookStates.setBookStateId(bookStateId);
        bookStates.setIsDelete(0);
        return bookStatesMapper.updateByPrimaryKeySelective(bookStates);
    }

    //修改已测试
    @Override
    public int updateBookStates(Integer bookStateId,BookStates bookStates) {
        bookStates.setBookStateId(bookStateId);
        return bookStatesMapper.updateByPrimaryKeySelective(bookStates);
    }

    //分页查询所有
    @Override
    public Page<BookStates> selectAllBookStates(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        BookStatesExample bookStatesExample = new BookStatesExample();
        BookStatesExample.Criteria criteria = bookStatesExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        List<BookStates> bookStates = bookStatesMapper.selectByExample(bookStatesExample);
        int count = bookStatesMapper.countByExample(bookStatesExample);
        Page<BookStates> page = new Page<>(currentPage, pageSize, count);
        page.setList(bookStates);
        return page;
    }

    //通过在馆id查询对应的在馆信息
    @Override
    public BookStates selectStateByBookStateId(Integer bookStateId) {
        BookStatesExample bookStatesExample = new BookStatesExample();
        BookStatesExample.Criteria criteria = bookStatesExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        criteria.andBookStateIdEqualTo(bookStateId);
        List<BookStates> bookStates = bookStatesMapper.selectByExample(bookStatesExample);
        if (bookStates == null){
            return null;
        }
        return bookStates.get(0);
    }


}
