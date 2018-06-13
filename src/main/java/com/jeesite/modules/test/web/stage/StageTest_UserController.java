/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web.stage;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.Test_User;
import com.jeesite.modules.test.service.Test_UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * test_domeController
 * @author crk
 * @version 2018-06-12
 * 前台接口
 */
@Controller
@RequestMapping(value = "${frontPath}/test/test_User")
public class StageTest_UserController extends BaseController {

	@Autowired
	private Test_UserService test_UserService;


	@RequestMapping(value = "listData")
	@ResponseBody
	public String listData(String name, HttpServletRequest request, HttpServletResponse response) {
		Test_User test_user = new Test_User();
		test_user.setName(name);
		List<Test_User> list = test_UserService.findList(test_user);
		if(list!=null&&list.size()>0){
			return renderResult(Global.YES,"查询成功！",list);
		}else{
			return renderResult(Global.NO,"查询失败！",list);
		}
	}




	@RequestMapping(value = "getageList")
	@ResponseBody
	public String getageList(Integer age, HttpServletRequest request, HttpServletResponse response) {
		Test_User test_user = new Test_User();
		test_user.setAge(age);
		List<Test_User> list = test_UserService.findList(test_user);
		if(list!=null&&list.size()>0){
			return renderResult(Global.YES,"查询成功！",list);
		}else{
			return renderResult(Global.NO,"查询失败！",list);
		}
	}


	
}