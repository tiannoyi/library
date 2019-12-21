package com.qf.service;

import com.qf.entity.Readers;
import com.qf.mapper.ReadersMapper;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public interface IReadersService {
    //添加读者(用户)
    int insertReader(Readers readers);

    //删除用户
    int deleteReaderById(Integer readerId);

    //分页查找用户
    Page<Readers> selectReadersList(Integer currentPage);

    //修改读者信息
    int updateReaderById(Integer readerId, Readers readers);

}
