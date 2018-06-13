/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.Test_User;
import com.jeesite.modules.test.service.Test_UserService;

import java.util.List;

/**
 * test_domeController
 * @author crk
 * @version 2018-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test/test_User")
public class Test_UserController extends BaseController {

	@Autowired
	private Test_UserService test_UserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Test_User get(String id, boolean isNewRecord) {

		return test_UserService.get(id, isNewRecord);
	}

	@RequestMapping(value = "listName")
	@ResponseBody
	public String listData(String name, HttpServletRequest request, HttpServletResponse response) {
		Test_User test_user = new Test_User();
		test_user.setName(name);
		List<Test_User> list = test_UserService.findList(test_user);
		if(list!=null&&list.size()>0){
			return renderResult(Global.TRUE,"查询成功！",list);
		}else{
			return renderResult(Global.FALSE,"查询失败！",list);
		}
	}



	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("test:test_User:view")
	@RequestMapping(value = {"n ", ""})
	public String list(Test_User test_User, Model model) {
		model.addAttribute("test_User", test_User);
		return "modules/test/test_UserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("test:test_User:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Test_User> listData(Test_User test_User, HttpServletRequest request, HttpServletResponse response) {
		Page<Test_User> page = test_UserService.findPage(new Page<Test_User>(request, response), test_User); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("test:test_User:view")
	@RequestMapping(value = "form")
	public String form(Test_User test_User, Model model) {
		model.addAttribute("test_User", test_User);
		return "modules/test/test_UserForm";
	}

	/**
	 * 保存test_dome
	 */
	@RequiresPermissions("test:test_User:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Test_User test_User) {
		test_UserService.save(test_User);
		return renderResult(Global.TRUE, text("保存test_dome成功！"));
	}
	
	/**
	 * 删除test_dome
	 */
	@RequiresPermissions("test:test_User:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Test_User test_User) {
		test_UserService.delete(test_User);
		return renderResult(Global.TRUE, text("删除test_dome成功！"));
	}
	
}