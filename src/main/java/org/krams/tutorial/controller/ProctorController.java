package org.krams.tutorial.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Proctor;
import org.krams.tutorial.service.ProctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles and retrieves proctor request
 */
@Controller
@RequestMapping("/proctor")
public class ProctorController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="proctorService")
	private ProctorService proctorService;
	
	/**
	 * Handles and retrieves all proctors and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/proctors", method = RequestMethod.GET)
    public String getroctors(Model model) {
    	
    	logger.debug("Received request to show all proctors");
    	
    	// Retrieve all proctors by delegating the call to proctorService
    	List<Proctor> proctors = proctorService.getAll();
    	
    	// Attach proctors to the Model
    	model.addAttribute("proctors", proctors);
    	
    	// This will resolve to /WEB-INF/jsp/proctorspage.jsp
    	return "proctor/proctorspage";
	}
    
    
    @RequestMapping(value = "/proctorJson", method = RequestMethod.GET)
    public @ResponseBody List<Proctor> getProctorsJson(Model model) {
    	
    	logger.debug("Received request to show all proctors");
    	
    	return proctorService.getAll();
    	
	}
    
    
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/proctors/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new proctor and add to model
    	// This is the formBackingOBject
    	model.addAttribute("proctorAttribute", new Proctor());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "proctor/addpage";
	}
 
    /**
     * Adds a new proctor by delegating the processing to proctorService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/proctors/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("proctorAttribute") Proctor proctor) {
		logger.debug("Received request to add new proctor");
		
		proctorService.add(proctor);

		return  "redirect:/login/proctor/proctors";
		
	}
    
    /**
     * Deletes an existing proctor by delegating the processing to proctorService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/proctors/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing proctor");
		
		// Call proctorService to do the actual deleting
		proctorService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return  "redirect:/login/proctor/proctors";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/proctors/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing proctor and add to model
    	// This is the formBackingOBject
    	model.addAttribute("proctorAttribute", proctorService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "proctor/editpage";
	}
    
    /**
     * Edits an existing proctor by delegating the processing to proctorService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    
    @RequestMapping(value = "/proctors/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("proctorAttribute") Proctor proctor, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update proctor");
    
    	// The "proctorAttribute" model has been passed to the controller from the JSP
    	// We use the name "proctorAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	proctor.setId(id);
    	
    	// Delegate to proctorService for editing
    	proctorService.edit(proctor);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return  "redirect:/login/proctor/proctors";
	}

    
    
    
}
