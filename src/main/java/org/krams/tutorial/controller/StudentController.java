package org.krams.tutorial.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Student;
import org.krams.tutorial.service.StudentService;
import org.krams.tutorial.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles and retrieves student request
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "studentService")
	private StudentService studentService;

	CommonUtils commonUtils = new CommonUtils();

	/**
	 * Handles and retrieves all students and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getstudents(Model model) {

		logger.debug("Received request to show all students");

		// Retrieve all students by delegating the call to studentService
		List<Student> students = studentService.getAll();

		// Attach students to the Model

		model.addAttribute("students", students);

		// This will resolve to /WEB-INF/jsp/studentspage.jsp
		return "student/studentspage";
	}

	@RequestMapping(value = "/studentJSON", method = RequestMethod.GET)
	public @ResponseBody
	List<Student> getstudentsJson() {

		logger.debug("Received request to show all students");

		// This will resolve to /WEB-INF/jsp/studentspage.jsp
		return studentService.getAll();
	}

	/**
	 * Retrieves the add page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new student and add to model
		// This is the formBackingOBject

		// The "studentAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "studentAttribute" because the JSP uses that name

		// Call studentService to do the actual adding

		model.addAttribute("studentAttribute", new Student());

		return "student/studentaddpage";
	}

	/**
	 * Adds a new student by delegating the processing to studentService.
	 * Displays a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("studentAttribute") Student student) {

		logger.debug("Received request to add new student");
		studentService.add(student);
		// This will resolve to /WEB-INF/jsp/addedpage.jsp

		return "redirect:/login/student/students";
	}

	/**
	 * Deletes an existing student by delegating the processing to
	 * studentService. Displays a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = true) Integer id, Model model) {

		logger.debug("Received request to delete existing student");

		// Call studentService to do the actual deleting
		studentService.delete(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "redirect:/login/student/students";
	}

	/**
	 * Retrieves the edit page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students/edit", method = RequestMethod.GET)
	public String getEdit(
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing student and add to model
		// This is the formBackingOBject
		model.addAttribute("studentAttribute", studentService.get(id));

		// This will resolve to /WEB-INF/jsp/editpage.jsp
		return "student/editpage";
	}

	/**
	 * Edits an existing student by delegating the processing to studentService.
	 * Displays a confirmation JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/students/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("studentAttribute") Student student,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to update student");

		// The "studentAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "studentAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the
		// ModelAttribute
		student.setId(id);

		// Delegate to studentService for editing
		studentService.edit(student);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "redirect:/login/student/students";
	}

	@RequestMapping(value = "/students/smsall", method = RequestMethod.GET)
	public String sensSMSAll() {
		logger.debug("Received request to update student");

		List<Student> students = studentService.getAll();

		for (Student student2 : students) {
			String msg = "Hello  "
					+ student2.getNAME()
					+ " your " +
					student2.getInternal()
					+
					"internal"
					+ (student2.getSubject1() != null ? student2.getSubject1(): " ") + " "
					+ (student2.getMark1() != null ? student2.getMark1() : " ") + " "
					+ (student2.getSubject2() != null ? student2.getSubject2(): " ") + " "
					+ (student2.getMark2() != null ? student2.getMark2() : " ") + " "
					+ (student2.getSubject3() != null ? student2.getSubject3()	: " ")+ " "
					+ (student2.getMark3() != null ? student2.getMark3() : " ")+ " "
					+ (student2.getSubject4() != null ? student2.getSubject4()+ " "
							: " ")+ " "
					+ (student2.getMark4() != null ? student2.getMark4() : " ")+ " "
					+ (student2.getSubject5() != null ? student2.getSubject5()
							: " ")+ " "
					+ (student2.getMark5() != null ? student2.getMark5() : " ")+ " "
					+ (student2.getSubject6() != null ? student2.getSubject6()
							: " ")+ " "
					+ (student2.getMark6() != null ? student2.getMark6() : " ")+ " "
					+ (student2.getSubject7() != null ? student2.getSubject7()
							: " ")+ " "
					+ (student2.getMark7() != null ? student2.getMark7() : " ")+ " "
					+ (student2.getSubject8() != null ? student2.getSubject8()
							: " ")+ " "
					+ (student2.getMark8() != null ? student2.getMark8() : " ")+ " "

			;

			commonUtils.sendSms(student2.getContact(), msg);

				
			logger.debug("mesaage recived ");
		}
		// This will resolve to /WEB-INF/jsp/editedpage.jsp 9035678237
		return "redirect:/login/student/students";
	}

	@RequestMapping(value = "/students/sms", method = RequestMethod.GET)
	public String sensSMS(@ModelAttribute("studentAttribute") Student student,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received  sms thing");

		Student student2 = studentService.get(id);
		String msg = "Hello  "
				+ student2.getNAME()
				+ " your " +
				student2.getInternal()
				+
				"internal"
				+ (student2.getSubject1() != null ? student2.getSubject1(): " ") + " "
				+ (student2.getMark1() != null ? student2.getMark1() : " ") + " "
				+ (student2.getSubject2() != null ? student2.getSubject2(): " ") + " "
				+ (student2.getMark2() != null ? student2.getMark2() : " ") + " "
				+ (student2.getSubject3() != null ? student2.getSubject3()	: " ")+ " "
				+ (student2.getMark3() != null ? student2.getMark3() : " ")+ " "
				+ (student2.getSubject4() != null ? student2.getSubject4()+ " "
						: " ")+ " "
				+ (student2.getMark4() != null ? student2.getMark4() : " ")+ " "
				+ (student2.getSubject5() != null ? student2.getSubject5()
						: " ")+ " "
				+ (student2.getMark5() != null ? student2.getMark5() : " ")+ " "
				+ (student2.getSubject6() != null ? student2.getSubject6()
						: " ")+ " "
				+ (student2.getMark6() != null ? student2.getMark6() : " ")+ " "
				+ (student2.getSubject7() != null ? student2.getSubject7()
						: " ")+ " "
				+ (student2.getMark7() != null ? student2.getMark7() : " ")+ " "
				+ (student2.getSubject8() != null ? student2.getSubject8()
						: " ")+ " "
				+ (student2.getMark8() != null ? student2.getMark8() : " ")+ " "

		;
		commonUtils.sendSms(student2.getContact(), msg);
		logger.debug("mesaage recived " + student2.getContact() + msg);
		logger.info(student2.getContact() );
		// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "redirect:/login/student/students";
	}

}
