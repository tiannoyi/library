package com.qf.util;

import java.util.UUID;


/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 20:15
 **/
/**
 * 生成文件名
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}