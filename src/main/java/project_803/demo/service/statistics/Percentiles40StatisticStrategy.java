package project_803.demo.service.statistics;

public class Percentiles40StatisticStrategy extends TemplateStatisticStrategy{

	
	public Percentiles40StatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double percentiles=descriptiveStatistics.getPercentile(40);
		statistic=percentiles;
		
	}

}
