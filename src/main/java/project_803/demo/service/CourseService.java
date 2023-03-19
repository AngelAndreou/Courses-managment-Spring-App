package project_803.demo.service;

import java.util.HashMap;
import java.util.List;

import project_803.demo.instance.Course;

public interface CourseService {
	
	public List<Course> findAll();

	public Course findById(int theId);
	
	public void save(Course theCourse);
	
	public void deleteById(int theId);

	public List<Course> findByInstructor(String theInstructor);

	public HashMap<String, Double> getCourseStatistics(Course theCourse);
	
}
