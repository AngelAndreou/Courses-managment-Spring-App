package project_803.demo.service.statistics;

public class Percentiles20StatisticStrategy extends TemplateStatisticStrategy{

	
	public Percentiles20StatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double percentiles=descriptiveStatistics.getPercentile(20);
		statistic=percentiles;
		
	}

}
