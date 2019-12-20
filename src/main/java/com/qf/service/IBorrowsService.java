package com.qf.service;

import com.qf.entity.Borrows;

import java.net.Inet4Address;
import java.util.List;

/**
 * @author: JunJie
 * @className: IBorrowsService
 * @description: TODO
 * @createTime: 2019/12/20 15:09
 * @version: 1.0
 */
public interface IBorrowsService {
    /**
     * 插入新的借阅记录
     *
     * @param borrows 带有数据的 borrows 对象
     * @return 影响行数（插入结果 1成功 0失败
     */
    Integer insertBorrows(Borrows borrows);

    /**
     * 传入 borrowId 删除单个的借阅记录
     *
     * @param borrowId 对应的 borrowId
     * @return 影响行数（删除结果 1成功 0失败
     */
    Integer deleteBorrowsByBorrowId(Integer borrowId);


    /**
     * 传入 bookStateId 删除该在馆id的借阅情况
     *
     * @param bookStateId
     * @return
     */
    Integer deleteBorrowsByBookStateId(Integer bookStateId);

    /**
     * 通过 borrow 对象修改对应的借阅记录
     *
     * @param borrows 需要修改借阅记录的 borrow 对象
     * @return 修改结果 （1成功 0失败
     */
    Integer updateBorrows(Borrows borrows);

    /**
     * 查询全部借阅事件
     *
     * @return 全部借阅记录
     */
    List<Borrows> selectAll();

    /**
     * 根据对应的 borrow_id 查询对应的借阅记录
     *
     * @param borrowId 借阅事件对应的记录id
     * @return borrowId 对应的借阅记录
     */
    Borrows selectBorrowsByBorrowId(Integer borrowId);

    /**
     * 通过书本 bookStateId 查出该书本的借阅情况
     *
     * @param bookStateId 在馆Id
     * @return 对应借阅记录
     */
    Borrows selectBorrowsByBookStateId(Integer bookStateId);

}
