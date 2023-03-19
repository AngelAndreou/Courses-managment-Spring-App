package project_803;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import project_803.demo.ProjectApplication;
import project_803.demo.controller.CourseController;
import project_803.demo.dao.CourseDAO;
import project_803.demo.instance.Course;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes = {ProjectApplication.class, CourseController.class})
class TestCourseDAOJpa {
	@Autowired 
	CourseDAO courseDAO;
	
	@Test
	void testCourseAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseDAO);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Course storedCourse = courseDAO.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Metafrastes", storedCourse.getName());
	}
}
