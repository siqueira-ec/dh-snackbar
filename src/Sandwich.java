import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sandwich extends Snack {
	private final double cookTime = 15;
	private List<String> ingredients = new ArrayList<String>(10);
	private Consumer<String> ingredientsConsumer = ingredient -> this.ingredients.add(ingredient);
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		ingredients.forEach(ingredientsConsumer);
	}
	
	@Override
	public double getDeliveryTime() {
		return (super.getDeliveryTime() + cookTime);
	}
	
}
