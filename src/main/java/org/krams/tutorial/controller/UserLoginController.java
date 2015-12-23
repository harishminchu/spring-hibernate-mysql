package org.krams.tutorial.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Proctor;
import org.krams.tutorial.service.ProctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/UserLogin")
public class UserLoginController {

	public static final String ACCOUNT_SID = "AC5ee6757004b40a118a3df5a20fede740";
	public static final String AUTH_TOKEN = "0e00993b31cd96538b1bdfc5f353357a";
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="proctorService")
	private ProctorService proctorService;

	/**
	 * Handles and retrieves all uttaras and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
    	
    	logger.debug("Request for the Login Page");
    	// This will resolve to /WEB-INF/jsp/uttaraspage.jsp
    	return "index";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String Check(@RequestParam(value="username") String username,@RequestParam(value ="password")String password,Model model) {
    	logger.debug("Authorization of UserLogin ");
    	
    	
    	if(username.equals("admin" ) && password.equals("admin")){
    		
    		return  "redirect:/login/proctor/proctors";
    	}
    	
    	Proctor login = proctorService.get(username, password);
    	
    	if(login.getPassword()!=null){
    		return  "redirect:/login/student/students";
    	}
    	
    	model.addAttribute("errorMsg", "Invalid user Login");
    	
       	return "error";
	}
 
    /**
     * Adds a new uttara by delegating the processing to uttaraService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
 	
	
}
