package service;

import po.Customers;

//客户业务功能
public interface CustomersService {
	// 根据用户名和密码查找客户
	public Customers selectByName(String username, String userpass);
}
