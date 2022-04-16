package co.createiq.model;

public class Mobile {
	
	public static void main(String[] args) {
		Network network = new AirtelNetwork();
		network.calls();
		network.data();
		network.sms();
	}

}
