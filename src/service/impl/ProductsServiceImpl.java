package service.impl;

import base.GenericDao;
import base.PageBean;
import po.Products;
import service.ProductsService;

public class ProductsServiceImpl implements ProductsService {
	private GenericDao<Products, Integer> proddao;

	public GenericDao<Products, Integer> getProddao() {
		return proddao;
	}

	public void setProddao(GenericDao<Products, Integer> proddao) {
		this.proddao = proddao;
	}

	public PageBean selectByPage(int pagecode, int pagesize) {
		return proddao.findByPage("select a from Products as a", pagecode,
				pagesize, new Object[] {});
	}

	public Products selectById(int prodid) {
		return proddao.findById(prodid);
	}
}