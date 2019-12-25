package com.qf.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ctc.wstx.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.entity.BooksWithBLOBs;
import com.qf.entity.vo.BooksVo;
import com.qf.mapper.BooksMapper;
import com.qf.mapper.SystemMapper;
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
    @Autowired
    SystemMapper systemMapper;


    //通过ISBN查询对应的书,已测试
    @Override//返回的是一个对象,正常来说,一个ISBN是对应一种书
    public Books selectBookByIsbn(String Isbn) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIsbnEqualTo(Isbn);
        criteria.andIsDeleteEqualTo(1);
        List<Books> books = booksMapper.selectByExample(booksExample);
        if (books.isEmpty()){
            return null;
        }
        return books.get(0);
    }
    @Override
    public Page<Books> selectBookByIsbn(String Isbn,Integer currentPage, Integer pageSize) {
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage,pageSize);
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIsbnEqualTo(Isbn);
        criteria.andIsDeleteEqualTo(1);
        List<Books> books = booksMapper.selectByExample(booksExample);
        int totalNum = booksMapper.countByExample(booksExample);
        Page<Books> page = new Page<>(currentPage,pageSize,totalNum);
        page.setList(books);
        boolean empty = books.isEmpty();
        if (empty){
            return null;
        }
        return page;
    }




    //查找全部书籍信息,已测试
    @Override
    public List<Books> selectBooksAll() {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        List<Books> books = booksMapper.selectByExample(booksExample);
        if (books.isEmpty()){
            return null;
        }
        return books;
    }

    //通过部分条件查询对应的书籍信息
    @Override
    public Page<Books> selectBooksByCondition(Books books,Integer currentPage, Integer pageSize) {
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage,pageSize);
        BooksExample example = new BooksExample();
        BooksExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        //书名
        if(!StringUtils.isEmpty(books.getBookName())){
            criteria.andBookNameEqualTo(books.getBookName());
        }
        //作者
        if(!StringUtils.isEmpty(books.getAuthor())){
            criteria.andAuthorEqualTo(books.getAuthor());
        }
        //分类号
        if(!StringUtils.isEmpty(books.getClassNumber())){
            criteria.andClassNumberEqualTo(books.getClassNumber());
        }
        //价格
        if(!StringUtils.isEmpty(books.getPrice())){
            criteria.andPriceEqualTo(books.getPrice());
        }
        /*//书的类型id,不可以加上,加上会报错,类型id必填
        if(!StringUtils.isEmpty(books.getBookTypeId()+"")){
            criteria.andBookTypeIdEqualTo(books.getBookTypeId());
        }*/
        //出版社
        if(!StringUtils.isEmpty(books.getPress())){
            criteria.andPressEqualTo(books.getPress());
        }
        //页数
        if(!StringUtils.isEmpty(books.getIsbn())){
            criteria.andIsbnEqualTo(books.getIsbn());
        }
        List<Books> books1 = booksMapper.selectByExample(example);
        int totalNum = booksMapper.countByExample(example);
        Page<Books> page = new Page<>(currentPage,pageSize,totalNum);
        page.setList(books1);
        if (books1.isEmpty()){
            return null;
        }
        return page;
    }

    //选择性插入,已测试
    @Override
    public int insertBooks(BooksWithBLOBs booksWithBLOBs) {
        return booksMapper.insertSelective(booksWithBLOBs);
    }

    //通过 bookId 修改 is_delete 为0，已测试
    @Override
    public int deleteBookByBookId(Integer bookId) {
        BooksWithBLOBs booksWithBLOBs = new BooksWithBLOBs();
        booksWithBLOBs.setIsDelete(0);
        booksWithBLOBs.setBookId(bookId);
        return booksMapper.updateByPrimaryKeySelective(booksWithBLOBs);
    }

    //通过ID对对应的书本信息进行修改,已测试
    @Override
    public int updateBookById(BooksWithBLOBs booksWithBLOBs,Integer bookId) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andBookIdEqualTo(bookId);
        return booksMapper.updateByExampleSelective(booksWithBLOBs,booksExample);
    }

    //分页查询所有书本信息
    @Override
    public Page<Books> selectAllBooks(Integer currentPage, Integer pageSize) {
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage,pageSize);
        BooksExample booksExample = new BooksExample();
        booksExample.createCriteria().andIsDeleteEqualTo(1);
        List<Books> books = booksMapper.selectByExample(booksExample);
        int totalNum = booksMapper.countByExample(booksExample);
        Page<Books> page = new Page<>(currentPage,pageSize,totalNum);
        page.setList(books);
        return page;
    }

    @Override
    public Page<BooksVo> selectAllVo(Integer currentPage, Integer pageSize) {
        if(pageSize == null)
            pageSize = systemMapper.getPageLine();
        if (currentPage == null)
            currentPage = 1;
        PageHelper.startPage(currentPage,pageSize);
        List<BooksVo> booksVos = booksMapper.selectAllVo();
        Integer count = booksVos.size();
        Page<BooksVo> page = new Page<>(currentPage, pageSize, count);
        page.setList(booksVos);
        return page;
    }

    @Override//先不写,有疑问
    public int selectBookIdByBookName(String bookName) {
        return 0;
    }

    //批量删除,测试可行
    @Override
    public int deleteBatch(int[] bookIds) {
        BooksWithBLOBs booksWithBLOBs = new BooksWithBLOBs();
        int count = 0;
        for (int i = 0;i < bookIds.length;i++){
            booksWithBLOBs.setIsDelete(0);
            booksWithBLOBs.setBookId(bookIds[i]);
            booksMapper.updateByPrimaryKeySelective(booksWithBLOBs);
            count++;
        }
        if (count != bookIds.length){
            return 0;
        }
        return count;
    }

    @Override
    public int insertBatch(BooksWithBLOBs[] booksWithBLOBs) {
        return 0;
    }
}
