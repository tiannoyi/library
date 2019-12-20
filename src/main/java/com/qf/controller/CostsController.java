package com.qf.controller;

import com.qf.controller.base.Base;
import com.qf.entity.Costs;
import com.qf.service.ICostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costs")
public class CostsController extends Base {
    @Autowired
    ICostsService costsService;

    @RequestMapping("/insert")
    private int insertCosts(Costs costs){
        Integer i = costsService.insertCost(costs);
        return i;
    }

}
