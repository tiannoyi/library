package com.qf.service;

import com.qf.entity.BorrowHistory;

import java.util.List;

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
     * 通过 borrowHistoryId 更新借阅历史
     *
     * @param borrowHistory
     * @return
     */
    Integer updateBorrowHistoryByBorrowHistoryId(BorrowHistory borrowHistory);

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
     * 通过 readerId 查询出该读者所有的借阅记录
     *
     * @param readerId 带有readerId 的读者对象
     * @return 该 readerId 对应读者所有的借阅记录
     */
    List<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId);

    /**
     * 查询 bookId 对应书籍所有的被借阅记录
     *
     * @param bookId 含 bookId 的 book 对象
     * @return bookId 的全部借阅记录
     */
    List<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId);

    /**
     * 查询全部未删除的借阅历史记录
     *
     * @return
     */
    List<BorrowHistory> selectAllBorrowHistory();



    /**
     * 提取全部借阅历史的数量
     *
     * @return All
     */
    Integer selectCountAllBorrowHistory();


}
