package com.qf.mapper;

import com.qf.entity.Books;
import com.qf.entity.BooksExample;
import com.qf.entity.BooksWithBLOBs;
import java.util.List;

import com.qf.entity.vo.BooksVo;
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

    //关联类别、在馆表查询书本信息
    List<BooksVo> selectAllVo();
    //通过某一条件查询对应的书本信息
    BooksVo selectBookVo(Books books);
}