package com.qf.service.impl;

import com.ctc.wstx.util.StringUtil;
import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.mapper.BooksMapper;
import com.qf.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService {
    @Autowired
    BooksMapper booksMapper;

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

    @Override
    public List<Books> selectAll() {

        return null;
    }
}
