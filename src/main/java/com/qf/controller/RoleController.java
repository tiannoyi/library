package com.qf.controller;

import com.qf.aspect.OperationLogger;
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
    public State<Object> selectAll(Integer currentPage, Integer pageSize){
        return packaging(StateCode.SUCCESS,"查询成功",roleService.selectAll(currentPage, pageSize));
    }

    @GetMapping("/rolesAll")
    public Object selectAlls(){
        return packaging(StateCode.SUCCESS,"查询成功",roleService.selectAlls());
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
    @OperationLogger(modelName = "添加",opEntity = "角色",option = "/roles")
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
    @OperationLogger(modelName = "修改",opEntity = "角色",option = "/roles/updateId")
    public State<Object> updateRole(@PathVariable("roleId")Integer roleId,@RequestBody Roles roles){
        roles.setRoleId(roleId);
        Integer integer = roleService.updateByPrimaryKey(roles);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"修改成功",roleId);
        }
        return packaging(StateCode.FAIL,"修改失败",roleId);
    }


    @OperationLogger(modelName = "删除",opEntity = "单个角色",option = "/roles/{roleId}")
    @DeleteMapping("/roles/{roleId}")
    public State<Object> deleteRole(@PathVariable Integer roleId){
        Integer integer = roleService.deleteRole(roleId);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"删除成功",roleId);
        }
        return packaging(StateCode.FAIL,"删除失败",roleId);
    }

    @OperationLogger(modelName = "添加",opEntity = "多个角色",option = "/roles/{roleIds}")
    @DeleteMapping("/roles/ids/{roleIds}")
    public Object deleteRoles(@PathVariable String roleIds){
        if(StringUtils.isEmpty(roleIds)){
            return packaging(StateCode.FAIL,"删除失败",null);
        }
        String[] split = roleIds.split(",");
        for (int i = 0; i < split.length; i++) {
            roleService.deleteRole(Integer.parseInt(split[i]));
        }
        return packaging(StateCode.SUCCESS,"删除成功",roleIds);
    }

}
