package com.qf.service;

import com.qf.entity.ReaderTypes;
import com.qf.util.Page;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.service
 * @description: TODO
 * @createTime: 2019/12/23 9:12
 * @version: 1.0
 */
public interface IReaderTypeService {
    /**
     * 插入新的 ReadTypes 信息
     *
     * @param readerTypes
     * @return
     */
    Integer insertReaderTypes(ReaderTypes readerTypes);

    /**
     * 通过主键 Id 删除对应单条信息
     *
     * @param readerTypeId
     * @return
     */
    Integer deleteReaderTypesByReaderTypeId(Integer readerTypeId);

    /**
     * 通过类别名删除对应类别全部信息
     *
     * @param readerTypeName
     * @return
     */
    Integer deleteReaderTypesByReaderTypeName(String readerTypeName);

    /**
     * 通过传入 Id 数组批量删除
     *
     * @param deleteIds
     * @return
     */
    Integer deleteBatchReaderTypesById(Integer[] deleteIds);

    /**
     * 通过主键 Id 更新对应记录
     *
     * @param readerTypes
     * @return
     */
    Integer updateReaderTypesByReadTypeId(ReaderTypes readerTypes);

    /**
     * 通过主键 Id 查询对应记录
     *
     * @param readerTypeId
     * @return
     */
    ReaderTypes selectReaderTypesByReadTypeId(Integer readerTypeId);

    /**
     * 分页查询对应未删除 readerType
     *
     * @param readerTypeName
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<ReaderTypes> selectReaderTypesByReaderTypeName(String readerTypeName, Integer currentPage, Integer pageSize);

    /**
     * 查询所有记录
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<ReaderTypes> selectAllReaderTypes(Integer currentPage, Integer pageSize);

    /**
     * 查询所有未删除记录
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<ReaderTypes> selectAllUnDeleteReaderTypes(Integer currentPage, Integer pageSize);

    /**
     * 查出全部未删除记录的数量
     *
     * @return
     */
    Integer selectCountUnDeleteReaderTypes();
}
