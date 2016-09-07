package com.bankofshanghai.service;

public interface UserService {
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 0：成功；1：用户名不存在；2：密码错误
	 */
	int login(String username, String password);
}
