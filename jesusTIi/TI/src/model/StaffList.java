package model;

import java.util.ArrayList;

import model.Employee;

public class StaffList {

	private ArrayList<Employee> list;

	public StaffList() {

		setList(new ArrayList<Employee>());

	}

	public ArrayList<Employee> getList() {
		return list;
	}

	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}
	
	public boolean searchUser(String id, String password) {
		boolean find = true;  
		
		for(int i = 0;i < list.size();i++) {
			if(list.get(i).getId().equalsIgnoreCase(id) && list.get(i).getPassword().equalsIgnoreCase(password)) {
				find = false;
			}
		}
		return find;
	}


}
