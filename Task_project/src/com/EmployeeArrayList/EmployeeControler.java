package com.EmployeeArrayList;

import java.util.ArrayList;

import java.util.LinkedList;
//import java.util.List;
import java.util.Scanner;

public class EmployeeControler {
	public static void main(String[] args) {
		EmployeeBean Eb = new EmployeeBean();
		Employee_Interface ec = new Employee();
		ArrayList al = new ArrayList();
		// LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Employee Data");
		while (true) {
			System.out.println("Select For Operation");
			System.out.println("1.insert/2.show/3.delete/4.update/5.exit");
			int op = sc.nextInt();
			switch (op) {
			case 1: {
				ec.insert(sc, Eb, al);
				break;
			}
			case 2: {
				ec.show(sc, al, ec, Eb);
				break;
			}
			case 3: {
				ec.delete(sc, al);
				break;
			}
			case 4: {
				ec.update(sc, al);
				break;
			}
			case 5: {
				break;
			}
			}
		}

	}
}
