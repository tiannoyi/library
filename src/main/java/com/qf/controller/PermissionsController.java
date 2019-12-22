package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.Permissions;
import com.qf.service.IPermissionsService;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/permissions")
    public State selectAll(Integer currentPage, Integer pageSize){
        Page page = permissionsService.selectAll(currentPage, pageSize);
        if (StringUtils.isEmpty(page)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",page);
    }

    @GetMapping("/permissions/{permissionId}")
    public State selectByPrimaryKey(@PathVariable Integer permissionId){
        Permissions permissions = permissionsService.selectPrimaryKey(permissionId);
        if (StringUtils.isEmpty(permissions)){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        return packaging(StateCode.SUCCESS,"查询成功",permissions);
    }

}
