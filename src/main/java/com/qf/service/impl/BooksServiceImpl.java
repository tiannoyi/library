package com.qf.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ctc.wstx.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.entity.BooksWithBLOBs;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBooksService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService {
    @Autowired
    BooksMapper booksMapper;

    //通过ISBN查询对应的书,已测试
    @Override
    public Books selectBookByIsbn(String Isbn) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIsbnEqualTo(Isbn);
        List<Books> books = booksMapper.selectByExample(booksExample);
        boolean empty = books.isEmpty();
        if (empty){
            return null;
        }
        return books.get(0);
    }


    //查找全部书籍信息,已测试
    @Override
    public List<Books> selectBooksAll() {
        BooksExample booksExample = new BooksExample();
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    //通过部分条件查询对应的书籍信息,已测试
    @Override
    public List<Books> selectBooksByCondition(Books books) {
        BooksExample example = new BooksExample();
        BooksExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(books.getBookName())){
            criteria.andBookNameEqualTo(books.getBookName());
        }
        List<Books> books1 = booksMapper.selectByExample(example);
        if (books1.isEmpty()){
            return null;
        }
        return books1;
    }

    //选择性插入,已测试
    @Override
    public int insertBooks(BooksWithBLOBs booksWithBLOBs) {
        return booksMapper.insertSelective(booksWithBLOBs);
    }

    //通过 bookId 修改 is_delete 为0，已测试
    @Override
    public int deleteBookByBookId(Integer bookId) {
        return booksMapper.deleteBookById(bookId);
    }

    //通过ID对对应的书本信息进行修改,已测试
    @Override
    public int updateBookById(BooksWithBLOBs booksWithBLOBs,Integer bookId) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        return booksMapper.updateByExampleSelective(booksWithBLOBs,booksExample);
    }

    @Override
    public Page<Books> selectBooksList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        BooksExample booksExample = new BooksExample();
        List<Books> books = booksMapper.selectByExample(booksExample);
        int totalNum = booksMapper.selectTotalNum();
        Page<Books> page = new Page<>(currentPage,pageSize,totalNum);
        page.setList(books);
        return page;
    }
}
