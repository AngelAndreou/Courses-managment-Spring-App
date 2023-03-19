package project_803.demo.service.statistics;


public class Factory {
	public Factory() {}
	
	public static StatisticStrategy create (String choice) {
		if(choice.equals("Mean"))
			return new MeanStatisticStrategy();
		else if(choice.equals("Kurtosis"))
			return new KurtosisStatisticStrategy();
		else if(choice.equals("Max"))
			return new MaxStatisticStrategy();
		else if(choice.equals("Median"))
			return new MedianStatisticStrategy();
		else if(choice.equals("Min"))
			return new MinStatisticStrategy();
		else if(choice.equals("Percentiles20"))
			return new Percentiles20StatisticStrategy();
		else if(choice.equals("Percentiles40"))
			return new Percentiles40StatisticStrategy();
		else if(choice.equals("Percentiles60"))
			return new Percentiles60StatisticStrategy();
		else if(choice.equals("Percentiles80"))
			return new Percentiles80StatisticStrategy();
		else if(choice.equals("Skewness"))
			return new SkewnessStatisticStrategy();
		else if(choice.equals("StandardDeviation"))
			return new StandardDeviationStatisticStrategy();
		else
			return new VarianceStatisticStrategy();
	}
}
