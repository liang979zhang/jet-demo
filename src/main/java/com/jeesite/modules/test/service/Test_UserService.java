/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.entity.Test_User;
import com.jeesite.modules.test.dao.Test_UserDao;

/**
 * test_domeService
 * @author crk
 * @version 2018-06-12
 */
@Service
@Transactional(readOnly=true)
public class Test_UserService extends CrudService<Test_UserDao, Test_User> {
	
	/**
	 * 获取单条数据
	 * @param test_User
	 * @return
	 */
	@Override
	public Test_User get(Test_User test_User) {
		return super.get(test_User);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param test_User
	 * @return
	 */
	@Override
	public Page<Test_User> findPage(Page<Test_User> page, Test_User test_User) {
		return super.findPage(page, test_User);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param test_User
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Test_User test_User) {
		super.save(test_User);
	}
	
	/**
	 * 更新状态
	 * @param test_User
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Test_User test_User) {
		super.updateStatus(test_User);
	}
	
	/**
	 * 删除数据
	 * @param test_User
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Test_User test_User) {
		super.delete(test_User);
	}
	
}