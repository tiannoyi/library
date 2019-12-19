package com.qf.mapper;

import com.qf.entity.BorrowHistory;
import com.qf.entity.BorrowHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowHistoryMapper {
    int countByExample(BorrowHistoryExample example);

    int deleteByExample(BorrowHistoryExample example);

    int deleteByPrimaryKey(Integer historyId);

    int insert(BorrowHistory record);

    int insertSelective(BorrowHistory record);

    List<BorrowHistory> selectByExample(BorrowHistoryExample example);

    BorrowHistory selectByPrimaryKey(Integer historyId);

    int updateByExampleSelective(@Param("record") BorrowHistory record, @Param("example") BorrowHistoryExample example);

    int updateByExample(@Param("record") BorrowHistory record, @Param("example") BorrowHistoryExample example);

    int updateByPrimaryKeySelective(BorrowHistory record);

    int updateByPrimaryKey(BorrowHistory record);
}