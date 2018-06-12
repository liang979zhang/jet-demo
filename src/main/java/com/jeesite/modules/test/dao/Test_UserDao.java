/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.Test_User;

/**
 * test_domeDAO接口
 * @author crk
 * @version 2018-06-12
 */
@MyBatisDao
public interface Test_UserDao extends CrudDao<Test_User> {
	
}