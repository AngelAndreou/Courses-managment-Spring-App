package project_803.demo.service.statistics;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import project_803.demo.instance.Course;
import project_803.demo.instance.Student;

public abstract class TemplateStatisticStrategy implements StatisticStrategy{
	
	private Course theCourse;
	
	protected double statistic;
	protected List<Double> values;
	protected DescriptiveStatistics descriptiveStatistics;
	
	public TemplateStatisticStrategy() {
		super();
		values = new ArrayList<Double>();
		descriptiveStatistics = new DescriptiveStatistics();
	}

	public double calculateStatistic(Course theCourse) {
		this.theCourse=theCourse;
		prepareDataSet();
		doActualCalculation();
		return statistic;
	}
	private void prepareDataSet() {
		
		List<Student> theStudents = theCourse.getStudents();
		if (!theStudents.isEmpty()) {
			for(Student theStudent:theStudents) {
				values.add(theStudent.getTotalGrade());
				
			}
			
		}
		else 
			values.add(0.0);
		
		for (double v : values) {
		descriptiveStatistics.addValue(v);
		}
		
		
	}
	
	protected abstract void doActualCalculation();
}
