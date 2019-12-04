package vo;

import java.util.Map;

import po.Products;

public interface Cart {
	// 添加商品
	public void addProduct(Products product, int sl);

	// 删除一个商品
	public void removeProduct(int prodid);

	// 清空购物车
	public void clear();

	// 修改购物车中商品数量
	public void modify(int prodid, int sl);

	// 计算购物车中商品的总金额
	public Double getTotal();

	// 得到购物车中所有的商品
	public Map getMap();
}