
public class Cake extends Snack {
	private final double cookTime = 10;
	private String flavor;
	private String filling;
	private String topping;
	
	@Override
	public double getDeliveryTime() {
		return (super.getDeliveryTime() + cookTime);
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getFilling() {
		return filling;
	}

	public void setFilling(String filling) {
		this.filling = filling;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}
	
}
