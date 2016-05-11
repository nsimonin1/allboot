package org.simon.pascal.controller;

import javax.validation.Valid;

import org.simon.pascal.model.Person;
import org.simon.pascal.settings.DemoSettings;
import org.simon.pascal.storage.PersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
     @Autowired
     private PersonStorage personStorage;
     @Autowired
	 private DemoSettings demoSettings;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home(){
		final ModelAndView mav=new ModelAndView("index");
		mav.addObject("persons", personStorage.getPersons());
		return mav;
	}
	
	@RequestMapping(value="/nouveau.htm",method=RequestMethod.GET)
	public ModelAndView nouveau(){
		final ModelAndView mav=new ModelAndView("nouveau");
		mav.addObject("person", new Person());
		return mav;
	}
	
	@RequestMapping(value="/nouveau.htm",method=RequestMethod.POST)
	public String enregistrer(@Valid Person person,BindingResult result){		
		if(result.hasErrors()){
			return "nouveau";
		}else{
		  personStorage.ajouter(person);
		  return "redirect:/";	
		}		 
	}
	
	@RequestMapping(value="/supprimer.htm",method=RequestMethod.GET)
	public String supprimer(@RequestParam long id){ 
		final Person person=personStorage.getPerson(id); 
		personStorage.supprimer(person);
		 
		 
		return "redirect:/";	
	}
	
	@ModelAttribute("settings")
	public DemoSettings getSettings(){
	  return demoSettings;	
	}
	
	@RequestMapping(value="/book.htm",method=RequestMethod.GET)
	public String book(){ 		 
		return "book";	
	}
}
