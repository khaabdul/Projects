package com.libraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class SI_Controler {
	static {
		System.out.println("....Welcome To TECKSKILL....");
		System.out.println("       Library System");
	}

	public static void main(String[] args) throws IOException {
		String password = "1234";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Student_Bean student_Bean = new Student_Bean();
		Libraray_Bean libraray_Bean = new Libraray_Bean();
		SI_Interface si_interface = new SI_Service();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println();
		System.out.println("Select....Student / Librarian");
		String input = br.readLine();
		if (input.equalsIgnoreCase("student")) {
			System.out.println("Welcom To Library System");
			while (true) {
				System.out.println("Select.....Insert/Update/Delete/Show/Exit");
				String inPut = br.readLine();
				if (inPut.equalsIgnoreCase("insert")) {
					si_interface.student_Insert(br, student_Bean, libraray_Bean, si_interface, sdf);
				} else if (inPut.equalsIgnoreCase("update")) {
					si_interface.student_Update(br, student_Bean, libraray_Bean, si_interface, sdf);
				} else if (inPut.equalsIgnoreCase("delete")) {
					si_interface.student_Delete(br, student_Bean, libraray_Bean, si_interface);
				} else if (inPut.equalsIgnoreCase("Show")) {
					si_interface.student_Show(br, student_Bean, libraray_Bean, si_interface);
				} else if (inPut.equalsIgnoreCase("exit")) {
					si_interface.exit(br, student_Bean, libraray_Bean, si_interface);
					break;
				} else {
					System.out.println("Invalid Input!!!!!!");
				}

			}
		} else if (input.equalsIgnoreCase("librarian")) {
			System.out.println("Enter Password");
			String pass = br.readLine();
			if (pass.equals(password)) {
				System.out.println("Welcome");
				while (true) {
					System.out.println("Select.....Insert/Update/Delete/Show/Exit");
					String inPut = br.readLine();
					if (inPut.equalsIgnoreCase("insert")) {
						si_interface.librarian_Insert(br, student_Bean, libraray_Bean, si_interface);
					} else if (inPut.equalsIgnoreCase("update")) {
						si_interface.librarian_update(br, student_Bean, libraray_Bean, si_interface);
					} else if (inPut.equalsIgnoreCase("delete")) {
						while (true) {
							System.out.println("Student/Books");
							String show = br.readLine();
							if (show.equalsIgnoreCase("Student")) {
								si_interface.student_Delete(br, student_Bean, libraray_Bean, si_interface);
								break;
							} else if (show.equalsIgnoreCase("books")) {
								si_interface.librarian_delete(br, student_Bean, libraray_Bean, si_interface);
								break;
							} else {
								System.out.println("Invalid !!");
							}
						}
					} else if (inPut.equalsIgnoreCase("Show")) {
						while (true) {
							System.out.println("Student/Books");
							String show = br.readLine();
							if (show.equalsIgnoreCase("Student")) {
								si_interface.student_Data(br, student_Bean, libraray_Bean, si_interface);
								break;
							} else if (show.equalsIgnoreCase("Books")) {
								si_interface.librarian_show(br, student_Bean, libraray_Bean, si_interface);
								break;
							} else {
								System.out.println("Invalid !!");
							}
						}
					} else if (inPut.equalsIgnoreCase("exit")) {
						si_interface.exit(br, student_Bean, libraray_Bean, si_interface);
						break;
					} else {
						System.out.println("Invalid Input!!!!! Try Again");

					}

				}

			} else {
				System.out.println("TRY Again!!!!!!");
			}
		} else {
			System.out.println("Invalid Input!!!!! Try Again");
			SI_Controler.main(args);
		}

	}
}
