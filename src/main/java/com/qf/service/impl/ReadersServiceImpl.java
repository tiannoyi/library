package com.qf.service.impl;

import com.qf.entity.Readers;
import com.qf.mapper.ReadersMapper;
import com.qf.service.IReadersService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadersServiceImpl implements IReadersService {
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

    @Override
    public Page<Readers> selectReadersList(Integer currentPage) {
        Page<Readers> page = new Page<>();
        page.setCurrentPage(currentPage);
        return null;
    }


    //修改读者信息测试可行
    @Override
    public int updateReaderById(Integer readerId,Readers readers) {
        readers.setReaderId(readerId);
        return readersMapper.updateByPrimaryKeySelective(readers);
    }
}
