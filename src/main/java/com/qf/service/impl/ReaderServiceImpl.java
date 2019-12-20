package com.qf.service.impl;

import com.qf.entity.Readers;
import com.qf.mapper.ReadersMapper;
import com.qf.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements IReaderService {
    @Autowired
    private ReadersMapper readersMapper;


    //添加已测试可行
    @Override
    public int insertReader(Readers readers) {
        return readersMapper.insertSelective(readers);
    }

    //已测试可行
    @Override
    public int deleteReaderById(Integer readerId) {
        Readers readers = new Readers();
        readers.setReaderId(readerId);
        readers.setIsDelete(0);
        return readersMapper.updateByPrimaryKeySelective(readers);
    }


    //修改读者信息测试可行
    @Override
    public int updateReaderById(Integer readerId,Readers readers) {
        readers.setReaderId(readerId);
        return readersMapper.updateByPrimaryKeySelective(readers);
    }
}
