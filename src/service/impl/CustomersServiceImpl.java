package service.impl;

import java.util.List;
import base.GenericDao;
import po.Customers;
import service.CustomersService;

public class CustomersServiceImpl implements CustomersService {
	// 注入的是通用的DAO接口
	private GenericDao<Customers, String> customerdao;

	public GenericDao<Customers, String> getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(GenericDao<Customers, String> customerdao) {

		this.customerdao = customerdao;
	}

	public Customers selectByName(String username, String userpass) {
		List data = customerdao
				.findByHQL(
						"select a from Customers as a where a.customerId=? and a.postalCode=?",
						new Object[] { username, userpass });
		if (data.size() > 0)
			return (Customers) data.get(0);
		else
			return null;
	}
}
