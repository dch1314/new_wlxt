package org.thcic.xapx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thcic.xapx.service.UserService;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String demo(Model model) {
		model.addAttribute("data", userService.getAllUsers());
		return "demo";
	}
}
