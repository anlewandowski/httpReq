package httpRequest;

public class Pricing {
	private String currencyCode;
	private String currentMinimumSellingPrice;
	private String qvcMinimumPrice;
	private SpecialPriceType specialPriceType;
	
	@Override
	public String toString(){
		return currencyCode + "\t" + currentMinimumSellingPrice + "\t" + qvcMinimumPrice + "\t DESCRIPTION: " + specialPriceType;
	}
}
