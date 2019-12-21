package com.qf.service.impl;

import com.qf.entity.System;
import com.qf.mapper.SystemMapper;
import com.qf.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements ISystemService {

    @Autowired
    SystemMapper systemMapper;

    @Override
    public Integer insertSystem(System system) {
        int i = systemMapper.insertSelective(system);
        return null;
    }
}
