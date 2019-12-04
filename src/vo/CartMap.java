package vo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import po.Products;

//购物车
public class CartMap implements Cart {
	// 所有商品
	private Map map = new java.util.LinkedHashMap();
	// 所有商品的总金额
	private Double total;

	public Map getMap() {
		return map;
	}

	// 总金额
	// 计算购物车商品的总金额
	public Double getTotal() {
		double sum = 0.0;
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			CartItem ci = (CartItem) map.get(it.next());
			sum += ci.getXiaoji();
		}
		return sum;
	}

	// 添加商品
	public void addProduct(Products product, int sl) {
		// 判断是否已经购买了该商品
		if (map.containsKey(product.getProductId())) {// 已购买 +sl

			CartItem ci = (CartItem) map.get(product.getProductId());
			ci.setSl(ci.getSl() + sl);
		} else
			// 加新商品
			map.put(product.getProductId(), new CartItem(product, sl));
	}

	// 删除一个商品
	public void removeProduct(int prodid) {
		map.remove(prodid);
	}

	// 清空购物车
	public void clear() {
		map.clear();
	}

	// 修改购物车中商品数量
	public void modify(int prodid, int sl) {
		CartItem ci = (CartItem) map.get(prodid);
		ci.setSl(sl);
	}
}