package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Costs;
import com.qf.service.ICostsService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costs")
public class CostsController extends Base {
    @Autowired
    ICostsService costsService;

    @PostMapping("/insertCosts")
    public State<Object> insertCosts(Costs costs){
        Integer i = costsService.insertCost(costs);
        if (i != null) {
            return packaging(StateCode.SUCCESS,"插入成功", i);
        }else {
            return packaging(StateCode.FAIL,"插入失败", null);
        }

    }

    @GetMapping("/selectCostsAll")
    public Object selectCostsAll(Integer currentPage, Integer pageSize){
        Page costs = costsService.selectAllVo(currentPage, pageSize);
        return packaging(StateCode.SUCCESS,"查询成功",costs);
    }

    @GetMapping("/selectCostsByReaderId")
    public State<Object> selectCostsByReaderId(Integer readerid, Integer currentPage, Integer pageSize){
        Page costs = costsService.selectByPrimaryKeyVo(readerid, currentPage, pageSize);
        if (costs.getList().size() != 0) {
            return packaging(StateCode.SUCCESS,"查询成功",costs);
        }else {
            return packaging(StateCode.FAIL,"查询失败",costs);
        }

    }

    @PutMapping("/updateByCostsId")
    public  State<Object> updateByCostsId(Integer costsId, Costs costs){
        costs.setCostId(costsId);
        Integer i = costsService.updateByCostsId(costsId, costs);
        if (i != null) {
            return packaging(StateCode.SUCCESS,"修改成功", i);
        }else {
            return packaging(StateCode.FAIL,"修改失败", null);
        }

    }

    @PutMapping("/deleteCostsByCostsId")
    public State<Object> deleteCostsByCostsId(Integer costsId){
        Integer i = costsService.deleteByCostsId(costsId);
        if (i != null) {
            return packaging(StateCode.SUCCESS,"删除成功",costsId);
        }else {
            return packaging(StateCode.FAIL,"删除失败",null);
        }
    }

    @DeleteMapping("/deleteAll")
    public Object deleteAll(String costsId){
        if (costsId == null) {
            return packaging(StateCode.FAIL,"删除成功",null);
        }
        String[] split = costsId.split(",");
        for (int i = 0; i < split.length; i++) {
            costsService.deleteByCostsId(Integer.parseInt(split[i]));
        }
        return packaging(StateCode.SUCCESS,"删除成功",costsId);
    }

}
