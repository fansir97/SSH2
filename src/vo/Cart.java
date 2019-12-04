package vo;

import java.util.Map;

import po.Products;

public interface Cart {
	// �����Ʒ
	public void addProduct(Products product, int sl);

	// ɾ��һ����Ʒ
	public void removeProduct(int prodid);

	// ��չ��ﳵ
	public void clear();

	// �޸Ĺ��ﳵ����Ʒ����
	public void modify(int prodid, int sl);

	// ���㹺�ﳵ����Ʒ���ܽ��
	public Double getTotal();

	// �õ����ﳵ�����е���Ʒ
	public Map getMap();
}