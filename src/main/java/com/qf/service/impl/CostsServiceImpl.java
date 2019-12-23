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

//    @Override
//    public List<Costs> selectCostsAll() {
//        CostsExample costsExample = new CostsExample();
//        CostsExample.Criteria criteria = costsExample.createCriteria();
//        criteria.andIsDeleteEqualTo(1);
//        List<Costs> costs = costsMapper.selectByExample(costsExample);
//        if (costs.isEmpty()) {
//            return null;
//        }
//        return costs;
//    }

    @Override
    public List<Costs> selectCostsByReaderId(Integer readerId) {
        CostsExample costsExample = new CostsExample();
        CostsExample.Criteria criteria = costsExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        criteria.andIsDeleteEqualTo(1);
        List<Costs> costs = costsMapper.selectByExample(costsExample);
        if (costs.isEmpty()) {
            return null;
        }
        return costs;
    }

    @Override
    public Integer updateByCostsId(Integer costsId, Costs costs) {
        CostsExample costsExample = new CostsExample();
        CostsExample.Criteria criteria = costsExample.createCriteria();
        criteria.andCostIdEqualTo(costsId);
        Integer i = costsMapper.updateByExampleSelective(costs, costsExample);
        return i;
    }

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

    @Override
    public Page<Costs> selectCostsList(Integer currentPage, Integer pageSize) {
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        PageHelper.startPage(currentPage, pageSize);
        CostsExample costsExample = new CostsExample();
        costsExample.createCriteria().andIsDeleteEqualTo(1);
//        costsExample.setOrderByClause("costId desc");
        List<Costs> allCosts = costsMapper.selectByExample(costsExample);
        int costsNum = costsMapper.countByExample(costsExample);
        Page<Costs> pageData = new Page<>(currentPage, pageSize, costsNum);
        pageData.setList(allCosts);
        return pageData;
    }
}
