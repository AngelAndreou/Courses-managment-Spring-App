package project_803.demo.service.statistics;

public class KurtosisStatisticStrategy extends TemplateStatisticStrategy{

	
	public KurtosisStatisticStrategy() {
		super();
		
	}

	@Override
	protected void doActualCalculation() {
		double kurtosis=descriptiveStatistics.getKurtosis();
		statistic=kurtosis;
		
	}

}
