package com.bankofshanghai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.AdminUserMapper;
import com.bankofshanghai.pojo.AdminUser;
import com.bankofshanghai.pojo.AdminUserExample;
import com.bankofshanghai.pojo.AdminUserExample.Criteria;
import com.bankofshanghai.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AdminUserMapper AdminMapper;

	@Override
	public int login(String username, String password) {
		AdminUserExample example = new AdminUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<AdminUser> list = AdminMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			//用户名不存在
			return 1;
		}
		AdminUser user = list.get(0);
		if(!user.getPassword().equals(password)) {
			//密码错误
			return 2;
		}
		return 0;
	}
	
	
}
