package project_803;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project_803.demo.ProjectApplication;
import project_803.demo.controller.StudentController;
import project_803.demo.dao.StudentDAO;
import project_803.demo.instance.Student;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes = {ProjectApplication.class, StudentController.class})
class TestStudentDAOJpa {

	@Autowired
	StudentDAO studentDAO;

	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentDAO);
	}

	@Test
	void testFindByIdReturnsStudent() {
		Student storedStudent = studentDAO.findById(1);
		Assertions.assertNotNull(storedStudent);
	}
}
