package com.qf.service;

import com.qf.entity.Roles;
import com.qf.entity.vo.RolesVo;
import com.qf.util.Page;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-21 14:07
 **/
public interface IRoleService {
    //查询所有角色
    Page<Roles> selectAll(Integer currentPage,Integer pageSize);

    //查询单个增强角色
    RolesVo selectByPrimaryKeyVo(Integer roleId);

    //查询当个角色
    Roles selectByPrimaryKey(Integer roleId);

    //更新角色信息
    Integer updateByPrimaryKey(Roles roles);

    //新增角色
    Integer insertRole(Roles role);

    //删除角色
    Integer deleteRole(Integer id);
}
