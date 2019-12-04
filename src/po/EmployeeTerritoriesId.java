package po;

/**
 * EmployeeTerritoriesId entity. @author MyEclipse Persistence Tools
 */

public class EmployeeTerritoriesId implements java.io.Serializable {

	// Fields

	private Employees employees;
	private Territories territories;

	// Constructors

	/** default constructor */
	public EmployeeTerritoriesId() {
	}

	/** full constructor */
	public EmployeeTerritoriesId(Employees employees, Territories territories) {
		this.employees = employees;
		this.territories = territories;
	}

	// Property accessors

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Territories getTerritories() {
		return this.territories;
	}

	public void setTerritories(Territories territories) {
		this.territories = territories;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployeeTerritoriesId))
			return false;
		EmployeeTerritoriesId castOther = (EmployeeTerritoriesId) other;

		return ((this.getEmployees() == castOther.getEmployees()) || (this
				.getEmployees() != null && castOther.getEmployees() != null && this
				.getEmployees().equals(castOther.getEmployees())))
				&& ((this.getTerritories() == castOther.getTerritories()) || (this
						.getTerritories() != null
						&& castOther.getTerritories() != null && this
						.getTerritories().equals(castOther.getTerritories())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEmployees() == null ? 0 : this.getEmployees().hashCode());
		result = 37
				* result
				+ (getTerritories() == null ? 0 : this.getTerritories()
						.hashCode());
		return result;
	}

}