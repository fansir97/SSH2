package service.impl;

import java.util.Date;

import java.util.Iterator;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import base.GenericDao;
import po.Customers;
import po.OrderDetails;
import po.OrderDetailsId;
import po.Orders;
import vo.Cart;
import vo.CartItem;
import service.OrdersService;

//使用事务
@Transactional
public class OrdersServiceImpl implements OrdersService {
	private GenericDao<Orders, Integer> orderdao;
	private GenericDao<OrderDetails, OrderDetailsId> orderdetaildao;

	public GenericDao<Orders, Integer> getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(GenericDao<Orders, Integer> orderdao) {
		this.orderdao = orderdao;
	}

	public GenericDao<OrderDetails, OrderDetailsId> getOrderdetaildao() {
		return orderdetaildao;
	}

	public void setOrderdetaildao(
			GenericDao<OrderDetails, OrderDetailsId> orderdetaildao) {
		this.orderdetaildao = orderdetaildao;
	}

	public int saveOrders(Cart cart, Customers cust) {
		// 保存订单
		Orders order = new Orders();
		order.setCustomers(cust);
		order.setOrderDate((Date) new java.util.Date());
		int orderid = orderdao.create(order).getOrderId();
		// 保存明细
		Map map = cart.getMap();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			CartItem ci = (CartItem) map.get(it.next());
			OrderDetails od = new OrderDetails(null, ci.getProduct().getUnitPrice(),(short) ci.getSl(), new Float(0.0));
			OrderDetailsId odi = new OrderDetailsId();
			odi.setOrderId(orderid);
			odi.setProductId(ci.getProduct().getProductId());
			od.setId(odi);
			orderdetaildao.create(od);
		}
		return orderid;
	}
}
