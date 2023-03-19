package project_803.demo.service.statistics;

public class SkewnessStatisticStrategy extends TemplateStatisticStrategy{

	
	public SkewnessStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double skewness=descriptiveStatistics.getSkewness();
		statistic=skewness;
		
	}

}
