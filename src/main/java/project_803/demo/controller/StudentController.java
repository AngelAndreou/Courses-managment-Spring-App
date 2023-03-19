package project_803.demo.controller;

import java.util.List;





import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;

import project_803.demo.instance.Course;
import project_803.demo.instance.Student;
import project_803.demo.service.CourseService;
import project_803.demo.service.StudentService;


@Controller
@RequestMapping("/students")
//@SessionAttributes("students")

public class StudentController {

	@Autowired
	private StudentService studentService;
	private CourseService courseService;
	public StudentController(StudentService theStudentService,CourseService theCourseService) {
		studentService = theStudentService;
		courseService=theCourseService;
	}
	
	// add mapping for "/list"
		@RequestMapping("/studentslist")
		public String listStudents(@RequestParam("courseId") int theId, Model theModel) {
			
			// get students from db
			
			Course trueCourse = courseService.findById(theId);
			List<Student> theStudents = trueCourse.getStudents();
			 
			
			// add to the spring model
			theModel.addAttribute("students", theStudents);
			//test if neded or not 
			theModel.addAttribute("course", trueCourse);
			return "students/list-students";
		}
		
		@RequestMapping("/showFormForRegister")
		public String showFormForRegister(@RequestParam("courseId") int theId, Model theModel) {
			
			// create model attribute to bind form data
			Student theStudent = new Student();
			
			//save to the curent student and curse to model 
			
			Course theCourse = courseService.findById(theId);
			
			
			theModel.addAttribute("course", theCourse);
			
			
			theModel.addAttribute("student", theStudent);
			
			return "students/student-form";
		}
		@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
			
			// get the student from the service
			Student theStudent = studentService.findById(theId);
			
			// set student as a model attribute to pre-populate the form
			
			
			theModel.addAttribute("student", theStudent);
			//save the curse to model
			theModel.addAttribute("course",theStudent.getTheCourse());
			
			return "students/student-form";
		}
		@RequestMapping("/save")
		public String saveStudent(@ModelAttribute("student") Student theStudent,@RequestParam("courseId") int theCourseId, Model theModel) {
			
			// save the course
			Course theCourse = courseService.findById(theCourseId);
			//DELETE COPIES if exist
			if (theStudent.getTheCourse() != null) {
			   Student deleteStudent= studentService.findById(theStudent.getId());
			   theCourse.removeStudent(deleteStudent);
			   //studentService.deleteById(theStudent.getId());
			  // courseService.save(theCourse);
			}
			theStudent.CalculateGrade();
			theCourse.addStudent(theStudent);
			courseService.save(theCourse);
			
			//get the course id from model
			int courseId=theCourse.getId();
			// use a redirect to prevent duplicate submissions
			return  "redirect:/students/studentslist?courseId="+ courseId;
		}
		
		@RequestMapping("/delete")
		public String delete(@RequestParam("studentId") int theStudentId, @RequestParam("courseId") int theCourseId) {
			
			// delete the student
			Student deleteStudent= studentService.findById(theStudentId);
			
			Course theCourse = courseService.findById(theCourseId);
			theCourse.removeStudent(deleteStudent);
			
			studentService.deleteById(theStudentId);
			courseService.save(theCourse);
			// redirect to /courses/list
			return "redirect:/students/studentslist?courseId="+ theCourseId;
			
		}
		
		@RequestMapping("/showFormForGrades")
		public String showFormForGrades(@RequestParam("studentId") int theId, Model theModel) {
			
			// get the student from the service
			Student theStudent = studentService.findById(theId);
			
			// set student as a model attribute to pre-populate the form						
			theModel.addAttribute("student", theStudent);
			
			
			//save the curse to model
			theModel.addAttribute("course",theStudent.getTheCourse());
			
			return "students/student-grades";
		}
}




