package Opps_taskArray;

import java.util.Scanner;

public interface Student_Interface {
	Object[] insert(Scanner sc, Student_Bean sb, Object[] data, int in);

	void delete(Student_Bean sb, Object[] data, Scanner sc);

	void show(Student_Bean sb, Object[] data, Scanner sc);

	void update(Student_Bean sb, Object[] data, Scanner sc);
}
