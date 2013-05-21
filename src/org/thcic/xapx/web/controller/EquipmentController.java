package org.thcic.xapx.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.thcic.xapx.domain.Equipment;
import org.thcic.xapx.service.EquipmentService;

/**
 * 准考证 Controller
 * 
 * 基路径：/u/*
 * 
 * @author zhangyu octopusthu@gmail.com
 */
@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {
	protected static final Log log = LogFactory
			.getLog(EquipmentController.class);

	@Autowired
	EquipmentService equipmentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Equipment equipment) {
		request.setAttribute("data", this.equipmentService.byExample(equipment));
		request.setAttribute("exmaple", equipment);
		log.info("request.getAttribute(data)" + request.getAttribute("data"));
		return "equipment";
	}
	
	@RequestMapping(value = "/beforeAdd", method = RequestMethod.GET)
	public String beforeAdd(Model model) {
		log.info("beforeAdd");
		model.addAttribute("data", null);
		return "add";
	}

	@RequestMapping(value = "/saveAdd")
	public String saveAdd(HttpServletRequest request, Equipment equipment) {
		this.equipmentService.add(equipment);
		return index(request,new Equipment());
	}
	
	@RequestMapping(value = "/beforeEdit", method = RequestMethod.GET)
	public String beforeEdit(HttpServletRequest request,  Equipment equipment) {
		
		request.setAttribute("data", this.equipmentService.getEquipment(
				equipment.getEqSeq()		
		));
		
		//BigDecimal.valueOf(Long.parseLong(eqSeq)).longValue())
		
		return "edit";
	}
	
	@RequestMapping(value = "/saveEdit")
	public String saveEdit(HttpServletRequest request, Equipment equipment) {
		this.equipmentService.update(equipment);
		return index(request,new Equipment());
	}

	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Equipment equipment) {
		this.equipmentService.delete(equipment.getEqSeq());
		return this.index(request,new Equipment());
	}
	
	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, Equipment equipment) {
		request.setAttribute("data", this.equipmentService.byExample(equipment));
		request.setAttribute("exmaple", equipment);
		log.info("request.getAttribute(data)" + request.getAttribute("data"));
		return "search";
	}
}
