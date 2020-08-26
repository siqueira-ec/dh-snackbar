import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Dough extends Snack {
	private final double cookTime = 30;
	private List<String> ingredients = new ArrayList<String>(5);
	private Consumer<String> ingredientsConsumer = ingredient -> this.ingredients.add(ingredient);
	private String sauce = "tomato sauce";
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		ingredients.forEach(ingredientsConsumer);
	}
	
	public String getSauce() {
		return sauce;
	}
	
	public void setSauce(String sauce) {
		this.sauce = sauce;
;	}
	
	@Override
	public double getDeliveryTime() {
		return (super.getDeliveryTime() + cookTime);
	}

}
