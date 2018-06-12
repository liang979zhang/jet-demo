/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * test_domeEntity
 * @author crk
 * @version 2018-06-12
 */
@Table(name="test_dome", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="phone", attrName="phone", label="phone"),
		@Column(name="password", attrName="password", label="password"),
		@Column(name="age", attrName="age", label="age"),
	}, orderBy="a.id DESC"
)
public class Test_User extends DataEntity<Test_User> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String phone;		// phone
	private String password;		// password
	private Integer age;		// age
	
	public Test_User() {
		this(null);
	}

	public Test_User(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="phone长度不能超过 255 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=255, message="password长度不能超过 255 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge_gte() {
		return sqlMap.getWhere().getValue("age", QueryType.GTE);
	}

	public void setAge_gte(Integer age) {
		sqlMap.getWhere().and("age", QueryType.GTE, age);
	}
	
	public Integer getAge_lte() {
		return sqlMap.getWhere().getValue("age", QueryType.LTE);
	}

	public void setAge_lte(Integer age) {
		sqlMap.getWhere().and("age", QueryType.LTE, age);
	}
	
}