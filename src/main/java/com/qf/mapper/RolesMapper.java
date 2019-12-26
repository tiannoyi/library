package com.qf.mapper;

import com.qf.entity.Roles;
import com.qf.entity.RolesExample;
import java.util.List;

import com.qf.entity.vo.RolesVo;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
    int countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    Roles selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    //查询对应id增强角色
    RolesVo selectByPrimaryKeyVo(Integer RoleId);

    //查询所有角色
    List<RolesVo> selectAllVo();
}