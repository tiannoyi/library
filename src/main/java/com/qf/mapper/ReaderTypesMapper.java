package com.qf.mapper;

import com.qf.entity.ReaderTypes;
import com.qf.entity.ReaderTypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderTypesMapper {
    int countByExample(ReaderTypesExample example);

    int deleteByExample(ReaderTypesExample example);

    int deleteByPrimaryKey(Integer readerTypeId);

    int insert(ReaderTypes record);

    int insertSelective(ReaderTypes record);

    List<ReaderTypes> selectByExample(ReaderTypesExample example);

    ReaderTypes selectByPrimaryKey(Integer readerTypeId);

    int updateByExampleSelective(@Param("record") ReaderTypes record, @Param("example") ReaderTypesExample example);

    int updateByExample(@Param("record") ReaderTypes record, @Param("example") ReaderTypesExample example);

    int updateByPrimaryKeySelective(ReaderTypes record);

    int updateByPrimaryKey(ReaderTypes record);
}