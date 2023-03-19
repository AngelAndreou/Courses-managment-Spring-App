package project_803.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project_803.demo.instance.*;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{
	
    Student findById(int id);
  //  List <Student> findByRegistrationYear(String year);
	List<Student> findByName(String name);
	//List <Student> findByCourseId(int courseId );

}