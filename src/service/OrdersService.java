package service;

import po.Customers;
import vo.Cart;

//����ҵ����
public interface OrdersService {
	public int saveOrders(Cart cart, Customers cust);
}