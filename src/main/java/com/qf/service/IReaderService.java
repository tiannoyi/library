package com.qf.service;

import com.qf.entity.Readers;
import com.qf.mapper.ReadersMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IReaderService {
    //添加读者(用户)
    int insertReader(Readers readers);

    //删除用户
    int deleteReaderById(Integer readerId);

    //分页查找用户


    //修改读者信息
    int updateReaderById(Integer readerId,Readers readers);
}
