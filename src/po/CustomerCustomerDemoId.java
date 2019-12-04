package po;

/**
 * CustomerCustomerDemoId entity. @author MyEclipse Persistence Tools
 */

public class CustomerCustomerDemoId implements java.io.Serializable {

	// Fields

	private Customers customers;
	private CustomerDemographics customerDemographics;

	// Constructors

	/** default constructor */
	public CustomerCustomerDemoId() {
	}

	/** full constructor */
	public CustomerCustomerDemoId(Customers customers,
			CustomerDemographics customerDemographics) {
		this.customers = customers;
		this.customerDemographics = customerDemographics;
	}

	// Property accessors

	public Customers getCustomers() {
		return this.customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public CustomerDemographics getCustomerDemographics() {
		return this.customerDemographics;
	}

	public void setCustomerDemographics(
			CustomerDemographics customerDemographics) {
		this.customerDemographics = customerDemographics;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustomerCustomerDemoId))
			return false;
		CustomerCustomerDemoId castOther = (CustomerCustomerDemoId) other;

		return ((this.getCustomers() == castOther.getCustomers()) || (this
				.getCustomers() != null && castOther.getCustomers() != null && this
				.getCustomers().equals(castOther.getCustomers())))
				&& ((this.getCustomerDemographics() == castOther
						.getCustomerDemographics()) || (this
						.getCustomerDemographics() != null
						&& castOther.getCustomerDemographics() != null && this
						.getCustomerDemographics().equals(
								castOther.getCustomerDemographics())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCustomers() == null ? 0 : this.getCustomers().hashCode());
		result = 37
				* result
				+ (getCustomerDemographics() == null ? 0 : this
						.getCustomerDemographics().hashCode());
		return result;
	}

}