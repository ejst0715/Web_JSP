package com.test.app.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.test.app")
public class CommonExceptionHandler {
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView excep1(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("error/error.jsp");
		return mav;
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView excep2(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("error/errorId.jsp");
		return mav;
	}
	public void excep3() {
	}
}
