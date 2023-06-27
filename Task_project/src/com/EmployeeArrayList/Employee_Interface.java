package com.EmployeeArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public interface Employee_Interface {
	void insert(Scanner sc, EmployeeBean Eb, ArrayList al);

	void show(Scanner sc, ArrayList al, Employee_Interface ec,EmployeeBean Eb);

	void delete(Scanner sc, ArrayList al);

	void update(Scanner sc, ArrayList al);
	
}
