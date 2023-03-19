package project_803.demo.service.statistics;

public class StandardDeviationStatisticStrategy extends TemplateStatisticStrategy{

	
	public StandardDeviationStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double stDeviation=descriptiveStatistics.getStandardDeviation();
		statistic=stDeviation;
		
	}

}
