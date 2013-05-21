/**
 * 
 */
package org.thcic.xapx.web.restful.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thcic.xapx.exception.GenericException;
import org.thcic.xapx.web.restful.ControllerResult;

/**
 * 基路径：/rest/*
 * 
 * @author zhangyu octopusthu@gmail.com
 */
@ControllerAdvice
public class AdviceController {
	protected static final Log log = LogFactory.getLog(AdviceController.class);

	@ExceptionHandler
	public @ResponseBody
	ControllerResult handleException(Exception e) {
		log.warn("Exception occurred！", e);
		return ControllerResult.valueOf(ControllerResult.ERROR);
	}

	@ExceptionHandler
	public @ResponseBody
	ControllerResult handleGenericException(GenericException ex) {
		log.warn("GenericException occurred: " + ex.getMsg(), ex);
		return ControllerResult.valueOf(ControllerResult.ERROR, ex.getMsg());
	}
}
