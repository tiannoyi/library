package com.qf.service.impl;

import com.qf.entity.BorrowHistory;
import com.qf.entity.BorrowHistoryExample;
import com.qf.mapper.BorrowHistoryMapper;
import com.qf.service.IBorrowHistoryService;
import com.qf.util.ChangliangUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
                && StringUtils.isEmpty(borrowHistory.getBorrowTime())
        ) {
            return borrowHistoryMapper.insert(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrowHistoryByBorrowHistoryId(BorrowHistory borrowHistory) {
        if (borrowHistory.getHistoryId() != null && borrowHistory.getHistoryId() > 0
        ) {
            return borrowHistoryMapper.updateByPrimaryKeySelective(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer updateBorrowHistoryByReaderIdAndBookId(BorrowHistory borrowHistory) {
        if (borrowHistory.getReaderId() != null && borrowHistory.getReaderId() > 0
                && borrowHistory.getBookId() != null && borrowHistory.getBookId() > 0
        ) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            borrowHistoryExampleCriteria.andReaderIdEqualTo(borrowHistory.getReaderId());
            borrowHistoryExampleCriteria.andBookIdEqualTo(borrowHistory.getBookId());
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public BorrowHistory selectBorrowHistoryByHistoryId(Integer historyId) {
        if (historyId != null && historyId > 0) {
            return borrowHistoryMapper.selectByPrimaryKey(historyId);
        }
        return null;
    }


    @Override
    public List<BorrowHistory> selectBorrowHistoryByReaderId(Integer readerId) {
        if (readerId != null && readerId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            borrowHistoryExampleCriteria.andReaderIdEqualTo(readerId);
            borrowHistoryExampleCriteria.andIsDeleteEqualTo(1);
            List<BorrowHistory> borrowHistories = borrowHistoryMapper.selectByExample(borrowHistoryExample);
            if (!borrowHistories.isEmpty()) {
                return borrowHistories;
            }
        }
        return null;
    }


    @Override
    public List<BorrowHistory> selectBorrowHistoryByBookId(Integer bookId) {
        if (bookId != null && bookId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            borrowHistoryExampleCriteria.andBookIdEqualTo(bookId);
            borrowHistoryExampleCriteria.andIsDeleteEqualTo(1);
            List<BorrowHistory> borrowHistories = borrowHistoryMapper.selectByExample(borrowHistoryExample);
            if (!borrowHistories.isEmpty()) {
                return borrowHistories;
            }
        }
        return null;
    }

    @Override
    public Integer deleteBorrowHistoryByHistoryId(Integer historyId) {
        if (historyId != null && historyId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            borrowHistory.setHistoryId(historyId);
            return borrowHistoryMapper.updateByPrimaryKeySelective(borrowHistory);
        }
        return ChangliangUtil.FAIL;
    }

    @Override
    public Integer deleteBorrowHistoryByBookId(Integer bookId) {
        if (bookId != null && bookId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            borrowHistoryExampleCriteria.andBookIdEqualTo(bookId);
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public Integer deleteBorrowHistoryByReaderId(Integer readerId) {
        if (readerId != null && readerId > 0) {
            BorrowHistoryExample borrowHistoryExample = new BorrowHistoryExample();
            BorrowHistoryExample.Criteria borrowHistoryExampleCriteria = borrowHistoryExample.createCriteria();
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setIsDelete(0);
            borrowHistoryExampleCriteria.andReaderIdEqualTo(readerId);
            return borrowHistoryMapper.updateByExampleSelective(borrowHistory, borrowHistoryExample);
        }
        return ChangliangUtil.FAIL;
    }


    @Override
    public List<BorrowHistory> selectAllBorrowHistory() {
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