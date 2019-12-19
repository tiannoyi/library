package com.qf.mapper;

import com.qf.entity.BookStates;
import com.qf.entity.BookStatesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookStatesMapper {
    int countByExample(BookStatesExample example);

    int deleteByExample(BookStatesExample example);

    int deleteByPrimaryKey(Integer bookStateId);

    int insert(BookStates record);

    int insertSelective(BookStates record);

    List<BookStates> selectByExample(BookStatesExample example);

    BookStates selectByPrimaryKey(Integer bookStateId);

    int updateByExampleSelective(@Param("record") BookStates record, @Param("example") BookStatesExample example);

    int updateByExample(@Param("record") BookStates record, @Param("example") BookStatesExample example);

    int updateByPrimaryKeySelective(BookStates record);

    int updateByPrimaryKey(BookStates record);
}