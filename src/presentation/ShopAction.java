package presentation;

import com.opensymphony.xwork2.ActionContext;

import base.GenericAction;
import po.Customers;
import po.Products;
import vo.Cart;
import vo.CartMap;

@SuppressWarnings("serial")
public class ShopAction extends GenericAction {
	private int pagecode = 1; // 页码
	private int prodid; // 商品ID
	private int[] productid; // 多个商品ID
	private int[] sl; // 商品数量
	private String username; // 用户名
	private String userpass; // 密码

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public int[] getSl() {
		return sl;
	}

	public void setSl(int[] sl) {
		this.sl = sl;
	}

	public int[] getProductid() {
		return productid;
	}

	public void setProductid(int[] productid) {
		this.productid = productid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	// 分页查询商品
	public String select() throws Exception {
		ActionContext.getContext().put("pb", this.ps.selectByPage(pagecode, 10));
		return SUCCESS;
	}

	// 添加商品到购物车
	public String add() throws Exception {
		Products p = this.ps.selectById(prodid);
		Cart cart = null;
		if (ActionContext.getContext().getSession().get("cart") == null) {
			// 没有购物车
			cart = new CartMap();
			ActionContext.getContext().getSession().put("cart", cart);
		} else {// 有
			cart = (Cart) ActionContext.getContext().getSession().get("cart");
		}
		cart.addProduct(p, 1);
		// 显示购物车内容
		return "dispcart";
	}

	// 删除一个商品
	public String delete() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		cart.removeProduct(prodid);
		return "dispcart";
	}

	// 清空购物车
	public String clear() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		cart.clear();
		return "dispcart";
	}

	// 去服务台
	public String service() throws Exception {
		return "service";
	}

	// 修改购物车
	public String updatecart() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		for (int i = 0; i < productid.length; i++)
			cart.modify(productid[i], sl[i]);
		return "dispcart";
	}

	// 保存订单
	public String saveorder() throws Exception {
		if (ActionContext.getContext().getSession().get("islogin") == null) {
			return "login";
		} else {
			Customers c = (Customers) ActionContext.getContext().getSession()
					.get("islogin");
			Cart cart = (Cart) ActionContext.getContext().getSession()
					.get("cart");
			ActionContext.getContext().put("orderid",
					this.os.saveOrders(cart, c));
			// 清空购物车
			cart.clear();
			return "savers";
		}
	}

	// 登录
	public String login() throws Exception {
		Customers c = this.cs.selectByName(username, userpass);
		if (c != null) {
			ActionContext.getContext().getSession().put("islogin", c);
			return "service";
		} else
			return "login";
	}
/*	public String regist()throws Exception{
		if ("fan".equals(username) && "fan123456".equals(userpass)) {
			System.out.println("註册成功............");
			return "success";
			} else {
				System.out.println("註册失败............");
			return "error";
			}
	}*/
}
