package com.qf.service;

import com.qf.entity.BorrowHistory;
import com.qf.util.Page;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.service
 * @description: TODO
 * @createTime: 2019/12/20 20:45
 * @version: 1.0
 */
public interface IBorrowHistoryService {
    /**
     * 插入新的借阅记录
     *
     * @param borrowHistory 包含数据的对象
     * @return 插入结果
     */
    Integer insertBorrowHistory(BorrowHistory borrowHistory);

    /**
     * historyId 删除单个对应的记录
     *
     * @param historyId 主键 Id
     * @return 结果
     */
    Integer deleteBorrowHistoryByHistoryId(Integer historyId);

    /**
     * 删除某本书的借阅历史
     *
     * @param bookId 书本单一 Id
     * @return 结果
     */
    Integer deleteBorrowHistoryByBookId(Integer bookId);

    /**
     * 删除该读者对应的全部借阅记录
     *
     * @param readerId 读者编号
     * @return 结果（通常为 >0
     */
    Integer deleteBorrowHistoryByReaderId(Integer readerId);

    /**
     * 通过 HistoryId 批量删除
     *
     * @param borrowHistoryIds
     * @return
     */
    Integer deleteBatchByHistoryId(Integer[] borrowHistoryIds);

    /**
     * 通过 HistoryId 更新借阅历史
     *
     * @param borrowHistory
     * @return
     */
    Integer updateBorrowHistoryByHistoryId(BorrowHistory borrowHistory);

    /**
     * 通过读者id 和书本id 更新历史借阅记录
     *
     * @param borrowHistory
     * @return
     */
    Integer updateBorrowHistoryByReaderIdAndBookId(BorrowHistory borrowHistory);

    /**
     * 通过唯一历史id 查询信息
     *
     * @param historyId
     * @return
     */
    BorrowHistory selectBorrowHistoryByHistoryId(Integer historyId);

    /**
     * 分页通过 ReaderId 查询出对应所有借阅历史
     *
     * @param readerId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId, Integer currentPage, Integer pageSize);

    /**
     * 分页通过 BookId 查询出所有借阅历史
     *
     * @param bookId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId, Integer currentPage, Integer pageSize);

    /**
     * 查询所有未删除借阅历史
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<BorrowHistory> selectAllUnDeleteBorrowHistory(Integer currentPage, Integer pageSize);

    /**
     * 查询所有借阅历史
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<BorrowHistory> selectAllBorrowHistory(Integer currentPage, Integer pageSize);

    /**
     * 提取全部未删除借阅历史的数量
     *
     * @return All
     */
    Integer selectCountAllBorrowHistory();


}
