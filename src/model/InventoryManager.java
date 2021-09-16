package model;

import java.util.ArrayList;

public class InventoryManager
{
	private static InventoryManager instance;
	
	public static InventoryManager getInstance()
	{
		if(instance == null)
		{
			instance = new InventoryManager();;
		}
		
		return instance;
	}
	
	// Relationships
	
	ArrayList<Ingredients> ingredients;
	
	private InventoryManager()
	{
		ingredients = new ArrayList<>();
	}
	
	
	
}
