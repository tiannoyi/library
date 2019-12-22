package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.*;
import com.qf.entity.vo.BookStatesVo;
import com.qf.entity.vo.BooksVo;
import com.qf.mapper.BookStatesMapper;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBookStatesService;
import com.qf.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatesServiceImpl implements IBookStatesService {
    @Autowired
    private BookStatesMapper bookStatesMapper;
    @Autowired
    private BooksMapper booksMapper;

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

    //查看在馆的书籍的信息
    @Override
    public Page<Books> selectBooksByState(Integer state, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        BookStatesVo bookStatesVo = null;
        BooksVo booksVo = null;
        BookStatesExample bookStatesExample = new BookStatesExample();
        BookStatesExample.Criteria criteria = bookStatesExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        criteria.andStateEqualTo((byte)0);
        List<BookStates> bookStatesList = bookStatesMapper.selectByExample(bookStatesExample);
        for (BookStates bs : bookStatesList){
            BookStates bookStates = bookStatesMapper.selectByPrimaryKey(bs.getBookStateId());
            bookStatesVo = new BookStatesVo();
            BeanUtils.copyProperties(bookStates,bookStatesVo);
            BooksWithBLOBs books = booksMapper.selectByPrimaryKey(bookStates.getBookId());
            bookStatesVo.getBooks().add(books);
        }
        int count = bookStatesMapper.countByExample(bookStatesExample);
        Page<Books> booksPage = new Page<>(currentPage, pageSize, count);
        booksPage.setList(bookStatesVo.getBooks());
        return booksPage;
    }


}
