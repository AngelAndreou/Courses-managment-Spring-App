package project_803.demo.service;

import java.util.List;

import project_803.demo.instance.*;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);
	
	//public List<Student> findAllByCourseId(int theCourseId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
}
