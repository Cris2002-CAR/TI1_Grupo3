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
	
	private InventoryManager()
	{
		
	}
	
	// Relationships
	
	ArrayList<Ingredients> ingredients = new ArrayList<>();
	
	
}
