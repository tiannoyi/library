package com.qf.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.qf.entity.Readers;
import com.qf.entity.ReadersExample;
import com.qf.mapper.ReadersMapper;
import com.qf.service.IReadersService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadersServiceImpl implements IReadersService {
    @Autowired
    private ReadersMapper readersMapper;


    //选择性内容添加,已测试可行
    @Override
    public int insertReader(Readers readers) {
        return readersMapper.insertSelective(readers);
    }

    //删除,已测试可行
    @Override
    public int deleteReaderById(Integer readerId) {
        Readers readers = new Readers();
        readers.setReaderId(readerId);
        readers.setIsDelete(0);
        return readersMapper.updateByPrimaryKeySelective(readers);
    }

    @Override
    public Page<Readers> selectAllReaders(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        ReadersExample readersExample = new ReadersExample();
        ReadersExample.Criteria criteria = readersExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        int count = readersMapper.countByExample(readersExample);
        List<Readers> readers = readersMapper.selectByExample(readersExample);
        Page<Readers> page = new Page<>(currentPage, pageSize, count);
        page.setList(readers);
        return page;
    }


    //修改读者信息,测试可行
    @Override
    public int updateReaderById(Integer readerId,Readers readers) {
        readers.setReaderId(readerId);
        return readersMapper.updateByPrimaryKeySelective(readers);
    }

    //多条件查询对应的用户信息
    @Override
    public Page<Readers> selectReaderByCondition(Integer currentPage,Integer pageSize,Readers readers) {
        PageHelper.startPage(currentPage,pageSize);
        ReadersExample readersExample = new ReadersExample();
        ReadersExample.Criteria criteria = readersExample.createCriteria();
        criteria.andIsDeleteEqualTo(1);
        //读者姓名
        if (!StringUtils.isEmpty(readers.getReaderName())){
            criteria.andReaderNameEqualTo(readers.getReaderName());
        }
        //密码
        if (!StringUtils.isEmpty(readers.getPassword())){
            criteria.andPasswordEqualTo(readers.getPassword());
        }
        //地址
        if (!StringUtils.isEmpty(readers.getAddress())){
            criteria.andAddressEqualTo(readers.getAddress());
        }
        //性别
        if (!StringUtils.isEmpty(readers.getSex())){
            criteria.andSexEqualTo(readers.getSex());
        }
        //是否在馆 0或1
        if (!StringUtils.isEmpty(readers.getState())){
            criteria.andStateEqualTo(readers.getState());
        }
        //ID card
        if (!StringUtils.isEmpty(readers.getIdCard())){
            criteria.andIdCardEqualTo(readers.getIdCard());
        }
        if (!StringUtils.isEmpty(readers.getPhone())){
            criteria.andPhoneEqualTo(readers.getPhone());
        }
        List<Readers> readers1 = readersMapper.selectByExample(readersExample);
        int count = readersMapper.countByExample(readersExample);
        System.out.println(count);
        Page<Readers> page = new Page<>(currentPage, pageSize, count);
        page.setList(readers1);
        return page;
    }

    @Override
    public int deleteBatch(int[] readerIds) {
        Readers readers = new Readers();
        int count = 0;
        for (int i = 0;i < readerIds.length;i++){
            readers.setReaderId(readerIds[i]);
            readers.setIsDelete(0);
            readersMapper.updateByPrimaryKeySelective(readers);
            count++;
        }
        if (count != readerIds.length){
            return 0;
        }
        return count;
    }
}
