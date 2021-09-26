package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Employee;

public class StaffList {

	private ArrayList<Employee> list;
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

	public ArrayList<Employee> getList() {
		return list;
	}

	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}
	
	public String printData() {
		String mensaje="";
		for(Employee person: list) {
			mensaje+=person.toString()+"/n";
		}
		return mensaje;
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

	public boolean changePass(String password, String newPass) {
		boolean find = true;  

		for(int i = 0;i < list.size();i++) {
			if(list.get(i).getPassword().equalsIgnoreCase(password)) {
				list.get(i).setPassword(newPass);
				find = false;
			}
		}
		return find;
	}

	public void addEmployee() {
		Employee yisus = new Employee("Jesus", "123", "3/02/2002", "123");
		list.add(yisus);
	}

	public void ornedar() {
		Comparator<Employee> comparadorA =(o1,o2)->{
			return o1.getName().compareToIgnoreCase(o2.getName());
	
		};
		
		Collections.sort(getList(), comparadorA);
	}


}
