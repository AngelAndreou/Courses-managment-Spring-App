package project_803.demo.service.statistics;

public class MeanStatisticStrategy extends TemplateStatisticStrategy{

	
	public MeanStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double mean=descriptiveStatistics.getMean();
		statistic=mean;
		
	}

}
