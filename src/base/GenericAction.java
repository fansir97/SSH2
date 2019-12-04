package base;

import com.opensymphony.xwork2.ActionSupport;
import service.CustomersService; 
import service.OrdersService; 
import service.ProductsService; 

//通用的 Action 父类 用于注入 Service 层 
@SuppressWarnings("serial")
public class GenericAction extends ActionSupport {
	// 声明所有的业务层接口
	// 商品业务
	protected ProductsService ps;

	public ProductsService getPs() {
		return ps;
	}

	public void setPs(ProductsService ps) {
		this.ps = ps;
	}

	// 订单业务
	protected OrdersService os;

	public OrdersService getOs() {
		return os;
	}

	public void setOs(OrdersService os) {
		this.os = os;
	}

	// 客户业务
	protected CustomersService cs;

	public CustomersService getCs() {
		return cs;
	}

	public void setCs(CustomersService cs) {
		this.cs = cs;
	}
}
