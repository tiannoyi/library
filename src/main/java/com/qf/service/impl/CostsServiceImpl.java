package com.qf.service.impl;


import com.qf.entity.Costs;
import com.qf.entity.CostsExample;
import com.qf.mapper.CostsMapper;
import com.qf.service.ICostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostsServiceImpl implements ICostsService {
    @Autowired
    CostsMapper costsMapper;
    @Override
    public Integer insertCost(Costs costs) {
        int i = costsMapper.insertSelective(costs);
        return i;
    }
}
