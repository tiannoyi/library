package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.entity.Logs;
import com.qf.entity.LogsExample;
import com.qf.entity.Permissions;
import com.qf.entity.vo.LogsVo;
import com.qf.mapper.LogsMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.ILogService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-25 19:17
 **/
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    LogsMapper logsMapper;
    @Autowired
    SystemMapper systemMapper;

    @Override
    public Page selectAll(Integer currentPage, Integer pageSize) {
        if (pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage, pageSize);
        LogsExample logsExample = new LogsExample();
        logsExample.createCriteria().andIsDeleteEqualTo(1);
        List<LogsVo> logsVos = logsMapper.selectAll();
        int count = logsMapper.countByExample(logsExample);
        Page<LogsVo> pageData = new Page<>(currentPage, pageSize, count);
        pageData.setList(logsVos);
        return pageData;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertLog(Logs logs) {
        logsMapper.insertSelective(logs);
    }
}
