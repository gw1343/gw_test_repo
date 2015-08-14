/**
 * 
 * @Description: TODO
 * @author GalaxyTang
 * @mender GalaxyTang
 * @version 1.0
 * @date 2014-12-4 下午3:55:00
 */
package com.example.androidappframe.config;

public interface ReturnCode {

	//请求成功码
	public static final long SUCCESS_CODE = 1001;
	//请求失败
	public static final long FAIL_CODE = 1501;
	
	/***
	 * push 成功码
	 */
	public static final int PUSH_SUCCESS_CODE = 0;
	/***
	 * push 参数错误
	 */
	public static final int PUSH_PARA_ERROR_CODE = 65534;
	/***
	 * push 内部错误
	 */
	public static final int PUSH_INTERIOR_ERROR_CODE = 65535;
	/****
	 * 没找到key对应的节点
	 */
	public static final int PUSH_NOFOUND_KEY = 1001;
	
}
