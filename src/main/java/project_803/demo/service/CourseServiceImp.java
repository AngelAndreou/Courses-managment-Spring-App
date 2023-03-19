package project_803.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project_803.demo.dao.CourseDAO;
import project_803.demo.instance.Course;
import project_803.demo.service.statistics.Factory;
import project_803.demo.service.statistics.MaxStatisticStrategy;
//import project_803.demo.service.statistics.MaxStatisticStrategy;
import project_803.demo.service.statistics.MeanStatisticStrategy;
import project_803.demo.service.statistics.StatisticStrategy;
import project_803.demo.service.statistics.TemplateStatisticStrategy;



@Service
public class CourseServiceImp implements CourseService {

	

	@Autowired
	private CourseDAO courseRepository;
	
	//@Autowired
	private HashMap<String, Double> courseStatistics; 
	
	//@Autowired
	private List<StatisticStrategy> statCalculationStrategies;
	
	private String[] statisticStrategies= {"Mean","Kurtosis","Max","Min","Median","Percentiles20","Percentiles40","Percentiles60",
			"Percentiles80","Skewness","StandardDeviation","Variance"};
	
	public CourseServiceImp() {
		super();
	}

	@Autowired
	public CourseServiceImp(CourseDAO theCourseRepository) {
		courseRepository = theCourseRepository;
		courseStatistics=new HashMap<String, Double>();
	}
	//Return the complete Map off the statistics and there value acording to the Strategies Array 
	@Override
	@Transactional
	public HashMap<String, Double> getCourseStatistics(Course theCourse) {
		statCalculationStrategies= new ArrayList<StatisticStrategy>();
		
		for (String statisticName :statisticStrategies) {
			StatisticStrategy statisticStrategy=Factory.create(statisticName);
			statCalculationStrategies.add(statisticStrategy);
			double statistic=statisticStrategy.calculateStatistic(theCourse);
			courseStatistics.put(statisticName, statistic);
		}
		/*
		StatisticStrategy mean=new MeanStatisticStrategy();
		statCalculationStrategies.add(mean);
		double statistic=mean.calculateStatistic(theCourse);
		courseStatistics.put("mean", statistic);
		*/
		
		
		
		
	
		return courseStatistics;
	}
/*
	public void setCourseStatistics(Map<String, Double> courseStatistics) {
		this.courseStatistics = courseStatistics;
	}
*/
	
	/**
	 * @return the statCalculationStrategies
	 */
	public List<StatisticStrategy> getStatCalculationStrategies() {
		return statCalculationStrategies;
	}

	/**
	 * @param statCalculationStrategies the statCalculationStrategies to set
	 */
	public void setStatCalculationStrategies(List<StatisticStrategy> statCalculationStrategies) {
		this.statCalculationStrategies = statCalculationStrategies;
	}

	@Override
	@Transactional
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	@Transactional
	public Course findById(int theId) {
		Course result = courseRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the course
			throw new RuntimeException("Did not find course id - " + theId);
		}
	}

	@Override
	@Transactional
	public List<Course> findByInstructor(String instructor) {
		List<Course> result = courseRepository.findByInstructor(instructor);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the course
			throw new RuntimeException("Did not find course instructor - " + instructor);
		}
	}
	@Override
	@Transactional
	public void save(Course theCourse) {
		courseRepository.save(theCourse);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);
	}
}