package service;

import po.Customers;

//�ͻ�ҵ����
public interface CustomersService {
	// �����û�����������ҿͻ�
	public Customers selectByName(String username, String userpass);
}
