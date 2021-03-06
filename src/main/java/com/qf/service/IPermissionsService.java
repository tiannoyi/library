package com.qf.service;

import com.qf.entity.Permissions;
import com.qf.entity.vo.Menu;
import com.qf.exception.NotLoginException;
import com.qf.util.Page;

import java.util.List;

public interface IPermissionsService {
    //根据角色id查询对应权限
    List<Permissions> selectPermissions(Integer roleId);

    List<Permissions> selectAlls();

    //查询菜单
    List<Menu> selectMenu() throws NotLoginException;

    //查询所有权限
    Page selectAll(Integer currentPage, Integer pageSize);

    //通过权限id查询对应权限
    Permissions selectPrimaryKey(Integer permissionId);

    //添加权限
    Integer insertPermission(Permissions permissions);

    //修改权限
    Integer updatePermission(Permissions permissions);

    //删除权限
    Integer deletePermission(Integer permissionId);

}
