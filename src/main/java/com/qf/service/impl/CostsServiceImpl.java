package com.qf.service.impl;


import com.github.pagehelper.PageHelper;
import com.qf.entity.Costs;
import com.qf.entity.CostsExample;
import com.qf.entity.vo.CostsVo;
import com.qf.mapper.CostsMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.ICostsService;
import com.qf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CostsServiceImpl implements ICostsService {
    @Autowired
    CostsMapper costsMapper;

    @Autowired
    SystemMapper systemMapper;
    @Override
    public Integer insertCost(Costs costs) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            costs.setCreateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
    public Page selectAllVo(Integer currentPage, Integer pageSize) {
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        PageHelper.startPage(currentPage, pageSize);
        List<CostsVo> costsVos = costsMapper.selectAllVo();
        int count = costsVos.size();
        Page<CostsVo> pageData = new Page<>(currentPage, pageSize, count);
        pageData.setList(costsVos);
        return pageData;
    }

    //根据读者id分页查询金额流水表
    @Override
    public Page selectByPrimaryKeyVo(Integer currentPage, Integer pageSize,Integer readerId) {
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null) {
            currentPage = 1;
        }
        PageHelper.startPage(currentPage,pageSize);
        List<CostsVo> costsVo = costsMapper.selectByPrimaryKeyVo(readerId);
        /*CostsExample costsExample = new CostsExample();
        costsExample.createCriteria().andIsDeleteEqualTo(1).andReaderIdEqualTo(readerId);
        List<Costs> costs = costsMapper.selectByExample(costsExample);*/
        int costsNum = costsVo.size();
        Page<CostsVo> page = new Page<>(currentPage, pageSize, costsNum);
        page.setList(costsVo);
        return page;
    }
}
