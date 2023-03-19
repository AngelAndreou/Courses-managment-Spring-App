package project_803;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project_803.demo.dao.CourseDAO;
import project_803.demo.instance.Course;
import project_803.demo.service.CourseService;
import project_803.demo.service.CourseServiceImp;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class TestCourseService {

	@TestConfiguration
    static class CourseServiceImplTestContextConfiguration {
 
        @Bean
        public CourseService courseService() {
            return new CourseServiceImp();
        }
    }

	@Autowired 
	CourseService courseService;

	@MockBean
	CourseDAO courseDAO;
	
	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}


	@Test
	void testFindByIdReturnCourse() {
		Mockito.when(courseDAO.findById(1)).thenReturn(new Course(2,"Robotikh", "TurtleBot 3", 2021, "d"));
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Robotikh", storedCourse.getName());
		Assertions.assertEquals("TurtleBot 3", storedCourse.getSyllabus());
		Assertions.assertEquals(2021, storedCourse.getYear());
		Assertions.assertEquals("d", storedCourse.getSemester());
	}

	@Test
	void testFindByAllReturnCourse() {
		ArrayList<Course> expectedListOfCourses = new ArrayList<Course>();
		expectedListOfCourses.add(new Course(2,"Didaktikh Plhroforikhs", "Teaching students", 2021, "a"));
		expectedListOfCourses.add(new Course(2,"Robotikh", "TurtleBot 3", 2021, "d"));
		expectedListOfCourses.add(new Course(2,"Theoria Ypologismou", "Turing Machine", 2020, "f"));
		Mockito.when(courseDAO.findAll()).thenReturn(expectedListOfCourses);
		List<Course> actualListOfCourses = courseService.findAll();
		Assertions.assertNotNull(actualListOfCourses);
		Assertions.assertEquals("Didaktikh Plhroforikhs", actualListOfCourses.get(0).getName());
		Assertions.assertEquals("Teaching students", actualListOfCourses.get(0).getSyllabus());
		Assertions.assertEquals(2021, actualListOfCourses.get(0).getYear());
		Assertions.assertEquals("a", actualListOfCourses.get(0).getSemester());

		Assertions.assertEquals("Robotikh", actualListOfCourses.get(1).getName());
		Assertions.assertEquals("TurtleBot 3", actualListOfCourses.get(1).getSyllabus());
		Assertions.assertEquals(2021, actualListOfCourses.get(1).getYear());
		Assertions.assertEquals("d", actualListOfCourses.get(1).getSemester());

		Assertions.assertEquals("Theoria Ypologismou", actualListOfCourses.get(2).getName());
		Assertions.assertEquals("Turing Machine", actualListOfCourses.get(2).getSyllabus());
		Assertions.assertEquals(2020, actualListOfCourses.get(2).getYear());
		Assertions.assertEquals("f", actualListOfCourses.get(2).getSemester());

		Assertions.assertEquals(actualListOfCourses.size(),3);
	}
}
