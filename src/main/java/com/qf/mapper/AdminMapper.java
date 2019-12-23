package com.qf.mapper;

import com.qf.entity.Admin;
import com.qf.entity.AdminExample;
import java.util.List;

import com.qf.entity.vo.AdminVo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 关联角色查询全部
     */
     List<AdminVo> selectAllVo();

    /**
     * 关联角色查询单个
     */
     AdminVo selectByPrimaryKeyVo(Integer adminId);
}