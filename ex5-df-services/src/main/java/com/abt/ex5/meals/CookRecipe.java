package com.abt.ex5.meals;

import java.util.ArrayList;
import java.util.Collection;

public class CookRecipe {
	private String name;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<String> instructions;

	public CookRecipe() {
		ingredients = new ArrayList<Ingredient>();
		instructions = new ArrayList<String>();
	}

	public CookRecipe(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public ArrayList<String> getInstructions() {
		return instructions;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public void addIngredients(Collection<Ingredient> ingredients) {
		this.ingredients.addAll(ingredients);
	}

	public void addInstruction(String instruction) {
		instructions.add(instruction);
	}

	public void addInstructions(Collection<String> instructions) {
		this.instructions.addAll(instructions);
	}
}
