package po;

import java.util.HashSet;
import java.util.Set;

/**
 * Region entity. @author MyEclipse Persistence Tools
 */

public class Region implements java.io.Serializable {

	// Fields

	private Integer regionId;
	private String regionDescription;
	private Set territorieses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Region() {
	}

	/** minimal constructor */
	public Region(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	/** full constructor */
	public Region(String regionDescription, Set territorieses) {
		this.regionDescription = regionDescription;
		this.territorieses = territorieses;
	}

	// Property accessors

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionDescription() {
		return this.regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public Set getTerritorieses() {
		return this.territorieses;
	}

	public void setTerritorieses(Set territorieses) {
		this.territorieses = territorieses;
	}

}