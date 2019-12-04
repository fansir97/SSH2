package po;

/**
 * OrderDetails entity. @author MyEclipse Persistence Tools
 */

public class OrderDetails implements java.io.Serializable {

	// Fields

	private OrderDetailsId id;
	private Double unitPrice;
	private Short quantity;
	private Float discount;

	// Constructors

	/** default constructor 
	 * @param float1 
	 * @param s 
	 * @param double1 */
	public OrderDetails() {
	}

	/** full constructor */
	public OrderDetails(OrderDetailsId id, Double unitPrice, Short quantity,
			Float discount) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	// Property accessors

	public OrderDetailsId getId() {
		return this.id;
	}

	public void setId(OrderDetailsId id) {
		this.id = id;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}