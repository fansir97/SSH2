package vo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import po.Products;

//���ﳵ
public class CartMap implements Cart {
	// ������Ʒ
	private Map map = new java.util.LinkedHashMap();
	// ������Ʒ���ܽ��
	private Double total;

	public Map getMap() {
		return map;
	}

	// �ܽ��
	// ���㹺�ﳵ��Ʒ���ܽ��
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

	// �����Ʒ
	public void addProduct(Products product, int sl) {
		// �ж��Ƿ��Ѿ������˸���Ʒ
		if (map.containsKey(product.getProductId())) {// �ѹ��� +sl

			CartItem ci = (CartItem) map.get(product.getProductId());
			ci.setSl(ci.getSl() + sl);
		} else
			// ������Ʒ
			map.put(product.getProductId(), new CartItem(product, sl));
	}

	// ɾ��һ����Ʒ
	public void removeProduct(int prodid) {
		map.remove(prodid);
	}

	// ��չ��ﳵ
	public void clear() {
		map.clear();
	}

	// �޸Ĺ��ﳵ����Ʒ����
	public void modify(int prodid, int sl) {
		CartItem ci = (CartItem) map.get(prodid);
		ci.setSl(sl);
	}
}