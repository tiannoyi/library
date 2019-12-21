package com.qf.service.impl;

import com.qf.entity.BorrowHistory;
import com.qf.entity.BorrowHistoryExample;
import com.qf.entity.BorrowsExample;
import com.qf.mapper.BorrowHistoryMapper;
import com.qf.service.IBorrowHistoryService;
import com.qf.service.IBorrowsService;
import com.qf.util.ChangliangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.service.impl
 * @description: TODO
 * @createTime: 2019/12/20 22:49
 * @version: 1.0
 */
@Service
public class BorrowsHistoryServiceImpl implements IBorrowHistoryService {
    @Autowired
    BorrowHistoryMapper borrowHistoryMapper;

    @Override
    public Integer insertBorrowHistory(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() != null && borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() != null && borrowHistory.getBookId() > 0
                && borrowHistory.getBorrowTime() != null
        ) {
            return borrowHistoryMapper.insert(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrow(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() > 0
                && borrowHistory.getHistoryId() != null
        ) {
            return borrowHistoryMapper.updateByPrimaryKey(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public Integer deleteBorrowHistoryByHistoryId(Integer historyId) {
        return getDeleteResult(historyId);
    }

    @Override
    public Integer deleteBorrowHistoryByBookId(Integer bookId) {
        return getDeleteResult(bookId);
    }


    @Override
    public Integer deleteBorrowHistoryByReaderId(Integer readerId) {
        return getDeleteResult(readerId);
    }

    /**
     * 抽取的根据 Id 删除记录方法
     *
     * @param deleteId
     * @return 结果
     */
    private Integer getDeleteResult(Integer deleteId) {
        BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
        BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
        if (deleteId != null && deleteId > 0) {
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            borrowHistoryExampleCriteria.andBookIdEqualTo(deleteId);
            borrowHistoryExampleCriteria.andIsDeleteEqualTo(1);
            return borrowHistoryMapper.updateByExample(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public List<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId) {
        return getSelectByIdResult(readerId);
    }


    @Override
    public List<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId) {
        return getSelectByIdResult(bookId);
    }

    /**
     * 抽取的根据 Id 得到对应的全部借阅历史
     *
     * @param selectId
     * @return 借阅历史的集合 list
     */
    private List<BorrowHistory> getSelectByIdResult(Integer selectId) {
        if (selectId != null && selectId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            borrowHistoryExampleCriteria.andReaderIdEqualTo(selectId);
            borrowHistoryExampleCriteria.andIsDeleteEqualTo(1);
            return borrowHistoryMapper.selectByExample(borrowHistoryExample);
        }
        return null;
    }


    @Override
    public Integer selectCountAllBorrowHistory() {
        BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
        BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
        borrowHistoryExampleCriteria.andIsDeleteEqualTo(1);
        return borrowHistoryMapper.countByExample(borrowHistoryExample);
    }
}