package project_803.demo.instance;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	


	


	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "year_of_registration")
	private String registrationYear;
	
	@Column(name = "semester")
	private String semester ;
	
	@Column(name = "grade_project")
	private double projectGrade ;
	
	@Column(name = "grade_exam")
	private double examGrade ;
	
	@Column(name = "weight_project")
	private double projectWeight ;
	
	@Column(name = "weight_exam")
	private double examWeight ;
	
	@Column(name = "total_grade")
	private double totalGrade ;
	
	@Column(name= "year_of_studies")
	private String studiesYear;

	
	
	@ManyToOne
    @JoinColumn(name="course_id")
	private Course theCourse;
	
// define constructors
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String registrationYear, String semester) {
		super();
		this.id = id;
		this.name = name;
		this.registrationYear = registrationYear;
		this.semester = semester;
	}
	
	public Student( String name, String registrationYear, String semester) {
		super();
		
		this.name = name;
		this.registrationYear = registrationYear;
		this.semester = semester;
	}

	public Student(int id, String name, String registrationYear, String semester, double projectGrade,
			double examGrade) {
		super();
		this.id = id;
		this.name = name;
		this.registrationYear = registrationYear;
		this.semester = semester;
		this.projectGrade = projectGrade;
		this.examGrade = examGrade;
	}
	
	
//define methods
	
	
	/**

	 * @return apo8hkeyetai kai epistreyetai o telikos ba8mos
	 */
	public double CalculateGrade() {
		this.totalGrade=this.examGrade * examWeight + this.projectGrade * projectWeight;
		return this.totalGrade;
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

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public double getProjectGrade() {
		return projectGrade;
	}

	public void setProjectGrade(double projectGrade) {
		this.projectGrade = projectGrade;
	}

	public double getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(double examGrade) {
		this.examGrade = examGrade;
	}

	/**
	 * @return the projectWeight
	 */
	public double getProjectWeight() {
		return projectWeight;
	}

	/**
	 * @param projectWeight the projectWeight to set
	 */
	public void setProjectWeight(double projectWeight) {
		this.projectWeight = projectWeight;
	}

	/**
	 * @return the examWeight
	 */
	public double getExamWeight() {
		return examWeight;
	}

	/**
	 * @param examWeight the examWeight to set
	 */
	public void setExamWeight(double examWeight) {
		this.examWeight = examWeight;
	}

	public double getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(double totalGrade) {
		this.totalGrade = totalGrade;
	}



	/**
	 * @return the studiesYear
	 */
	public String getStudiesYear() {
		return studiesYear;
	}

	/**
	 * @param studiesYear the studiesYear to set
	 */
	public void setStudiesYear(String studiesYear) {
		this.studiesYear = studiesYear;
	}

	/**
	 * @return the theCourse
	 */
	public Course getTheCourse() {
		return theCourse;
	}

	/**
	 * @param the theCourse to set
	 */
	public void  setTheCourse(Course theCourse) {
		 this.theCourse=theCourse;
	}

	//define tostring
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", registrationYear=" + registrationYear + ", semester="
				+ semester + ", projectGrade=" + projectGrade + ", examGrade=" + examGrade + ", totalGrade="
				+ totalGrade + "]";
	}
	

	
	
	
	

}
