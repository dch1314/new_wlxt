package org.thcic.xapx.web.restful.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.thcic.xapx.service.EquipmentService;
import org.thcic.xapx.web.restful.ControllerResult;

/**
 * 准考证 RESTful Controller
 * 
 * 基路径：/rest/*
 * 
 * @author zhangyu octopusthu@gmail.com
 */
@Controller
public class EquipmentRestController {
	protected static final Log logger = LogFactory
			.getLog(EquipmentRestController.class);

	@Autowired
	EquipmentService equipmentService;

	@RequestMapping(value = "/equipment/{id}/get")
	public @ResponseBody ControllerResult getEquipment(@PathVariable Long id) {
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "GetEquipment",
				equipmentService.getEquipment(id));
	}

	@RequestMapping(value = "/equipment/getAll")
	public @ResponseBody ControllerResult getAllEquipment() {
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "GetEquipment",
				equipmentService.queryAll());
	}

}
