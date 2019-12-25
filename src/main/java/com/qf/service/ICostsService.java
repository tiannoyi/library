package com.qf.service;

import com.qf.entity.Costs;
import com.qf.entity.vo.CostsVo;
import com.qf.util.Page;

import java.util.List;

public interface ICostsService {

    //添加到金额流水表
    Integer insertCost(Costs costs);


//    List<Costs> selectCostsAll();


//    List<Costs> selectCostsByReaderId(Integer readerId);

    //修改金额流水表
    Integer updateByCostsId(Integer costsId , Costs costs);

    //通过订单号删除订单
    Integer deleteByCostsId(Integer costsId);

    //查询所有账单
    Page selectAllVo(Integer currentPage, Integer pageSize);

    //通过读者id查询金额流水表
    Page selectByPrimaryKeyVo(Integer currentPage, Integer pageSize, Integer readerId);

}
