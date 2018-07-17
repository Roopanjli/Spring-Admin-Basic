package com.ruby.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ruby.bean.EmployeBean;
import com.ruby.dao.EmployeDAOImpl;

@Controller
public class EmployeController {
@Autowired
EmployeDAOImpl edao;

public void setEb(EmployeDAOImpl edao) {
	this.edao = edao;
}
 

/*@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
public ModelAndView login(@ModelAttribute EmployeBean eb) {

	List<Map<String, Object>> login = edao.login(eb);

	if (login == null || login.isEmpty())
		return new ModelAndView("fail");
	else
		return new ModelAndView("success");
}*/



// Handler method for displaying new contact form

@RequestMapping(value = "/newEmploye")
public ModelAndView newEmployee(ModelAndView model) {
	EmployeBean emp = new EmployeBean();
	model.addObject("eb", emp);
	model.setViewName("addemp");
	return model;
}
@RequestMapping(value="/viewEmploye/{id}")
public ModelAndView viewEmpbyId(@PathVariable int id ,ModelAndView model) {
	EmployeBean eb = edao.getEmployeById(id);
	model.addObject("eb", eb);
	model.setViewName("editform");
	System.out.println("in view emp method");
	return  model;
}

// Handler method for inserting

@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
public ModelAndView add(@ModelAttribute EmployeBean eb) {

	edao.insert(eb);
	return new ModelAndView("redirect:/listEmploye");
}

// Handler method for Update

@RequestMapping(value="/update", method = RequestMethod.POST)
public ModelAndView saveEmployee( @ModelAttribute("eb")  EmployeBean eb) {
	System.out.println("update method before");
	
	
    	 edao.update(eb);
    
	
	
	System.out.println("update method");
	
		return new ModelAndView("redirect:/listEmploye");

}

// Handler method for deleting a contact:
@RequestMapping(value = "/deleteEmploye/{id}", method = RequestMethod.GET)
public ModelAndView deleteContact(@PathVariable int id) {
	
	int delete = edao.delete(id);
	if (delete != 0) {
		return new ModelAndView("redirect:/listEmploye");
	} else
		return new ModelAndView("fail");

}

// Handler method for listing all Employee's

@RequestMapping(value = "/listEmploye")
public ModelAndView listContact(ModelAndView model)  {
	List<EmployeBean> list = edao.findall();
	model.addObject("list", list);
	model.setViewName("viewemp");

	return model;
}
	
	
	
	
}
