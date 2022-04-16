package co.createiq.model;

public class AirtelNetwork implements Network{
	
	public void sms() {
		System.out.println("Airtel SMS");
	}
	
	public void data() {
		System.out.println("Airtel Data");
	}
	
	public void calls() {
		System.out.println("Airtel Calls");
	}

}
