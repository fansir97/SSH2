package service;

import po.Customers;
import vo.Cart;

//订单业务功能
public interface OrdersService {
	public int saveOrders(Cart cart, Customers cust);
}