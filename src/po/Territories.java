package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Territories entity. @author MyEclipse Persistence Tools
 */

public class Territories implements java.io.Serializable {

	// Fields

	private String territoryId;
	private Region region;
	private String territoryDescription;
	private Set employeeTerritorieses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Territories() {
	}

	/** minimal constructor */
	public Territories(Region region, String territoryDescription) {
		this.region = region;
		this.territoryDescription = territoryDescription;
	}

	/** full constructor */
	public Territories(Region region, String territoryDescription,
			Set employeeTerritorieses) {
		this.region = region;
		this.territoryDescription = territoryDescription;
		this.employeeTerritorieses = employeeTerritorieses;
	}

	// Property accessors

	public String getTerritoryId() {
		return this.territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getTerritoryDescription() {
		return this.territoryDescription;
	}

	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}

	public Set getEmployeeTerritorieses() {
		return this.employeeTerritorieses;
	}

	public void setEmployeeTerritorieses(Set employeeTerritorieses) {
		this.employeeTerritorieses = employeeTerritorieses;
	}

}