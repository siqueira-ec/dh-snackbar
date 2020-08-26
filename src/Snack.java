
public abstract class Snack {
	private double price;
	private double deliveryPrice;
	private double distance;
	private String name;
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDeliveryTime() {
		return 10 * distance;
	}
	
	public double getDeliveryPrice() {
		return deliveryPrice;
	}
	
	public void setDeliveryPrice(double distance) {
		this.deliveryPrice = distance * 0.25;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
