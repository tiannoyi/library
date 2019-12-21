package com.qf.service.impl;

import com.qf.entity.System;
import com.qf.entity.SystemExample;
import com.qf.mapper.SystemMapper;
import com.qf.service.ISystemService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SystemServiceImpl implements ISystemService {

    @Autowired
    SystemMapper systemMapper;

    @Override
    public Integer insertSystem(System system) {
        int i = systemMapper.insertSelective(system);
        return i;
    }

    @Override
    public Integer updateSystem(System system) {
        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteria = systemExample.createCriteria();
        criteria.andSysIdEqualTo(1);
        int i = systemMapper.updateByExampleSelective(system, systemExample);
        return i;
    }


}
