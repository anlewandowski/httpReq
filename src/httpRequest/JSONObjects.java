package httpRequest;

/**
 * this class returns the fields
 * @author q1415479
 *
 */
public class JSONObjects {
	private String productNumber;
	private String shortDescription;
	private String brandName;
	private Pricing pricing;
	private Shipping shippingAndHandling;
	
	
	@Override
	public String toString(){
		return "\n\nPRODUCT NUMBER: "+ productNumber + "\n\nSHORT DESCRIPTION: " + shortDescription + "\n\nBRAND NAME: " + brandName + "\n\n" + pricing + "\n\n" + shippingAndHandling;
		
		
	}
}
