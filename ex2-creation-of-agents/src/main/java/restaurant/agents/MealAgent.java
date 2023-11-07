package restaurant.agents;

import jade.core.Agent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import restaurant.meals.CookRecipe;
import restaurant.meals.Ingredient;

@SuppressWarnings("serial")
public class MealAgent extends Agent {

	private ArrayList<CookRecipe> recipes;

	protected void init() {

		recipes = new ArrayList<CookRecipe>(
				Arrays.asList(
						new CookRecipe("Apple Pie"),
						new CookRecipe("Chicken Soup"),
						new CookRecipe("Green Salad"),
						new CookRecipe("Sushi")));

		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(
				Arrays.asList(
						new Ingredient("frozen apples", "1", "package"),
						new Ingredient("sugar", "2/3", "cup"),
						new Ingredient("salt", "1", "teaspoon"),
						new Ingredient("large eggs", "2", ""),
						new Ingredient("butter", "2/3", "cup")));

		ArrayList<String> instructions = new ArrayList<String>(
				Arrays.asList(
						"Preheat oven",
						"Mix sugar ...",
						"Stir in flour ...",
						"Bake"));

		for (CookRecipe recipe : recipes) {
			recipe.addIngredients(ingredients);
			recipe.addInstructions(instructions);
		}
	}

	@Override
	protected void setup() {
		this.init();

		System.out.println("Hello I am " + this.getLocalName() + ".");
		System.out.println("What is your order?");
		System.out.print("Answer: ");

		Scanner in = new Scanner(System.in);
		String order = in.nextLine();
		in.close();

		CookRecipe recipe = this.recipes.stream()
				.filter(r -> order.toLowerCase().equals(r.getName().toLowerCase()))
				.findAny()
				.orElse(null);

		if (recipe == null) {
			System.out.println("Sorry no such meal in our menu.");
		} else {
			System.out.println("\n------------------------");
			System.out.println("\t" + recipe.getName());
			System.out.println("------------------------");

			System.out.println("\nIngredients:");
			for (Ingredient ingredient : recipe.getIngredients()) {
				System.out.println(" " + ingredient);
			}

			System.out.println("\nInstructions:");
			for (String instruction : recipe.getInstructions()) {
				System.out.println(" " + instruction);
			}
		}
	}
}
