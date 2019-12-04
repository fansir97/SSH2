package vo;

import po.Products;

//购物车中的产品
public class CartItem {
	private Products product; // 商品
	private int sl; // 购买数量
	private Double xiaoji;// 小计

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