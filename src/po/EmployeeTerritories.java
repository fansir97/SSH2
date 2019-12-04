package po;

/**
 * EmployeeTerritories entity. @author MyEclipse Persistence Tools
 */

public class EmployeeTerritories implements java.io.Serializable {

	// Fields

	private EmployeeTerritoriesId id;

	// Constructors

	/** default constructor */
	public EmployeeTerritories() {
	}

	/** full constructor */
	public EmployeeTerritories(EmployeeTerritoriesId id) {
		this.id = id;
	}

	// Property accessors

	public EmployeeTerritoriesId getId() {
		return this.id;
	}

	public void setId(EmployeeTerritoriesId id) {
		this.id = id;
	}

}