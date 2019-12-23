package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Admin;
import com.qf.entity.Permissions;
import com.qf.entity.PermissionsExample;
import com.qf.entity.Roles;
import com.qf.entity.vo.Menu;
import com.qf.entity.vo.RolesVo;
import com.qf.exception.NotLoginException;
import com.qf.mapper.PermissionsMapper;
import com.qf.mapper.SystemMapper;
import com.qf.service.IPermissionsService;
import com.qf.service.IRoleService;
import com.qf.util.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 21:00
 **/
@Service
public class PermissionsServiceImpl implements IPermissionsService {
    @Autowired
    IRoleService iRoleService;

    @Autowired
    PermissionsMapper permissionsMapper;

    @Autowired
    SystemMapper systemMapper;

    @Override
    public List<Permissions> selectPermissions(Integer roleId) {
        RolesVo rolesVo = iRoleService.selectByPrimaryKeyVo(roleId);
        List<Permissions> permissions = rolesVo.getPermissions();
        return permissions;
    }

    @Override
    public List<Permissions> selectAlls() {
        PermissionsExample example = new PermissionsExample();
        example.createCriteria().andIsDeleteEqualTo(1);
        List<Permissions> permissions = permissionsMapper.selectByExample(example);
        return permissions;
    }

    @Override
    public List<Menu> selectMenu() throws NotLoginException {
        Admin admin = (Admin)SecurityUtils.getSubject().getSession().getAttribute("admin");
        if (StringUtils.isEmpty(admin)){
            throw new NotLoginException();
        }
        List<Permissions> permissions = selectPermissions(admin.getRoleId());
        List<Menu> menus = new ArrayList<Menu>();
        for (Permissions p1 : permissions) {
            if (p1.getFatherNode() == 0) {
                Menu menu = new Menu();
                menu.setPermissions(p1);
                for (Permissions p2 : permissions) {
                    if (p2.getFatherNode() == p1.getPermissionId()) {
                        menu.getList().add(p2);
                    }
                }
                menus.add(menu);
            }
        }
        return menus;
    }

    @Override
    public Page selectAll(Integer currentPage, Integer pageSize) {
        if(pageSize == null){
            pageSize = systemMapper.getPageLine();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        PageHelper.startPage(currentPage, pageSize);
        PermissionsExample example = new PermissionsExample();
        example.createCriteria().andIsDeleteEqualTo(1);
        example.setOrderByClause("permission_id desc");
        List<Permissions> permissions = permissionsMapper.selectByExample(example);
        int permissionsNum = permissionsMapper.countByExample(example);
        Page<Permissions> pageData = new Page<>(currentPage, pageSize, permissionsNum);
        pageData.setList(permissions);
        return pageData;
    }

    @Override
    public Permissions selectPrimaryKey(Integer permissionId) {
        Permissions permissions = permissionsMapper.selectByPrimaryKey(permissionId);
        return permissions;
    }

    @Override
    public Integer insertPermission(Permissions permissions) {
        return permissionsMapper.insertSelective(permissions);
    }

    @Override
    public Integer updatePermission(Permissions permissions) {
        return permissionsMapper.updateByPrimaryKeySelective(permissions);
    }

    @Override
    public Integer deletePermission(Integer permissionId) {
        Permissions permissions = new Permissions();
        permissions.setPermissionId(permissionId);
        permissions.setIsDelete(0);
        return permissionsMapper.updateByPrimaryKeySelective(permissions);
    }
}
