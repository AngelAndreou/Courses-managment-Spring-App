package project_803;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import project_803.demo.ProjectApplication;
import project_803.demo.controller.StudentController;
import project_803.demo.instance.Student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes = {ProjectApplication.class, StudentController.class})
@AutoConfigureMockMvc
class TestStudentController {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	StudentController studentController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	void testControllerIsNotNull() {
		Assertions.assertNotNull(studentController);
	}

	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}


	@WithMockUser(value = "admin")
	@Test
	void testListStudentsReturnPage() throws Exception {
		mockMvc.perform(get("/studentslist")).
				andExpect(status().isOk()).
				andExpect(model().attributeExists("students")).
				andExpect(view().name("students/list-students"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testSaveStudentReturnsPage() throws Exception {

		Student student = new Student(1, "Gregory", "2015", "m");

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", Integer.toString(student.getId()));
		multiValueMap.add("name", student.getName());
		multiValueMap.add("registrationYear", student.getRegistrationYear());
		multiValueMap.add("semester", student.getSemester());

		mockMvc.perform(
						post("/save").
								params(multiValueMap)).
				andExpect(status().isFound()).
				andExpect(view().name("redirect:/students/list-students"));
	}
}
