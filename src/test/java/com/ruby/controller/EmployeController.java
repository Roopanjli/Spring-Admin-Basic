package com.ruby.controller;


import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping(value="/")
public ModelAndView homepage(@ModelAttribute("eb") EmployeBean eb) {
	
	return new ModelAndView("login");
}
/*@RequestMapping(value="/loginEmployee",method=RequestMethod.POST)
public String valid(@Valid @ModelAttribute("eb")EmployeBean eb,BindingResult result) {
	List<Map<String, Object>> login = edao.login(eb);
	
	while(result.hasErrors())
	{
	return "login";
	}
 
	
	 if (login == null || login.isEmpty()){
		return "logfail";
	 }
	 
		return "index";
	
}*/
@RequestMapping( value = "/loginEmployee",method=RequestMethod.POST)
public ModelAndView login( @ModelAttribute("eb") EmployeBean eb,BindingResult result) {
	List<Map<String, Object>> login = edao.login(eb);
	 if (login == null || login.isEmpty()){
		return new ModelAndView("logfail");
	 }
		return new ModelAndView("index");
}
@RequestMapping(value="/check" , method=RequestMethod.POST)
public String check(@Valid @ModelAttribute("eb")EmployeBean eb,BindingResult result) {
	List<Map<String, Object>> login = edao.id(eb);
	if (result.hasErrors()) {
		return "addemp";
	}
		else if(!eb.getPassword().equals(eb.getConfirmPass())) {
			return "passNotMatch";
		}
	else if(login == null || login.isEmpty()){
		edao.insert(eb);
		return "regisuccess";
	
	}
	
	 
	return "regisfail";
	
}



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

@RequestMapping(value = "/saveEmployee",method = RequestMethod.GET)
public ModelAndView add(@ModelAttribute("eb") EmployeBean eb) {

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
