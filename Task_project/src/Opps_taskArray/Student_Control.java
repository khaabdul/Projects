package Opps_taskArray;

import java.util.Arrays;
import java.util.Scanner;

public class Student_Control {
	public static void main(String[] args) {
		System.out.println("Welcome To Student Records");
		Scanner sc = new Scanner(System.in);
		Student_Bean sb = new Student_Bean();
		Student_Interface s = new Service();
		System.out.println("how many data Data");
		int in = sc.nextInt();
		Object[] data = new Object[in];
		s.insert(sc, sb, data, in);
		while (true) {
			System.out.println("Select Operation");
			System.out.println("2.show/3.update/4.delete/5.exit");
			int input = sc.nextInt();
			if (input == 2) {
				s.show(sb, data, sc);
			} else if (input == 3) {
				s.update(sb, data, sc);
			} else if (input == 4) {
				s.delete(sb, data, sc);
			} else if (input == 5) {
				System.out.println("Succesfull!!!! ");
				break;
			} else {
				System.out.println("Please Select Proper Operation");
			}

		}

	}
}
