package httpRequest;

public class Shipping {
	private String shippingHandlingCharge;
	private String discountCode;
	
	@Override
	public String toString(){
		return "SHIPPING CHARGES: " + shippingHandlingCharge + "\t DISCOUNT CODE: " + discountCode;
	}
}
