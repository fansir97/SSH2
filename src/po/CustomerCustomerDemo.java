package po;

/**
 * CustomerCustomerDemo entity. @author MyEclipse Persistence Tools
 */

public class CustomerCustomerDemo implements java.io.Serializable {

	// Fields

	private CustomerCustomerDemoId id;

	// Constructors

	/** default constructor */
	public CustomerCustomerDemo() {
	}

	/** full constructor */
	public CustomerCustomerDemo(CustomerCustomerDemoId id) {
		this.id = id;
	}

	// Property accessors

	public CustomerCustomerDemoId getId() {
		return this.id;
	}

	public void setId(CustomerCustomerDemoId id) {
		this.id = id;
	}

}