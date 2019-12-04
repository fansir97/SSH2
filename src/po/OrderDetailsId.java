package po;

/**
 * OrderDetailsId entity. @author MyEclipse Persistence Tools
 */

public class OrderDetailsId implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer productId;

	// Constructors

	/** default constructor */
	public OrderDetailsId() {
	}

	/** full constructor */
	public OrderDetailsId(Integer orderId, Integer productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailsId))
			return false;
		OrderDetailsId castOther = (OrderDetailsId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null && castOther.getOrderId() != null && this
				.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getProductId() == castOther.getProductId()) || (this
						.getProductId() != null
						&& castOther.getProductId() != null && this
						.getProductId().equals(castOther.getProductId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getProductId() == null ? 0 : this.getProductId().hashCode());
		return result;
	}

}