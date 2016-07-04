package com.manish.javadev.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.manish.javadev.model.User;

@SuppressWarnings("deprecation")
public class RegistrationController extends SimpleFormController {

	public ModelAndView onSubmit(Object command, BindException errors) {
		System.out.println("onSubmit() is Called");
		ModelAndView model = null;
		User user = (User) command;
		String un = user.getUsername();
		String pw = user.getPassword();
		String view = "";

		// Note:
		// You can implement DAO and use in your project
		if (un.equals(pw)) {
			view = getSuccessView();
		} else {
			view = getFormView();
		}

		// Creating a ModelAndView Object and adding jsp page and model data
		model = new ModelAndView(view, "user", user);
		return model;
	}

	public Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		System.out.println("formBackingObject() is called");
		User user = new User();
		user.setUsername("Divya");
		return user;
	}
}

// If user name and password are same the assumption for Registration done