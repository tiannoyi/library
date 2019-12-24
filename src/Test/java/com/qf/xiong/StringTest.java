package com.qf.xiong;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-23 18:38
 **/
public class StringTest {
    @Test
    public void testDemo() {
        /*String[] str = {"2", "3", null};
        System.out.println(Arrays.toString(str));*/
        String a = "123fggs2fg6";
        for (int i = 0; i < a.length(); i++) {
            String one = a.substring(i, i + 1);
            char ar = one.charAt(0);
            if (ar >= '0' && ar <= '9') {
                //是数字
                System.out.println(ar);
            }
        }
    }
}
