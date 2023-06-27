package Opps_taskArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Service implements Student_Interface {

	public Object[] insert(Scanner sc, Student_Bean sb, Object[] data, int in) {
		int count = 0;
		for (int i = 1; i <= in; i++) {
			sb = new Student_Bean();
			System.out.println("Please Enter " + i + " data");
			System.out.println("Enter ID");
			int id = sc.nextInt();
			System.out.println("Enter Name");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Enter Address");
			String address = sc.nextLine();
			System.out.println();

			sb.setId(id);
			sb.setName(name);
			sb.setAddress(address);

			data[count] = sb;
			count++;
		}
		System.out.println("Succesfull !!!");
		return data;

	}

	public void show(Student_Bean sb, Object[] data, Scanner sc) {
		System.out.println("1.All data/2.Paticular");
		int in = sc.nextInt();
		if (in == 1) {
			for (Object list : data) {
				sb = (Student_Bean) list;
				if (sb.getId() != 0 && !sb.getName().equals("null") && !sb.getAddress().equals("null")) {
					System.out.println(sb.getId() + "  " + sb.getName() + "  " + sb.getAddress());
				}
			}
		} else if (in == 2) {
			System.out.println("Enter Id You Want To View");
			int input = sc.nextInt();
			for (Object list : data) {
				sb = (Student_Bean) list;
				if (input == sb.getId()) {
					if (sb.getId() != 0 && !sb.getName().equals("null") && !sb.getAddress().equals("null")) {
						System.out.println(sb.getId() + "  " + sb.getName() + "  " + sb.getAddress());
					} 
					break;
				}
			}
		}

	}

	public void delete(Student_Bean sb, Object[] data, Scanner sc) {
		System.out.println("Enter Id You Want To Delete");
		int id = sc.nextInt();
		for (Object list : data) {
			sb = (Student_Bean) list;
			if (id == sb.getId()) {
				sb.setId(0);
				sb.setName(null);
				sb.setAddress(null);
			}
		}
		System.out.println("Succesfull !!!");
	}

	public void update(Student_Bean sb, Object[] data, Scanner sc) {
		System.out.println("Enter Id You Want To Update");
		int id = sc.nextInt();
		for (Object list : data) {
			sb = (Student_Bean) list;
			if (id == sb.getId()) {
				System.out.println("Enter Updated Name");
				sc.nextLine();
				String name = sc.nextLine();
				sb.setName(name);
				System.out.println("Do you Want To Update Address y/n");
				char in = sc.next().charAt(0);
				if (in == 'y') {
					System.out.println("Enter Updated Address");
					sc.nextLine();
					String address = sc.nextLine();
					sb.setAddress(address);
				}
				break;
			}
		}
		System.out.println("Succesfull !!!");

	}
}
