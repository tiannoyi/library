package com.qf.mapper;

import com.qf.entity.BookTypes;
import com.qf.entity.BookTypesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookTypesMapper {
    int countByExample(BookTypesExample example);

    int deleteByExample(BookTypesExample example);

    int deleteByPrimaryKey(Integer bookTypeId);

    int insert(BookTypes record);

    int insertSelective(BookTypes record);

    List<BookTypes> selectByExample(BookTypesExample example);

    BookTypes selectByPrimaryKey(Integer bookTypeId);

    int updateByExampleSelective(@Param("record") BookTypes record, @Param("example") BookTypesExample example);

    int updateByExample(@Param("record") BookTypes record, @Param("example") BookTypesExample example);

    int updateByPrimaryKeySelective(BookTypes record);

    int updateByPrimaryKey(BookTypes record);
}