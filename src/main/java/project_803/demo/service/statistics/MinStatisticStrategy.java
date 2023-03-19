package project_803.demo.service.statistics;

public class MinStatisticStrategy extends TemplateStatisticStrategy{

	
	public MinStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double min=descriptiveStatistics.getMin();
		statistic=min;
		
	}

}
