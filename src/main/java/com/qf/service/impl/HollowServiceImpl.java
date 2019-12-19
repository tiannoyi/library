package com.qf.service.impl;


import com.qf.entity.Admin;
import com.qf.entity.AdminExample;
import com.qf.mapper.AdminMapper;
import com.qf.service.IHollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 22:03
 **/
@Service
public class HollowServiceImpl implements IHollowService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public String sayHollow(String name) {

        return "hello!"+name;
    }

    @Override
    public Admin testMapper() {
        return adminMapper.selectByPrimaryKey(1);
    }
}
