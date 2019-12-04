package presentation;

import com.opensymphony.xwork2.ActionContext;

import base.GenericAction;
import po.Customers;
import po.Products;
import vo.Cart;
import vo.CartMap;

@SuppressWarnings("serial")
public class ShopAction extends GenericAction {
	private int pagecode = 1; // ҳ��
	private int prodid; // ��ƷID
	private int[] productid; // �����ƷID
	private int[] sl; // ��Ʒ����
	private String username; // �û���
	private String userpass; // ����

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

	// ��ҳ��ѯ��Ʒ
	public String select() throws Exception {
		ActionContext.getContext().put("pb", this.ps.selectByPage(pagecode, 10));
		return SUCCESS;
	}

	// �����Ʒ�����ﳵ
	public String add() throws Exception {
		Products p = this.ps.selectById(prodid);
		Cart cart = null;
		if (ActionContext.getContext().getSession().get("cart") == null) {
			// û�й��ﳵ
			cart = new CartMap();
			ActionContext.getContext().getSession().put("cart", cart);
		} else {// ��
			cart = (Cart) ActionContext.getContext().getSession().get("cart");
		}
		cart.addProduct(p, 1);
		// ��ʾ���ﳵ����
		return "dispcart";
	}

	// ɾ��һ����Ʒ
	public String delete() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		cart.removeProduct(prodid);
		return "dispcart";
	}

	// ��չ��ﳵ
	public String clear() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		cart.clear();
		return "dispcart";
	}

	// ȥ����̨
	public String service() throws Exception {
		return "service";
	}

	// �޸Ĺ��ﳵ
	public String updatecart() throws Exception {
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		for (int i = 0; i < productid.length; i++)
			cart.modify(productid[i], sl[i]);
		return "dispcart";
	}

	// ���涩��
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
			// ��չ��ﳵ
			cart.clear();
			return "savers";
		}
	}

	// ��¼
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
			System.out.println("�]��ɹ�............");
			return "success";
			} else {
				System.out.println("�]��ʧ��............");
			return "error";
			}
	}*/
}
