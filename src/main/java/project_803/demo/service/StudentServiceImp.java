package project_803.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project_803.demo.dao.StudentDAO;
import project_803.demo.instance.Student;

@Service
public class StudentServiceImp implements StudentService {

	

	@Autowired
	private StudentDAO studentRepository;
	
	public StudentServiceImp() {
		super();
	}

	@Autowired
	public StudentServiceImp(StudentDAO theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	/*
	@Override
	@Transactional
	public List<Student> findAllByCourseId(int theCourseId) {
		
		return studentRepository.findByCourseId(theCourseId);
	}
	 */
	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}
}