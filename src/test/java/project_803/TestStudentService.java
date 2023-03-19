package project_803;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project_803.demo.dao.StudentDAO;
import project_803.demo.instance.Student;
import project_803.demo.service.StudentService;
import project_803.demo.service.StudentServiceImp;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class TestStudentService {

	@TestConfiguration
    static class StudentServiceImpTestContextConfiguration {

        @Bean
        public StudentService studentService() {
            return new StudentServiceImp();
        }
    }

	@Autowired
	StudentService studentService;
	
	@MockBean
	StudentDAO studentDAO;
	
	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}


	@Test
	void testFindAllReturnStudents() {
		ArrayList<Student> expectedListOfStudents = new ArrayList<Student>();
		expectedListOfStudents.add(new Student(2, "George", "2015", "a"));
		expectedListOfStudents.add(new Student(3, "John", "2017", "d"));
		expectedListOfStudents.add(new Student(8, "Gregory", "1997", "f"));
		Mockito.when(studentDAO.findAll()).thenReturn(expectedListOfStudents);
		List<Student> actualListOfStudents = studentService.findAll();
		Assertions.assertNotNull(actualListOfStudents);
		Assertions.assertEquals("George", actualListOfStudents.get(0).getName());
		Assertions.assertEquals("2015", actualListOfStudents.get(0).getRegistrationYear());
		Assertions.assertEquals("a", actualListOfStudents.get(0).getSemester());
		Assertions.assertEquals("John", actualListOfStudents.get(1).getName());
		Assertions.assertEquals("2017", actualListOfStudents.get(1).getRegistrationYear());
		Assertions.assertEquals("d", actualListOfStudents.get(1).getSemester());
		Assertions.assertEquals("Gregory", actualListOfStudents.get(2).getName());
		Assertions.assertEquals("1997", actualListOfStudents.get(2).getRegistrationYear());
		Assertions.assertEquals("f", actualListOfStudents.get(2).getSemester());
		Assertions.assertEquals(actualListOfStudents.size(),3);
	}

	@Test
	void testFindByIdReturnStudent() {
		Mockito.when(studentDAO.findById(1)).thenReturn(new Student(1, "Andrews", "2020", "b"));
		Student storedStudent = studentService.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Andrews", storedStudent.getName());
		Assertions.assertEquals("2020", storedStudent.getRegistrationYear());
		Assertions.assertEquals("b", storedStudent.getSemester());
	}
}
