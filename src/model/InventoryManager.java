package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryManager {
	private static InventoryManager instance;

	public static InventoryManager getInstance() {
		if (instance == null) {
			instance = new InventoryManager();
		}

		return instance;
	}

	// Relationships

	ObservableList<Ingredients> ingredients;

	private InventoryManager() {
		ingredients = FXCollections.observableArrayList();
	}

	public ObservableList<Ingredients> getInventoryData() {
		return ingredients;
	}

	public void addIngredient(String name, String unit, double amount) {

		Ingredients newIngredient = new Ingredients(name, unit, amount);
		ingredients.add(newIngredient);
	}
	
	public void decreIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).decreAmount(amount);
	}
	
	public void increIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).increAmount(amount);
	}
}
