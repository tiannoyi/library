package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Permissions;
import com.qf.service.IPermissionsService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 20:57
 **/
@RestController
public class PermissionsController extends Base {
    @Autowired
    IPermissionsService permissionsService;

    //查询所有权限
    @GetMapping("/permissions")
    public State selectAll(Integer currentPage, Integer pageSize){
        Page page = permissionsService.selectAll(currentPage, pageSize);
        if (StringUtils.isEmpty(page)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",page);
    }

    //根据id查询指定权限
    @GetMapping("/permissions/{permissionId}")
    public State selectByPrimaryKey(@PathVariable Integer permissionId){
        Permissions permissions = permissionsService.selectPrimaryKey(permissionId);
        if (StringUtils.isEmpty(permissions)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",permissions);
    }

    //添加权限
    @PostMapping("/permissions")
    public State insertPermission(Permissions permissions){
        if (StringUtils.isEmpty(permissions)){
            return packaging(StateCode.FAIL,"添加失败",null);
        }
        Integer integer = permissionsService.insertPermission(permissions);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"添加成功",permissions);
        }
        return packaging(StateCode.FAIL, "添加失败", null);
    }

    //修改权限
    @PutMapping("/permissions/{permissionsId}")
    public State updatePermission(@PathVariable Integer permissionsId,Permissions permissions){
        if (StringUtils.isEmpty(permissions)){
            return packaging(StateCode.FAIL,"修改失败",null);
        }
        if (StringUtils.isEmpty(permissionsId)){
            return packaging(StateCode.FAIL,"修改失败",null);
        }
        permissions.setPermissionId(permissionsId);
        Integer integer = permissionsService.updatePermission(permissions);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"修改成功",permissions);
        }
        return  packaging(StateCode.FAIL,"修改失败",null);
    }

    //删除权限
    @DeleteMapping("/permissions/{permissionsId}")
    public State deletePermission(@PathVariable Integer permissionsId){
        if (StringUtils.isEmpty(permissionsId)){
            return  packaging(StateCode.FAIL,"删除失败",null);
        }
        Integer integer = permissionsService.deletePermission(permissionsId);
        if (integer > 0){
            return packaging(StateCode.SUCCESS,"删除成功",permissionsId);
        }
        return packaging(StateCode.FAIL,"删除失败",null);
    }

}
