package com.qf.mapper;

import com.qf.entity.Costs;
import com.qf.entity.CostsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostsMapper {
    int countByExample(CostsExample example);

    int deleteByExample(CostsExample example);

    int deleteByPrimaryKey(Integer costId);

    int insert(Costs record);

    int insertSelective(Costs record);

    List<Costs> selectByExample(CostsExample example);

    Costs selectByPrimaryKey(Integer costId);

    int updateByExampleSelective(@Param("record") Costs record, @Param("example") CostsExample example);

    int updateByExample(@Param("record") Costs record, @Param("example") CostsExample example);

    int updateByPrimaryKeySelective(Costs record);

    int updateByPrimaryKey(Costs record);
}