package model;

import java.util.ArrayList;

public class StaffList {

	private static StaffList instance;

	public static StaffList getInstance() {
		if (instance == null) {
			instance = new StaffList();
			;
		}

		return instance;
	}

	private StaffList() {

		setList(new ArrayList<Employee>());

	}

	// Relaciones

	private ArrayList<Employee> list;

	public ArrayList<Employee> getList() {
		return list;
	}

	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}

	public boolean searchUser(String id, String password) {
		boolean find = true;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equalsIgnoreCase(id) && list.get(i).getPassword().equalsIgnoreCase(password)) {
				find = false;
			}
		}
		return find;
	}

}
