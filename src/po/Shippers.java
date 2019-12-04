package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Shippers entity. @author MyEclipse Persistence Tools
 */

public class Shippers implements java.io.Serializable {

	// Fields

	private Integer shipperId;
	private String companyName;
	private String phone;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shippers() {
	}

	/** minimal constructor */
	public Shippers(String companyName) {
		this.companyName = companyName;
	}

	/** full constructor */
	public Shippers(String companyName, String phone, Set orderses) {
		this.companyName = companyName;
		this.phone = phone;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getShipperId() {
		return this.shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}