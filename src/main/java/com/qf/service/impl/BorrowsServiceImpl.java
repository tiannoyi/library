package com.qf.service.impl;

import com.qf.entity.Borrows;
import com.qf.entity.BorrowsExample;
import com.qf.mapper.BorrowsMapper;
import com.qf.service.IBorrowsService;
import com.qf.util.ChangliangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunJie
 * @className: BorrowsServiceImpl
 * @description: TODO
 * @createTime: 2019/12/20 15:21
 * @version: 1.0
 */
@Service
public class BorrowsServiceImpl implements IBorrowsService {
    @Autowired
    BorrowsMapper borrowsMapper;


    /**
     * 插入新的借阅记录
     *
     * @param borrows 带有数据的 borrows 对象
     * @return 影响行数
     */
    @Override
    public Integer insertBorrows(Borrows borrows) {
        if (borrows.getReaderId() != null && borrows.getReaderId() > 0
                && borrows.getBookStateId() != null && borrows.getBookStateId() > 0) {
            return borrowsMapper.insertSelective(borrows);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowsByBorrowId(Integer borrowsId) {
        if (borrowsId != null && borrowsId > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBorrowIdEqualTo(borrowsId);
            Borrows borrows = new Borrows();
            borrows.setIsDelete(0);
            return borrowsMapper.updateByExampleSelective(borrows, borrowsExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowsByBookStateId(Integer bookStateId) {
        if (bookStateId != null && bookStateId > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBookStateIdEqualTo(bookStateId);
            Borrows borrows = new Borrows();
            borrows.setIsDelete(0);
            return borrowsMapper.updateByExampleSelective(borrows, borrowsExample);
        }
        return ChangliangUtil.FAIL;
    }

    /**
     * 抽取的生成对象方法，有点多余
     *
     * @return 单例
     */
    private BorrowsExample getBorrowsExample() {
        return new BorrowsExample();
    }


    @Override
    public Integer updateBorrowsByBorrowId(Borrows borrows) {
        if (borrows.getBorrowId() != null && borrows.getBorrowId() > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBorrowIdEqualTo(borrows.getBorrowId());
            return borrowsMapper.updateByExampleSelective(borrows, borrowsExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrowsByBookStateId(Borrows borrows) {
        if (borrows.getBookStateId() != null && borrows.getBookStateId() > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBorrowIdEqualTo(borrows.getBookStateId());
            return borrowsMapper.updateByExampleSelective(borrows, borrowsExample);
        }
        return ChangliangUtil.FAIL;
    }


    /**
     * 根据 borrowsId 查询对应借阅事件
     *
     * @param borrowId 借阅事件对应的记录id
     * @return borrowsId 对应的借阅记录
     */
    @Override
    public Borrows selectBorrowsByBorrowId(Integer borrowId) {
        if (borrowId != null && borrowId > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBorrowIdEqualTo(borrowId);
            borrowsExampleCriteria.andIsDeleteEqualTo(1);
            List<Borrows> borrowsList = borrowsMapper.selectByExample(borrowsExample);
            if (!borrowsList.isEmpty()) {
                return borrowsList.get(0);
            }
        }
        return null;
    }

    @Override
    public Borrows selectBorrowsByBookStateId(Integer bookStateId) {
        if (bookStateId != null && bookStateId > 0) {
            BorrowsExample borrowsExample = getBorrowsExample();
            BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
            borrowsExampleCriteria.andBookStateIdEqualTo(bookStateId);
            borrowsExampleCriteria.andIsDeleteEqualTo(1);
            List<Borrows> borrowsList = borrowsMapper.selectByExample(borrowsExample);
            if (!borrowsList.isEmpty()) {
                return borrowsList.get(0);
            }
        }
        return null;
    }


    /**
     * 查询全部借阅记录
     *
     * @return 全部记录的list
     */
    @Override
    public List<Borrows> selectAll() {
        BorrowsExample borrowsExample = getBorrowsExample();
        List<Borrows> borrowsList = borrowsMapper.selectByExample(borrowsExample);
        if (!borrowsList.isEmpty()) {
            return borrowsList;
        }
        return null;
    }

    @Override
    public List<Borrows> selectAllUnDelete() {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        borrowsExampleCriteria.andIsDeleteEqualTo(1);
        List<Borrows> borrowsList = borrowsMapper.selectByExample(borrowsExample);
        if (!borrowsList.isEmpty()) {
            return borrowsList;
        }
        return null;
    }

    /**
     * 全部未删除的借阅记录数量
     *
     * @return 数量
     */
    @Override
    public Integer selectCountAllUnDeleteBorrows() {
        BorrowsExample borrowsExample = getBorrowsExample();
        BorrowsExample.Criteria borrowsExampleCriteria = borrowsExample.createCriteria();
        borrowsExampleCriteria.andIsDeleteEqualTo(1);
        return borrowsMapper.countByExample(borrowsExample);
    }

}
