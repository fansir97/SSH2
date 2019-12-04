package po;

import java.util.HashSet;
import java.util.Set;

/**
 * CustomerDemographics entity. @author MyEclipse Persistence Tools
 */

public class CustomerDemographics implements java.io.Serializable {

	// Fields

	private String customerTypeId;
	private String customerDesc;
	private Set customerCustomerDemos = new HashSet(0);

	// Constructors

	/** default constructor */
	public CustomerDemographics() {
	}

	/** full constructor */
	public CustomerDemographics(String customerDesc, Set customerCustomerDemos) {
		this.customerDesc = customerDesc;
		this.customerCustomerDemos = customerCustomerDemos;
	}

	// Property accessors

	public String getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerDesc() {
		return this.customerDesc;
	}

	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}

	public Set getCustomerCustomerDemos() {
		return this.customerCustomerDemos;
	}

	public void setCustomerCustomerDemos(Set customerCustomerDemos) {
		this.customerCustomerDemos = customerCustomerDemos;
	}

}