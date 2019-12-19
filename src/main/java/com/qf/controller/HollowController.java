package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Admin;
import com.qf.service.IHollowService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-17 22:03
 **/
@RestController
public class HollowController extends Base {
    @Autowired
    IHollowService iHollowService;
    @RequestMapping("/hellow")
    public State<Object> HollowController(){
        Admin admin = iHollowService.testMapper();
        return packaging(StateCode.SUCCESS,"查询成功",admin);
    }

}
