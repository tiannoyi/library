package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.*;
import com.qf.entity.vo.BookTypesVo;
import com.qf.mapper.BookTypesMapper;
import com.qf.mapper.BooksMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.IBookTypesService;
import com.qf.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypesServiceImpl implements IBookTypesService {
    @Autowired
    private BookTypesMapper bookTypesMapper;
    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private SystemMapper systemMapper;


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
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
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

    //一对多,通过类目ID 查询对应的书本信息
    @Override
    public Page<Books> selectBooksByBookTypesId(Integer currentPage, Integer pageSize, Integer bookTypeId) {
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage,pageSize);
        BookTypesVo bookTypesVo = new BookTypesVo();
        BookTypes bookTypes = bookTypesMapper.selectByPrimaryKey(bookTypeId);
        BeanUtils.copyProperties(bookTypes,bookTypesVo);
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andBookTypeIdEqualTo(bookTypes.getBookTypeId());
        criteria.andIsDeleteEqualTo(1);
        List<Books> booksList = booksMapper.selectByExample(booksExample);
        //遍历获取到的书本信息集合
        for (Books books: booksList){
            //通过对应的书本ID 查到对应的对象
            BooksWithBLOBs bs = booksMapper.selectByPrimaryKey(books.getBookId());
            bookTypesVo.getBooks().add(bs);
        }
        int count = booksMapper.countByExample(booksExample);
        Page<Books> booksPage = new Page<>(currentPage, pageSize, count);
        booksPage.setList(bookTypesVo.getBooks());
        return booksPage;
    }
}
