package com.qf.service;

import com.qf.entity.Books;
import com.qf.entity.Readers;
import com.qf.entity.vo.ReadersVo;
import com.qf.exception.SystemErrorException;
import com.qf.exception.UserNameExistException;
import com.qf.util.Page;

public interface IReadersService {
    //添加读者(用户)
    Readers insertReader(Readers readers) throws UserNameExistException, SystemErrorException;

    //删除用户
    int deleteReaderById(Integer readerId);

    //分页查询用户
    Page<Readers> selectAllReaders(Integer currentPage,Integer pageSize);

    //修改读者信息
    int updateReaderById(Integer readerId, Readers readers);

    //多条件查询对应的用户信息
    Page<Readers> selectReaderByCondition(Integer currentPage,Integer pageSize,Readers readers);

    //批量删除
    int deleteBatch(int [] readerIds);

    //查询所有的书本数据
    Page<ReadersVo> selectReadersVo(Integer currentPage, Integer pageSize);

    //通过id 查询对应的读者信息
    Readers selectById(Integer readerId);
}
