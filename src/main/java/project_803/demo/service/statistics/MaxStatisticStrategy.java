package project_803.demo.service.statistics;

public class MaxStatisticStrategy extends TemplateStatisticStrategy{

	
	public MaxStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double max=descriptiveStatistics.getMax();
		statistic=max;
		
	}

}
