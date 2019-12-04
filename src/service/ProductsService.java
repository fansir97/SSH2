package service;

import base.PageBean;
import po.Products;

//商品业务功能
public interface ProductsService {
	// 分页查询商品
	public PageBean selectByPage(int pagecode, int pagesize);

	// 按ID查询商品
	public Products selectById(int prodid);
}
