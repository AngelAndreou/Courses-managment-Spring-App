package project_803.demo.service.statistics;

public class Percentiles80StatisticStrategy extends TemplateStatisticStrategy{

	
	public Percentiles80StatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double percentiles=descriptiveStatistics.getPercentile(80);
		statistic=percentiles;
		
	}

}
