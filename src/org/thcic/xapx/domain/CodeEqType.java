package org.thcic.xapx.domain;

import java.util.Set;

/**
 * CodeEqType generated by MyEclipse Persistence Tools
 */

public class CodeEqType implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7988948252073326511L;
	private String code;
	private String name;
	private String desc;
	//private Set equipments = new HashSet(0);

	// Constructors

	/** default constructor */
	public CodeEqType() {
	}

	/** minimal constructor */
	public CodeEqType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/** full constructor */
	public CodeEqType(String code, String name, String desc, Set<Equipment> equipments) {
		this.code = code;
		this.name = name;
		this.desc = desc;
		//this.equipments = equipments;
	}

	// Property accessors

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

/*	public Set getEquipments() {
		return this.equipments;
	}

	public void setEquipments(Set equipments) {
		this.equipments = equipments;
	}
*/
}