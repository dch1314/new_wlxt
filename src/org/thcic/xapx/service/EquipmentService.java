package org.thcic.xapx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.thcic.xapx.domain.Equipment;
import org.thcic.xapx.dao.EquipmentDao;


@Service
public class EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;

	@Transactional
	public Equipment getEquipment(Long id) {
		return equipmentDao.findById(id);
	}

	@Transactional
	public List<Equipment> queryAll() {
		return equipmentDao.findAll();
	}
	
	@Transactional
	public List<Equipment> byExample(Equipment equipment) {
		return equipmentDao.byExample(equipment);
	}
	
	@Transactional
	public void add(Equipment equipment) {
		equipmentDao.save(equipment);
	}
	
	@Transactional
	public void update(Equipment equipment) {
		equipmentDao.merge(equipment);
	}
	
	@Transactional
	public void delete(Long id) {
		equipmentDao.delete(equipmentDao.findById(id));
		
	}
}
