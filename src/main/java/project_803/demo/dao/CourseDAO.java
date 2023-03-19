package project_803.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_803.demo.instance.Course;




@Repository
public interface CourseDAO extends JpaRepository<Course, Integer>{
	
	Course findById(int id);
	List<Course> findByName(String name);
	List<Course> findByInstructor(String instructor);
	

}
