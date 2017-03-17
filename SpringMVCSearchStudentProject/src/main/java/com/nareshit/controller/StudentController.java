package com.nareshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nareshit.beans.StudentBean;
import com.nareshit.dto.SearchParams;
import com.nareshit.dto.SearchResults;
import com.nareshit.entity.StudentEntity;
import com.nareshit.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "searchStudents", method = RequestMethod.GET)
	public String showSearchStudentsPage() {
		return "/WEB-INF/pages/searchStudents.jsp";
	}
	
	/*
	 * 	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";

*/
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		
		model.addAttribute("student", new StudentEntity());
		model.addAttribute("listStudents",this.studentService.listStudents());
		return "registration";
	
	}
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("studentbean") StudentBean studentbean, BindingResult result) {
		StudentEntity studententity = prepareModel(studentbean);
		studentService.addStudent(studententity);
	//	return new ModelAndView("redirect:/registration.html");
		return "redirect:/students";
	}

	private StudentEntity prepareModel(StudentBean studentbean) {

		StudentEntity studententity = new StudentEntity();
		studententity.setFullname(studentbean.getFullname());
		studententity.setAddress(studentbean.getAddress());
		studententity.setAge(studentbean.getAge());
		studententity.setQualification(studentbean.getQualification());
		studententity.setYop(studentbean.getYop());
		studententity.setGender(studentbean.getGender());

		return studententity;
	}

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String addStudents() {
		return "/WEB-INF/pages/registration.jsp";
	}

/*	@RequestMapping(value = "searchStudents", method = RequestMethod.POST)
	public ModelAndView searchStudents(@RequestParam("studentId") Integer studentId, @RequestParam("name") String name,
			@RequestParam("course") String course, @RequestParam("mobile") String mobile) {
		SearchParams searchParams = new SearchParams();
		searchParams.setStudentId(studentId);
		searchParams.setName(name);
		searchParams.setMobile(mobile);
		searchParams.setCourse(course);

		List<SearchResults> searchResultsList = studentService.searchStudents(searchParams);
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/pages/searchResults.jsp");
		modelAndView.addObject("searchResultsList", searchResultsList);

		return modelAndView;
	}*/
}
