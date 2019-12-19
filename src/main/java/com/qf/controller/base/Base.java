package com.qf.controller.base;

import com.qf.constan.StateCode;
import com.qf.util.State;

public class Base {

	/**
	 * 状态包装
	 */
	public State<Object> packaging(StateCode success, String message, Object data) {
		return new State<Object>(success, message, data);
	}
}
