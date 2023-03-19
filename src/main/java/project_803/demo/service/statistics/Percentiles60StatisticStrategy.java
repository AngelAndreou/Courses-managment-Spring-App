package project_803.demo.service.statistics;

public class Percentiles60StatisticStrategy extends TemplateStatisticStrategy{

	
	public Percentiles60StatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double percentiles=descriptiveStatistics.getPercentile(60);
		statistic=percentiles;
		
	}

}
