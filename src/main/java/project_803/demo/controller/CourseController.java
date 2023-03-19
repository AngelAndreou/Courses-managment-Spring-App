package project_803.demo.controller;

import java.util.HashMap;
import java.util.List;





import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import project_803.demo.instance.Course;
import project_803.demo.instance.Student;
import project_803.demo.service.CourseService;
import project_803.demo.service.StudentService;




@Controller
@RequestMapping("/courses")
//@SessionAttributes("courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	// add mapping for "/list"
	@RequestMapping("/list")
	public String listCourses(Model theModel) {
		//Determine the INSTRUCTOR user
		//can be done outside 
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String instructorLogIn=authentication.getName();
		
		// get courses from db
		List<Course> theCourses = courseService.findByInstructor(instructorLogIn);
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		return "courses/list-courses";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course theCourse = new Course();
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String instructorLogIn=authentication.getName();
		theCourse.setInstructor(instructorLogIn);
		
		theModel.addAttribute("course", theCourse);
		
		return "courses/course-form";
	}
	
				

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,
									Model theModel) {
		
		//List<Course> theCourses = (List<Course>) theModel.getAttribute("courses");
		//theCourses.size();
		
		// get the course from the service
		Course theCourse = courseService.findById(theId);
		
		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);
		
		// send over to our form
		return "courses/course-form";			
	}
	
	
	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse, Model theModel) {
		
		// save the course
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the course
		courseService.deleteById(theId);
		
		// redirect to /courses/list
		return "redirect:/courses/list";
		
	}
	
	// add mapping for "/statistics"
		@RequestMapping("/statistics")
		public String showStatistics(@RequestParam("courseId") int theId,Model theModel) {
			
				// get the course from the service
				Course theCourse = courseService.findById(theId);
				
				// set course as a model attribute to pre-populate the form
				theModel.addAttribute("course", theCourse);
				
				//get the Map with the Statistics from service
				HashMap<String, Double> statisticsMap=new HashMap<>();
				statisticsMap=courseService.getCourseStatistics(theCourse);
				
				//set course as a model attribute
				theModel.addAttribute("hashMap", statisticsMap);
				
				// send over to statistics
				return "courses/statistics";			
				}
	
		



}