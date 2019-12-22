package com.qf.service;

import com.qf.entity.Readers;
import com.qf.mapper.ReadersMapper;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IReadersService {
    //添加读者(用户)
    int insertReader(Readers readers);

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

}
