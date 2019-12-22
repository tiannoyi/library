package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Roles;
import com.qf.service.IRoleService;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    //查询指定id的角色
    @GetMapping("/roles/{roleId}")
    public State<Object> selectRole(@PathVariable Integer roleId){
        Roles roles = roleService.selectByPrimaryKey(roleId);
        if (StringUtils.isEmpty(roles)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",roles);
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

    //修改角色信息
    @PutMapping("/roles/{roleId}")
    public State<Object> updateRole(@PathVariable("roleId")Integer roleId,Roles roles){
        roles.setRoleId(roleId);
        Integer integer = roleService.updateByPrimaryKey(roles);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"修改成功",roleId);
        }
        return packaging(StateCode.FAIL,"修改失败",roleId);
    }

    @DeleteMapping("/roles/{roleId}")
    public State<Object> deleteRole(@PathVariable Integer roleId){
        Integer integer = roleService.deleteRole(roleId);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"删除成功",roleId);
        }
        return packaging(StateCode.FAIL,"删除失败",roleId);
    }

}
