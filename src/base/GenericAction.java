package base;

import com.opensymphony.xwork2.ActionSupport;
import service.CustomersService; 
import service.OrdersService; 
import service.ProductsService; 

//ͨ�õ� Action ���� ����ע�� Service �� 
@SuppressWarnings("serial")
public class GenericAction extends ActionSupport {
	// �������е�ҵ���ӿ�
	// ��Ʒҵ��
	protected ProductsService ps;

	public ProductsService getPs() {
		return ps;
	}

	public void setPs(ProductsService ps) {
		this.ps = ps;
	}

	// ����ҵ��
	protected OrdersService os;

	public OrdersService getOs() {
		return os;
	}

	public void setOs(OrdersService os) {
		this.os = os;
	}

	// �ͻ�ҵ��
	protected CustomersService cs;

	public CustomersService getCs() {
		return cs;
	}

	public void setCs(CustomersService cs) {
		this.cs = cs;
	}
}
