package com.abt.ex5.meals;

public class Ingredient {
	private String measure;
	private String unitOfMeasure;
	private String name;

	public Ingredient(String name, String measure, String unitOfMeasure) {
		this.measure = measure;
		this.unitOfMeasure = unitOfMeasure;
		this.name = name;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return measure + " " + unitOfMeasure + " " + name;
	}
}
