package com.qf.exception;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-22 20:48
 **/
public class UserNameExistException extends Exception {

	public UserNameExistException() {
		super();
	}

	public UserNameExistException(String string) {
		super(string);
	}

}
