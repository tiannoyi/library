package com.qf.mapper;

import com.qf.entity.Readers;
import com.qf.entity.ReadersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReadersMapper {
    int countByExample(ReadersExample example);

    int deleteByExample(ReadersExample example);

    int deleteByPrimaryKey(Integer readerId);

    int insert(Readers record);

    int insertSelective(Readers record);

    List<Readers> selectByExample(ReadersExample example);

    Readers selectByPrimaryKey(Integer readerId);

    int updateByExampleSelective(@Param("record") Readers record, @Param("example") ReadersExample example);

    int updateByExample(@Param("record") Readers record, @Param("example") ReadersExample example);

    int updateByPrimaryKeySelective(Readers record);

    int updateByPrimaryKey(Readers record);
}