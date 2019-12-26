package com.qf.entity.vo;

import com.qf.entity.Admin;
import com.qf.entity.Logs;
import lombok.Data;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-25 21:29
 **/
@Data
public class LogsVo extends Logs {
    private Admin admin;
}
