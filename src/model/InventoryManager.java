package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	private ObservableList<Ingredients> ingredients;
	private static FileWriter fw;
	private static FileReader fr;

	private InventoryManager() {
		ingredients = FXCollections.observableArrayList();
		try {
			fw = new FileWriter("Doc/InventoryReport.txt");
			fr = new FileReader("Doc/InventoryReport.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Ingredients> getInventoryData() {
		return ingredients;
	}
	
	public FileWriter getFW()
	{
		return fw;
	}
	
	public FileReader getFR()
	{
		return fr;
	}

	public void addIngredient(String name, String unit, double amount) {

		Ingredients newIngredient = new Ingredients(name, unit, amount);
		ingredients.add(newIngredient);
	}
	
	public void removeIngredient(int ingIndex)
	{
		ingredients.remove(ingIndex);
	}
	
	public void decreIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).decreAmount(amount);
	}
	
	public void increIngQuantity(int ingIndex, double amount)
	{
		ingredients.get(ingIndex).increAmount(amount);
	}
	
	public void selectionSortIngredients()
	{
		for(int i = 0 ; i < ingredients.size()-1 ; i++)
		{
			for(int j = i+1 ; j < ingredients.size() ; j++)
			{
				if(ingredients.get(i).getAmount() < ingredients.get(j).getAmount())
				{
					Ingredients a = ingredients.get(i);
					Ingredients b = ingredients.get(j);
					
					ingredients.set(i, b);
					ingredients.set(j, a);
				}
			}
		}
	}
	
	public String dataToExport()
	{
		String data = "";
		
		for(Ingredients ingredient : ingredients)
		{
			data += ingredient.toString() + "\n";
		}
		
		return data;
	}
	
	public void addPotato()
	{
		Ingredients potato = new Ingredients("Papa", "Kg", 2500);
		ingredients.add(potato);
	}
}
