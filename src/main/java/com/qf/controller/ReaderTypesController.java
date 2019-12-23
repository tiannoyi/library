package com.qf.controller;

import com.qf.constan.StateCode;
import com.qf.controller.base.Base;
import com.qf.entity.ReaderTypes;
import com.qf.mapper.SystemMapper;
import com.qf.service.IReaderTypeService;
import com.qf.util.ChangliangUtil;
import com.qf.util.Page;
import com.qf.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author: JunJie
 * @classBelongTo: library.com.qf.controller
 * @description: TODO
 * @createTime: 2019/12/23 11:58
 * @version: 1.0
 */
@RestController
@RequestMapping("/readerTypes")
public class ReaderTypesController extends Base {
    @Autowired
    IReaderTypeService readerTypeService;

    @Autowired
    SystemMapper systemMapper;

    /**
     * 添加新的读者类别，测试通过
     *
     * @param readerTypes
     * @return
     */
    @PostMapping("/insertReaderTypes")
    public State<Object> insertReaderTypes(ReaderTypes readerTypes) {
        if (readerTypes != null) {
            return readerTypeService.insertReaderTypes(readerTypes) > 0 ?
                    packaging(StateCode.SUCCESS, "新读者类型" + ChangliangUtil.INSERTSUCCESS, null)
                    : packaging(StateCode.FAIL, "新读者类型" + ChangliangUtil.INSERTFAIL, null);
        }
        return packaging(StateCode.FAIL, "信息不完整", null);
    }

    /**
     * 通过 readerTypeId 删除对应单一记录，测试通过
     *
     * @param readerTypeId
     * @return
     */
    @DeleteMapping("/deleteReaderTypesByReaderTypeId")
    public State<Object> deleteReaderTypesByReaderTypeId(Integer readerTypeId) {
        if (readerTypeId != null && readerTypeId > 0) {
            return readerTypeService.deleteReaderTypesByReaderTypeId(readerTypeId) > 0 ?
                    packaging(StateCode.SUCCESS, "readerTypeId:" + readerTypeId + "的读者类型" + ChangliangUtil.DELETESUCCESS, null)
                    : packaging(StateCode.FAIL, "readerTypeId:" + readerTypeId + "的读者类型" + ChangliangUtil.DELETEFAIL, null);
        }
        return packaging(StateCode.FAIL, "传入信息为空", null);
    }

    /**
     * 删除对应 readerTypeName 记录，测试通过
     *
     * @param readerTypeName
     * @return
     */
    @DeleteMapping("/deleteReaderTypesByReaderTypeName")
    public State<Object> deleteReaderTypesByReaderTypeName(String readerTypeName) {
        if (readerTypeName != null && !"".equals(readerTypeName)) {
            return readerTypeService.deleteReaderTypesByReaderTypeName(readerTypeName) > 0 ?
                    packaging(StateCode.SUCCESS, "readerTypeName:" + readerTypeName + "的读者类型" + ChangliangUtil.DELETESUCCESS, null)
                    : packaging(StateCode.FAIL, "readerTypeName:" + readerTypeName + "的读者类型" + ChangliangUtil.DELETEFAIL, null);
        }
        return packaging(StateCode.FAIL, "传入信息为空", null);
    }

    /**
     * 批量删除
     *
     * @param deleteIds
     * @return
     */
    @DeleteMapping("/deleteBatchReaderTypesById")
    public State<Object> deleteBatchReaderTypesById(Integer[] deleteIds) {
        if (deleteIds != null && deleteIds.length > 0) {
            return readerTypeService.deleteBatchReaderTypesById(deleteIds) > 0 ?
                    packaging(StateCode.SUCCESS, "批量删除读者类别" + ChangliangUtil.DELETESUCCESS, null)
                    : packaging(StateCode.FAIL, "批量删除读者类别" + ChangliangUtil.DELETEFAIL, null);
        }
        return packaging(StateCode.FAIL, "传入信息为空", null);
    }

    /**
     * 通过 readerTypeId 更新对应记录，测试通过
     *
     * @param readerTypes
     * @return
     */
    @PutMapping("/updateReaderTypesByReadTypeId")
    public State<Object> updateReaderTypesByReadTypeId(ReaderTypes readerTypes) {
        if (readerTypes != null && readerTypes.getReaderTypeId() != null && readerTypes.getReaderTypeId() > 0) {
            return readerTypeService.updateReaderTypesByReadTypeId(readerTypes) > 0 ?
                    packaging(StateCode.SUCCESS, "借阅情况" + ChangliangUtil.UPDATESUCCESS, null)
                    : packaging(StateCode.FAIL, "借阅情况" + ChangliangUtil.UPDATEFAIL, null);
        }
        return packaging(StateCode.FAIL, "信息不完整，或请传入ReaderTypeId", null);
    }

    /**
     * 通过 readerTypeId 查询单一对应的记录
     *
     * @param readerTypeId
     * @return
     */
    @GetMapping("/selectReaderTypesByReadTypeId")
    public State<Object> selectReaderTypesByReadTypeId(Integer readerTypeId) {
        if (readerTypeId != null && readerTypeId > 0) {
            ReaderTypes readerTypes = readerTypeService.selectReaderTypesByReadTypeId(readerTypeId);
            return readerTypes != null ?
                    packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, readerTypes)
                    : packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, null);
        }
        return packaging(StateCode.FAIL, "传入信息不完整", null);
    }

    /**
     * 查询 readerTypeName 对应的所有记录，测试通过
     *
     * @param readerTypeName
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/selectReaderTypesByReaderTypeName")
    public State<Object> selectReaderTypesByReaderTypeName(String readerTypeName, Integer currentPage, Integer pageSize) {
        if (currentPage == null) {
            return packaging(StateCode.FAIL, "请输入当前页", null);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        if (readerTypeName != null && !"".equals(readerTypeName)) {
            Page<ReaderTypes> pageList = readerTypeService.selectReaderTypesByReaderTypeName(readerTypeName, currentPage, pageSize);
            return pageList.getList().size() != 0 ?
                    packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, pageList)
                    : packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, null);
        }
        return packaging(StateCode.FAIL, "传入信息不完整", null);
    }

    /**
     * 查询所有借阅历史，测试通过
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllReaderTypes")
    public State<Object> selectAllReaderTypes(Integer currentPage, Integer pageSize) {
        if (currentPage == null) {
            return packaging(StateCode.FAIL, "请输入当前页", null);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<ReaderTypes> pageList = readerTypeService.selectAllReaderTypes(currentPage, pageSize);
        return pageList.getList().size() != 0 ?
                packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, pageList)
                : packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, null);
    }


    /**
     * 查询所有未删除记录，测试通过
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllUnDeleteReaderTypes")
    public State<Object> selectAllUnDeleteReaderTypes(Integer currentPage, Integer pageSize) {
        if (currentPage == null) {
            return packaging(StateCode.FAIL, "请输入当前页", null);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = systemMapper.getPageLine();
        }
        Page<ReaderTypes> pageList = readerTypeService.selectAllUnDeleteReaderTypes(currentPage, pageSize);
        return pageList.getList().size() != 0 ?
                packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, pageList)
                : packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, null);
    }
}
