
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Consumer<String> printConsumer = ingredient -> System.out.println("-- " + ingredient);

	public static void main(String[] args) {
		System.out.println("Welcome to DH Snackbar! Choose your type of snack: [1]Sandwich [2]Doughs [3]Cakes");
		String snackOption = scanner.nextLine();
		
		switch (snackOption) {
		case "1":
			Sandwich sandwich = sandwichMenu();
			printOrderInfo(sandwich);
			break;
		case "2":
			Dough dough = doughMenu();
			printOrderInfo(dough);
			break;
		case "3":
			Cake cake = cakeMenu();
			printOrderInfo(cake);
			break;
		default:
			break;
		}
	}
	
	public static Sandwich sandwichMenu() {
		Sandwich sandwich = new Sandwich();
		
		List<String> choosenIngredients = ingredientsMenu(10, sandwich);
		double distance = distanceMenu();
		
		sandwich.setName("sandwich");
		sandwich.setPrice(15.5);
		sandwich.setDistance(distance);
		sandwich.setDeliveryPrice(distance);
		sandwich.setIngredients(choosenIngredients);
		
		return sandwich;
	}
	
	public static Dough doughMenu() {
		Dough dough = new Dough();
		
		System.out.println("Ok. Now, please choose your type of dough: [1]Pasta [2]Pizza [3]Lasagna");
		
		String doughOption = scanner.nextLine();
		
		switch (doughOption) {
		case "1":
			dough.setName("pasta");
			break;
		case "2":
			dough.setName("pizza");
			break;
		case "3":
			dough.setName("lasagna");
			break;
		default:
			break;
		}
		
		System.out.println("Gonna choose your sauce? [1]Yes [2]No");
		String wannaChooseSauce = scanner.nextLine();
		String sauce;
		
		switch (wannaChooseSauce) {
		case "1":
			System.out.println("Enter the sauce you want.");
			sauce = scanner.nextLine();
			dough.setSauce(sauce);
			break;
		default:
			break;
		}
		
		List<String> choosenIngredients = ingredientsMenu(5, dough);
		double distance = distanceMenu();
		
		dough.setPrice(28.35);
		dough.setDistance(distance);
		dough.setDeliveryPrice(distance);
		dough.setIngredients(choosenIngredients);
		
		return dough;
	}
	
	public static Cake cakeMenu() {
		Cake cake = new Cake();
		
		System.out.println("Ok. Now, please enter the flavor of the cake.");
		String flavor = scanner.nextLine();
		
		System.out.println("Please enter the filling of the cake.");
		String filling = scanner.nextLine();
		
		System.out.println("Please enter the topping of the cake.");
		String topping = scanner.nextLine();
		
		double distance = distanceMenu();
		
		cake.setName("cake");
		cake.setPrice(36);
		cake.setFlavor(flavor);
		cake.setFilling(filling);
		cake.setTopping(topping);
		cake.setDistance(distance);
		cake.setDeliveryPrice(distance);
		
		return cake;
	}
	
	public static double distanceMenu() {
		System.out.println("Enter delivery distance in km");
		double distance = scanner.nextDouble();
		return distance;
	}

	public static List<String> ingredientsMenu(int limit, Snack snack) {
		System.out.println("Enter the list of ingredients of your " + snack.getName() +
				" separated by newline (up to " + limit + "). When you want to stop, just type 1.");
		
		List<String> choosenIngredients = new ArrayList<String>();
		
		for (int i=0; i<limit; i++) {
			String currentLine = scanner.nextLine().trim();
			
			if (currentLine.equals("1")) {
				break;
			}
			
			choosenIngredients.add(currentLine);
	    }
		
		return choosenIngredients;
	}
	
	public static void printOrderInfo(Snack snack) {	
		if (snack instanceof Sandwich) {
			snack = (Sandwich) snack;
		} else if (snack instanceof Dough) {
			snack = (Dough) snack;
		} else {
			snack = (Cake) snack;
		}
		System.out.println("-> Your order:");
		System.out.println("-- " + snack.getName() + "\n");
		System.out.println("-> Values:");
		System.out.println("-- Delivery: R$ " + snack.getDeliveryPrice());
		System.out.println("-- Price: R$ " + snack.getPrice());
		System.out.println("-- Total: R$ " + (snack.getDeliveryPrice() + snack.getPrice()) + "\n");
		System.out.println("-> ETA:");
		System.out.println("-- " + snack.getDeliveryTime() + " minutes\n");
		
		if (snack instanceof Dough) {
			System.out.println("-> Choosen sauce:");
			System.out.println("-- " + ((Dough) snack).getSauce() + "\n");
		}
		
		if (!(snack instanceof Cake)) {
			System.out.println("-> Choosen ingredients:");
			((Sandwich) snack).getIngredients().forEach(printConsumer);
		} else {
			System.out.println("-> Choosen flavor:");
			System.out.println("-- " + ((Cake) snack).getFlavor() + "\n");
			System.out.println("-> Choosen filling:");
			System.out.println("-- " + ((Cake) snack).getFilling() + "\n");
			System.out.println("-> Choosen topping:");
			System.out.println("-- " + ((Cake) snack).getTopping() + "\n");
		}
	}

}
