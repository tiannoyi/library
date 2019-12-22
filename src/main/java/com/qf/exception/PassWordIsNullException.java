package com.qf.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 20:48
 **/
public class PassWordIsNullException extends AuthenticationException {


	public PassWordIsNullException() {
		super();
	}

	public PassWordIsNullException(String string) {
		super(string);
	}
}
