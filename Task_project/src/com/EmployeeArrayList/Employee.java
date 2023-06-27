package com.EmployeeArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee implements Employee_Interface {
	public void insert(Scanner sc, EmployeeBean Eb, ArrayList al) {
		System.out.println("How Many Data You Want To Enter");
		int number = sc.nextInt();
		for (int i = 1; i <= number; i++) {
			Eb = new EmployeeBean();
			System.out.println("Enter " + i + " Data ");
			System.out.println("Employee Id");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Employee Name");
			String name = sc.nextLine();
			System.out.println("Employee Address");
			String address = sc.nextLine();
			System.out.println();

			Eb.setId(id);
			Eb.setName(name);
			Eb.setAddress(address);
			al.add(Eb);
			// ll.add(al);
		}
		System.out.println("Success !!!");
	}

	public void show(Scanner sc, ArrayList al, Employee_Interface ec, EmployeeBean Eb) {
		System.out.println("Would you like to View Data  ");
		System.out.println("All data.1/ Individul person.2");
		int in = sc.nextInt();
		if (in == 1) {
			for (Object list : al) {
				Eb = (EmployeeBean) list;
				System.out.println(Eb.getId() + " " + Eb.getName() + " " + Eb.getAddress());
			}
		} else if (in == 2) {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			for (Object list : al) {
				Eb = (EmployeeBean) list;
				if (id == Eb.getId()) {
					System.out.println(Eb.getId() + " " + Eb.getName() + " " + Eb.getAddress());
					break;
				}
			}
		}
	}

	public void delete(Scanner sc, ArrayList al) {
		System.out.println("Enter Id You Want To Delete");
		int id = sc.nextInt();
		for (Object list : al) {
			EmployeeBean Eb = (EmployeeBean) list;
			if (id == Eb.getId()) {
				al.remove(Eb);
				break;
			}
		}
		System.out.println("Success !!!");
	}

	public void update(Scanner sc, ArrayList al) {
		System.out.println("Enter Id You Want To Update");
		int id = sc.nextInt();
		for (Object list : al) {
			EmployeeBean Eb = (EmployeeBean) list;
			if (id == Eb.getId()) {
				System.out.println("Enter Name to update ");
				sc.nextLine();
				String name = sc.nextLine();
				Eb.setName(name);
				System.out.println("Do You Want To Update Address y/n");
				char input = sc.next().charAt(0);
				if (input == 'y') {
					System.out.println("Enter Address To update");
					sc.nextLine();
					String address = sc.nextLine();
					Eb.setAddress(address);
				}
				break;
			}
		}
		System.out.println("Success !!!");
	}

}
