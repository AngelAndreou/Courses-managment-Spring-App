package project_803.demo.service.statistics;

public class MedianStatisticStrategy extends TemplateStatisticStrategy{

	
	public MedianStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double median=descriptiveStatistics.getPercentile(50);
		statistic=median;
		
	}

}
