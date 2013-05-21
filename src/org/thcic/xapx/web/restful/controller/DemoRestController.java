package org.thcic.xapx.web.restful.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thcic.xapx.service.UserService;
import org.thcic.xapx.web.restful.ControllerResult;

@Controller
@RequestMapping(value = "/demo")
public class DemoRestController {
	protected static final Log logger = LogFactory
			.getLog(DemoRestController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/{id}/get", method = RequestMethod.GET)
	public @ResponseBody ControllerResult getUserById(@PathVariable Long id) {
		return ControllerResult.valueOf(ControllerResult.SUCCESS,
				"GetUserById", userService.getUserById(id));
	}

	@RequestMapping(value = "/user/getAll", method = RequestMethod.GET)
	public @ResponseBody ControllerResult getAllUsers() {
		return ControllerResult.valueOf(ControllerResult.SUCCESS,
				"GetUserById", userService.getAllUsers());
	}

	@RequestMapping(value = "/user/getMenu", method = RequestMethod.GET)
	public @ResponseBody ControllerResult getUserMenu() {
		return ControllerResult.valueOf(ControllerResult.SUCCESS,
				"GetUserMenu", userService.getDemoMenu());
	}

}
