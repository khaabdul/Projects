package com.ReciptAl;

import java.util.LinkedList;
import java.util.Scanner;

public class Workclass implements work {
	int con;

	public void insert(Scanner sc, work wc, Bean bean, LinkedList<Bean> list) {
		while (true) {
			bean = new Bean();
			sc.nextLine();
			System.out.println("1.  Enter Student's Name");
			String name = sc.nextLine();
			for (;;) {
				System.out.println("2.  Enter Student's Mobile Number");
				long mobile = sc.nextLong();
				if (mobile > 999999999l && mobile <= 9999999999l) {
					bean.setMobile(mobile);
					break;
				} else {
					System.out.println("Mobile Number Must Have 10 numbers");
				}
			}
			try {
				while (true) {
					System.out.println("3.  Enter Student's Cousre");
					System.out.println("java/c++/python");
					String course = sc.next();
					if (course.equalsIgnoreCase("c++")) {
						bean.setCourse(course);
						System.out.println("Fees Of C++ Is 25000 ");
						bean.setCourseFee(25000);
						for (;;) {
							System.out.println("4.  Enter paid fee");
							long fee = sc.nextLong();
							if (fee <= 25000) {
								bean.setPaid_fee(fee);
								break;
							} else {
								System.out.println("Enter Value Upto 25000");
							}
						}
						break;
					} else if (course.equalsIgnoreCase("java")) {
						bean.setCourseFee(30000);
						System.out.println("Fees Of Java Is 30000 ");
						bean.setCourse(course);
						for (;;) {
							System.out.println("4.  Enter paid fee");
							long fee = sc.nextLong();
							if (fee <= 30000) {
								bean.setPaid_fee(fee);
								break;
							} else {
								System.out.println("Enter Value Upto 30000");
							}
						}
						break;
					} else if (course.equalsIgnoreCase("python")) {
						bean.setCourseFee(40000);
						System.out.println("Fees Of Python Is 40000 ");
						bean.setCourse(course);
						for (;;) {
							System.out.println("4.  Enter paid fee");
							long fee = sc.nextLong();
							if (fee <= 40000) {
								bean.setPaid_fee(fee);
								break;
							} else {
								System.out.println("Enter Value Upto 40000");
							}
						}
						break;
					} else {
						System.out.println("Please Enter Valid Input We Dont Have " + course + " Option ");
					}
				}
			} catch (Exception e) {
				System.out.println("Please Enter Valid Data");
			}
			try {
				for (;;) {
					System.out.println("5.  Enter Date of Joing ");
					String date_of_join;
					for (;;) {
						System.out.println("Enter Date");
						int date = sc.nextInt();
						if (date <= 31) {
							date_of_join = date + "/";
							break;
						} else {
							System.out.println("Enter Valid Date");
						}
					}
					for (;;) {
						System.out.println("Enter MontH In Number");
						int month = sc.nextInt();
						if (month <= 12) {
							date_of_join = date_of_join + month + "/";
							break;
						} else {
							System.out.println("Enter Valid Month");
						}
					}
					for (;;) {
						System.out.println("Enter Year");
						int Year = sc.nextInt();
						if (Year <= 2023) {
							date_of_join = date_of_join + Year;
							break;
						} else {
							System.out.println("Enter Valid Year");
						}
					}
					bean.setDate_of_joing(date_of_join);
					break;

				}
			} catch (Exception e) {
				System.out.println("Please Enter Valid Data");
			}
			try {
				System.out.println("6.  Enter Paymant Mode");
				while (true) {
					System.out.println("1.CasH/2.OnlinE");
					String mode = sc.next();
					if (mode.equals("1")) {
						bean.setPaymant_mode("CasH");
						break;
					} else if (mode.equals("2")) {
						bean.setPaymant_mode("OnlinE");
						break;
					} else {
						System.out.println("We Have Only 2 Option ");
					}

				}

			} catch (Exception e) {
				System.out.println("Please Enter Valid Data");
			}

			con++;
			bean.setSerial_number(con);
			bean.setName(name);

			list.add(bean);
			System.out.println("save succesfully");
			System.out.println("Do you Want To Add More Data");
			sc.nextLine();
			String in = sc.nextLine();
			if (in.equalsIgnoreCase("n")) {
				break;
			}
		}
	}

	public void genrate_resipt(Scanner sc, work wc, Bean bean, LinkedList<Bean> list) {
		System.out.println("1.INdividual recipt/2.All data");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("   Enter student name to genrate the recipt ");
			sc.nextLine();
			String name = sc.nextLine();
			for (Bean obj : list) {
				if (obj.getName().equals(name)) {
					System.out.println("1.  Serial Number          :" + obj.getSerial_number());
					System.out.println("2.  Student Name           :" + obj.getName());
					System.out.println("3.  Student Mobile         :" + obj.getMobile());
					System.out.println("4.  Student Course         :" + obj.getCourse());
					System.out.println("5.  Student Course Fee     :" + obj.getCourseFee());
					System.out.println("6.  Student Date of joing  :" + obj.getDate_of_joing());
					System.out.println("7.  Student paid fee       :" + obj.getPaid_fee());
					System.out.println("8.  Student paymant mod    :" + obj.getPaymant_mode());
					long a = obj.getPaid_fee();
					long bc = obj.getCourseFee();
					System.out.println("9. Student Total balance   :" + (bc - a));
					break;
				}
			}

		} else if (input == 2) {
			for (Bean obj : list) {
				System.out.println("1.  Serial Number          :" + obj.getSerial_number());
				System.out.println("2.  Student Name           :" + obj.getName());
				System.out.println("3.  Student Mobile         :" + obj.getMobile());
				System.out.println("4.  Student Course         :" + obj.getCourse());
				System.out.println("5.  Student Course Fee     :" + obj.getCourseFee());
				System.out.println("6.  Student Date of joing  :" + obj.getDate_of_joing());
				System.out.println("7.  Student paid fee       :" + obj.getPaid_fee());
				System.out.println("8.  Student paymant mod    :" + obj.getPaymant_mode());
				long a = obj.getPaid_fee();
				long bc = obj.getCourseFee();
				System.out.println("9. Student Total balance   :" + (bc - a));
				System.out.println();
			}
		}

	}

	public void delete(Scanner sc, work wc, Bean bean, LinkedList<Bean> list) {
		System.out.println("Enter Name You Want To Delete Data");
		sc.nextLine();
		String name = sc.nextLine();
		for (Bean obj : list) {
			if (obj.getName().equals(name)) {
				list.remove(obj);
			}

		}

	}

	public void Update(Scanner sc, work wc, Bean bean, LinkedList<Bean> list) {
		System.out.println("Enter Name You Want To Update ");
		sc.nextLine();
		String name = sc.nextLine();

		for (Bean obj : list) {
			if (obj.getName().equals(name)) {
				while (true) {
					System.out.println("1.  Student Name           :\r\n" + "2.  Student Mobile        :\r\n"
							+ "3.  Student Course         :\r\n" + "4. Student Date of joing  :\r\n"
							+ "5.  Student paid fee       :\r\n" + "6. Student paymant mod    :\r\n");
					int input = sc.nextInt();
					if (input == 1) {
						System.out.println("Enter Name");
						sc.nextLine();
						String name1 = sc.nextLine();
						obj.setName(name1);
					} else if (input == 2) {
						System.out.println("Enter Mobile No");
						long no = sc.nextLong();
						obj.setMobile(no);
					} else if (input == 3) {
						System.out.println("Enter course");
						sc.nextLine();
						String course = sc.nextLine();
						obj.setCourse(course);
					} else if (input == 4) {
						System.out.println("Enter Date of joining ");
						String date = sc.nextLine();
						obj.setDate_of_joing(date);
					} else if (input == 5) {
						System.out.println("Enter paid fees ");
						long fees = sc.nextLong();
						obj.setPaid_fee(fees);
					} else if (input == 6) {
						System.out.println("Enter Fees Payment Mode");
						sc.nextLine();
						String mode = sc.nextLine();
						obj.setPaymant_mode(mode);
					}
					System.out.println("Do You Want To Make More Updates y/n");
					String in = sc.next();
					if (in.equalsIgnoreCase("n")) {
						break;
					}
				}

			}
		}
	}
}