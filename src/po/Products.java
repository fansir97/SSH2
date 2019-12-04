package po;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private Integer productId;
	private Categories categories;
	private Suppliers suppliers;
	private String productName;
	private String quantityPerUnit;
	private Double unitPrice;
	private Short unitsInStock;
	private Short unitsOnOrder;
	private Short reorderLevel;
	private Boolean discontinued;

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(String productName, Boolean discontinued) {
		this.productName = productName;
		this.discontinued = discontinued;
	}

	/** full constructor */
	public Products(Categories categories, Suppliers suppliers,
			String productName, String quantityPerUnit, Double unitPrice,
			Short unitsInStock, Short unitsOnOrder, Short reorderLevel,
			Boolean discontinued) {
		this.categories = categories;
		this.suppliers = suppliers;
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Suppliers getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Short getUnitsInStock() {
		return this.unitsInStock;
	}

	public void setUnitsInStock(Short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Short getUnitsOnOrder() {
		return this.unitsOnOrder;
	}

	public void setUnitsOnOrder(Short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Short getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(Short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Boolean getDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

}