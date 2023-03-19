package project_803.demo.instance;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;







@Entity
@Table(name="courses")
public class Course {
	
	

	// define fields
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="syllabus")
		private String syllabus;
		
		@Column(name="year")
		private int year;
		
		@Column(name="semester")
		private String semester;
		
		@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinColumn(name="course_id")
		//refrencedColumnName = "id"
		private List<Student> students;
		
		@Column(name="description")
		private String description;
		
		@Column(name="instructor")
		private String instructor;

		
			
	// define constructors
		public Course() {
			super();
			this.students = new ArrayList<Student>();
		
		}


		public Course(int id, String name, String syllabus, int year, String semester) {
			super();
			this.id=id;
			this.name = name;
			this.syllabus = syllabus;
			this.year = year;
			this.semester = semester;
			this.students = new ArrayList<Student>();
		}
		
		public Course( String name, String syllabus, int year, String semester) {
			super();
			
			this.name = name;
			this.syllabus = syllabus;
			this.year = year;
			this.semester = semester;
			this.students = new ArrayList<Student>();
		}
		
	//add student option
		
		/**adds a student to this course students list
		 * @param student the student that is just created for this course
		 */
		public void addStudent(Student student) {
			students.add(student);
		}
		
	//add delete option
		
				/**removes a student from this course students list
				 * @param student the student that we want to remove from this course
				 */
				public void removeStudent(Student student) {
					students.remove(student);
				}
		
	//define setters getters

		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getSyllabus() {
			return syllabus;
		}



		public void setSyllabus(String syllabus) {
			this.syllabus = syllabus;
		}



		public int getYear() {
			return year;
		}



		public void setYear(int year) {
			this.year = year;
		}



		public String getSemester() {
			return semester;
		}



		public void setSemester(String semester) {
			this.semester = semester;
		}



		public List<Student> getStudents() {
			return students;
		}



		public void setStudents(List<Student> students) {
			this.students = students;
		}


	/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}


		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}


		/**
		 * @return the instructor
		 */
		public String getInstructor() {
			return instructor;
		}


		/**
		 * @param instructor the instructor to set
		 */
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}


		//define tostring
		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", syllabus=" + syllabus + ", year=" + year + ", semester="
					+ semester + ", students=" + students + "]";
		}
	
 
		
	

}

