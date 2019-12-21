package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Roles;
import com.qf.service.IRoleService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //添加角色
    @PostMapping("/roles")
    public State<Object> insertRole(Roles role){
        Integer integer = roleService.insertRole(role);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"添加成功",null );
        }
        return packaging(StateCode.FAIL,"添加失败",null);
    }
}
