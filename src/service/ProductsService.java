package service;

import base.PageBean;
import po.Products;

//��Ʒҵ����
public interface ProductsService {
	// ��ҳ��ѯ��Ʒ
	public PageBean selectByPage(int pagecode, int pagesize);

	// ��ID��ѯ��Ʒ
	public Products selectById(int prodid);
}
