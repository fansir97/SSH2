package vo;

import po.Products;

//���ﳵ�еĲ�Ʒ
public class CartItem {
	private Products product; // ��Ʒ
	private int sl; // ��������
	private Double xiaoji;// С��

	public CartItem() {
	}

	public CartItem(Products product, int sl) {
		this.product = product;
		this.sl = sl;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public Double getXiaoji() {

		return product.getUnitPrice().doubleValue() * sl;
	}
}