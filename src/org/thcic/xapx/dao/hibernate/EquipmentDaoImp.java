package org.thcic.xapx.dao.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thcic.xapx.dao.EquipmentDao;
import org.thcic.xapx.domain.Equipment;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * Data access object (DAO) for domain model class Equipment.
 * 
 * @see org.thcic.xapx.domain.Equipment
 * @author MyEclipse Persistence Tools
 */
@Repository
public class EquipmentDaoImp implements EquipmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(EquipmentDaoImp.class);
	// property constants
	public static final String EQ_ID = "eqId";
	public static final String MODEL = "model";
	public static final String QUANTITY = "quantity";
	public static final String WEIGHT = "weight";
	public static final String PERSON_RESP = "personResp";
	public static final String PERSON_MODIFIED = "personModified";

	public void save(Equipment transientInstance) {
		sessionFactory.getCurrentSession().save(transientInstance);
	}

	public void delete(Equipment persistentInstance) {
		sessionFactory.getCurrentSession().delete(persistentInstance);
	}

	public Equipment findById(Long id) {
		return (Equipment)sessionFactory.getCurrentSession().get(Equipment.class, id);
	}

	public List<Equipment> findByExample(Equipment instance) {
		return null;
	}

	public List<Equipment> findByProperty(String propertyName, Object value) {
		return null;
	}

	public List<Equipment> findByEqId(Object eqId) {
		return findByProperty(EQ_ID, eqId);
	}

	public List<Equipment> findByModel(Object model) {
		return findByProperty(MODEL, model);
	}

	public List<Equipment> findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List<Equipment> findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List<Equipment> findByPersonResp(Object personResp) {
		return findByProperty(PERSON_RESP, personResp);
	}

	public List<Equipment> findByPersonModified(Object personModified) {
		return findByProperty(PERSON_MODIFIED, personModified);
	}

	@SuppressWarnings("unchecked")
	public List<Equipment> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Equipment.class);
		return criteria.list();
	}

	public Equipment merge(Equipment detachedInstance) {
		sessionFactory.getCurrentSession().update(detachedInstance);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> byExample(Equipment equipment) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Equipment.class).add(Example.create(equipment).enableLike(MatchMode.ANYWHERE).ignoreCase().setPropertySelector( new WithoutEmptyStringPropertySelector()));
		if(equipment != null){
			if(equipment.getCodeEqType() != null && equipment.getCodeEqType().getCode() != null && !equipment.getCodeEqType().getCode().equals("")){
				criteria.add(Restrictions.eq("codeEqType.code", equipment.getCodeEqType().getCode()) );
			}
			
			if(equipment.getCodeEqStatus() != null && equipment.getCodeEqStatus().getCode() != null && !equipment.getCodeEqStatus().getCode().equals("")){
				criteria.add(Restrictions.eq("codeEqStatus.code", equipment.getCodeEqStatus().getCode()) );
			}
		}
		return criteria.list();
		//Example.create(role).enableLike(MatchMode.ANYWHERE).ignoreCase().setPropertySelector( new WithoutEmptyStringPropertySelector()))
		//return equipmentDao.byExample(equipment);
	}

}