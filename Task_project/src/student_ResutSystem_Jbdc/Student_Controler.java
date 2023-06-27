package student_ResutSystem_Jbdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Student_Controler {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Student_Interface si = new Student_Work();
		Student_Bean sb = new Student_Bean();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedHashSet ls = new LinkedHashSet();
		System.out.println("Welcome To Result System........");
		while (true) {
			System.out.println("1.insert/2.sHow/3.delete/4.update/5.exit");
			int in = Integer.parseInt(br.readLine());
			if (in == 1) {
				si.insert(si, sb, br, ls);
			} else if (in == 2) {
				si.show(si, sb, br, ls);
			} else if (in == 3) {
				si.delete(si, sb, br, ls);
			} else if (in == 4) {
				si.update(si, sb, br, ls);
			} else if (in == 5) {
				System.out.println("THANK YOU !!!!!!");
				si.exit(si, sb, br, ls);
				break;
			}

		}

	}
}
