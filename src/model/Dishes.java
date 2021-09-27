package model;

import java.util.ArrayList;

public class Dishes {

	private String name;
	private double price;
	private String ingNames;
	private ArrayList<Ingredients> dishIngredients;
	private ArrayList<String> ingsNames;

	public Dishes(String name, double price, ArrayList<Ingredients> ingredients) {
		super();
		this.name = name;
		this.price = price;
		this.dishIngredients = ingredients;
		ingsNames = new ArrayList<>();
		
		for(int i = 0 ; i < ingredients.size() ; i++)
		{
			ingsNames.add(ingredients.get(i).getName());
		}
		
		ingNames = getIngNames();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<Ingredients> getIngredient() {
		return dishIngredients;
	}

	public void setIngredient(ArrayList<Ingredients> ingredients) {
		this.dishIngredients = ingredients;
	}
	
	public String getIngNames()
	{
		String ingredients = "";
		for(int i = 0 ; i < ingsNames.size() ; i++)
		{
			ingredients += ingsNames.get(i) + ", ";
		}
		return ingredients;
	}
}
