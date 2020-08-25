import java.util.ArrayList;
import java.util.List;

public class Snack {
	private double price;
	private double deliveryPrice;
	private double distance;
	private double cookTime;
	private List<String> ingredients = new ArrayList<String>();
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
		deliveryPrice = distance * 0.25;
	}
	
	public double calculateDeliveryTimePerDistance() {
		return 10 * distance;
	}
	
	public double getDeliveryTime() {
		return calculateDeliveryTimePerDistance() + cookTime;
	}
	
	public double getDeliveryPrice() {
		return deliveryPrice;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
