package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.service.IRoleService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-21 16:17
 **/
@RestController
public class RoleController extends Base {
    @Autowired
    IRoleService roleService;

    //查询所有角色
    @GetMapping("/roles")
    public State<Object> selectAll(Integer pageNum, Integer pageSize){
        return packaging(StateCode.SUCCESS,"查询成功",roleService.selectAll(pageNum, pageSize));
    }
}
