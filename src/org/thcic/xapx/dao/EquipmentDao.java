package org.thcic.xapx.dao;

import org.springframework.stereotype.Repository;
import org.thcic.xapx.domain.Equipment;
import java.util.List;

/**
 * Data access object (DAO) for domain model class Equipment.
 * 
 * @see org.thcic.xapx.domain.Equipment
 * @author MyEclipse Persistence Tools
 */
@Repository
public interface EquipmentDao{

	public void save(Equipment transientInstance);

	public void delete(Equipment persistentInstance);

	public Equipment findById(Long id);
	
	public List<Equipment> findByExample(Equipment instance);

	public List<Equipment> findByProperty(String propertyName, Object value);

	public List<Equipment> findByEqId(Object eqId);

	public List<Equipment> findByModel(Object model);

	public List<Equipment> findByQuantity(Object quantity);

	public List<Equipment> findByWeight(Object weight);

	public List<Equipment> findByPersonResp(Object personResp);
	
	public List<Equipment> findByPersonModified(Object personModified);

	public List<Equipment> findAll();
	
	public List<Equipment> byExample(Equipment equipment);

	public Equipment merge(Equipment detachedInstance);

}