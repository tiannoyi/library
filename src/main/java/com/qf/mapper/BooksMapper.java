package com.qf.mapper;

import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.entity.BooksWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooksMapper {
    int countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BooksWithBLOBs record);

    int insertSelective(BooksWithBLOBs record);

    List<BooksWithBLOBs> selectByExampleWithBLOBs(BooksExample example);

    List<Books> selectByExample(BooksExample example);

    BooksWithBLOBs selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") BooksWithBLOBs record, @Param("example") BooksExample example);

    int updateByExampleWithBLOBs(@Param("record") BooksWithBLOBs record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKeySelective(BooksWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BooksWithBLOBs record);

    int updateByPrimaryKey(Books record);

    //查询数据总条数
    int selectTotalNum();
    //通过Id 删除对应的书本（修改is_delete为0）
    int deleteBookById(Integer bookId);
}