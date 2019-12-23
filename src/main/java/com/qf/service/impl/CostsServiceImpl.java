package com.qf.service.impl;


import com.github.pagehelper.PageHelper;
import com.qf.entity.Costs;
import com.qf.entity.CostsExample;
import com.qf.mapper.CostsMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.ICostsService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CostsServiceImpl implements ICostsService {
    @Autowired
    CostsMapper costsMapper;

    @Autowired
    SystemMapper systemMapper;

    @Override
    public Integer insertCost(Costs costs) {
        int i = costsMapper.insertSelective(costs);
        return i;
    }


    //修改金额流水表
    @Override
    public Integer updateByCostsId(Integer costsId, Costs costs) {
        CostsExample costsExample = new CostsExample();
        CostsExample.Criteria criteria = costsExample.createCriteria();
        criteria.andCostIdEqualTo(costsId);
        Integer i = costsMapper.updateByExampleSelective(costs, costsExample);
        return i;
    }

    //删除金额流水表
    @Override
    public Integer deleteByCostsId(Integer costsId) {
        CostsExample costsExample = new CostsExample();
        CostsExample.Criteria criteria = costsExample.createCriteria();
        criteria.andCostIdEqualTo(costsId);
        Costs costs = new Costs();
        costs.setIsDelete(0);
        Integer i = costsMapper.updateByExampleSelective(costs, costsExample);
        return i;
    }

    //分页查询所有金额流水表
    @Override
    public Page<Costs> selectCostsList(Integer currentPage, Integer pageSize) {
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        PageHelper.startPage(currentPage, pageSize);
        CostsExample costsExample = new CostsExample();
        costsExample.createCriteria().andIsDeleteEqualTo(1);
        List<Costs> allCosts = costsMapper.selectByExample(costsExample);
        int costsNum = costsMapper.countByExample(costsExample);
        Page<Costs> pageData = new Page<>(currentPage, pageSize, costsNum);
        pageData.setList(allCosts);
        return pageData;
    }

    //根据读者id分页查询金额流水表
    @Override
    public Page<Costs> selectCostsListByReaderId(Integer currentPage, Integer pageSize,Integer readerId) {
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        PageHelper.startPage(currentPage,pageSize);
        CostsExample costsExample = new CostsExample();
        costsExample.createCriteria().andIsDeleteEqualTo(1).andReaderIdEqualTo(readerId);
        List<Costs> costs = costsMapper.selectByExample(costsExample);
        int costsNum = costsMapper.countByExample(costsExample);
        Page<Costs> pageData = new Page<>(currentPage, pageSize, costsNum);
        pageData.setList(costs);
        return pageData;
    }
}
