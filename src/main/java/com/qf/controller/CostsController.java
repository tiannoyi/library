package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Costs;
import com.qf.service.ICostsService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/costs")
public class CostsController extends Base {
    @Autowired
    ICostsService costsService;

    @PostMapping("/insertCosts")
    private State<Object> insertCosts(Costs costs){
        Integer i = costsService.insertCost(costs);
        if (i != null) {
            return packaging(StateCode.SUCCESS,"插入成功", i);
        }else {
            return packaging(StateCode.FAIL,"插入失败", null);
        }

    }

    @GetMapping("/selectCostsAll")
    private State<Object> selectCostsAll(){
        List<Costs> costs = costsService.selectCostsAll();
        return packaging(StateCode.SUCCESS,"查询成功",costs);
    }

    @GetMapping("/selectCostsByReaderId")
    private State<Object> selectCostsByReaderId(Integer readerid){
        List<Costs> costs = costsService.selectCostsByReaderId(readerid);
        return packaging(StateCode.SUCCESS,"查询成功",costs);
    }

    @PutMapping("/updateByCostsId")
    private  State<Object> updateByCostsId(Integer costsId, Costs costs){
        Integer i = costsService.updateByCostsId(costsId, costs);
        if (i != null) {
            return packaging(StateCode.SUCCESS,"修改成功", i);
        }else {
            return packaging(StateCode.FAIL,"修改失败", null);
        }

    }

    @PutMapping("/deleteCostsByCostsId")
    private State<Object> deleteCostsByCostsId(Integer costsId){
        Integer i = costsService.deleteByCostsId(costsId);
        return packaging(StateCode.SUCCESS,"删除成功",i);
    }

}
