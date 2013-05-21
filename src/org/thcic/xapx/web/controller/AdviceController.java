/**
 * 
 */
package org.thcic.xapx.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.thcic.xapx.exception.GenericException;

/**
 * @author zhangyu octopusthu@gmail.com
 */
@ControllerAdvice
public class AdviceController {
	protected static final Log log = LogFactory.getLog(AdviceController.class);

	private final String errorView = "error";

	@ExceptionHandler
	public String handleException(Exception e) {
		log.warn("Exception occurred！", e);
		return errorView;
	}

	@ExceptionHandler
	public ModelAndView handleGenericException(GenericException ex) {
		log.warn("GenericException occurred！", ex);
		ModelAndView mav = new ModelAndView(errorView);
		mav.addObject("msg", ex.getMsg());
		return mav;
	}
}
