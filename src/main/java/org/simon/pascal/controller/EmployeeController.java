package org.simon.pascal.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.activiti.engine.RuntimeService;
import org.simon.pascal.dto.DemandeCongeDto;
import org.simon.pascal.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@RequestMapping(value="employee.htm",method=RequestMethod.GET)
	public ModelAndView getRequest(){
		final ModelAndView mav=new ModelAndView();
		mav.addObject("demande", new DemandeCongeDto());
		return mav;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "employee.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void startHireProcess(@Valid DemandeCongeDto demande, BindingResult result ) {		
		final Map<String,Object> vars=demande.make();		 
		runtimeService.startProcessInstanceByKey("vacationRequest", vars);
	}

}
