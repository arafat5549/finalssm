package com.jqm.ssm.enums;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常 定义异常时，需要先确定异常所属模块。 例如：无效用户可以定义为 [10010001]
 * 前四位数为系统模块编号，后4位为错误代码 ,唯一。
 * 
 * @author yingjun
 *
 */
public enum ResultEnum {

	// 数据库想操作异常
	DB_INSERT_RESULT_ERROR(99990001, "db insert error"),
	DB_UPDATE_RESULT_ERROR(99990002, "db update error"),
	DB_SELECTONE_IS_NULL(99990003,"db select return null"),

	// 系统异常
	INNER_ERROR(99980001, "系统错误"), 
	TOKEN_IS_ILLICIT(99980002, "Token验证非法"), 
	SESSION_IS_OUT_TIME(99980003, "会话超时"),

	// 用户相关异常
	INVALID_USER(1001001, "无效用户"),
	UNAUTH_USER(1001002,"未授权用户"),
	UNLOGIN_USER(1001003,"未登录用户"),
	//部门
	INVALID_DEPARTMENT(1002001, "无效部门"),
	DEPT_DELETE_ERROR(1002005,"删除部门错误"),
	DEPT_SAVE_ERROR(1002006,"保存部门错误"),
	DEPT_UPDATE_ERROR(1002007,"更新部门错误"),
	//Token
	INVALID_TOKEN(8000001,"无效token");

	private int state;

	private String msg;

	ResultEnum(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public String getMsg() {
		return msg;
	}

	public static ResultEnum stateOf(int index) {
		for (ResultEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
