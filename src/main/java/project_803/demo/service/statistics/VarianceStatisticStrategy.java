package project_803.demo.service.statistics;

public class VarianceStatisticStrategy extends TemplateStatisticStrategy{

	
	public VarianceStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double variance=descriptiveStatistics.getVariance();
		statistic=variance;
		
	}

}
