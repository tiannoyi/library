package com.qf.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 20:48
 **/
public class UserNameIsNullException extends AuthenticationException {

	public UserNameIsNullException() {
		super();
	}

	public UserNameIsNullException(String string) {
		super(string);
	}

}
