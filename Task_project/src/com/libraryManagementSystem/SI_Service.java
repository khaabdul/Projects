package com.libraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SI_Service implements SI_Interface {
	Connection con = ConnectionClass.connection();

	public void librarian_Insert(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {

		try {
			System.out.println("Enter Shell No");
			libraray_Bean.setShell(Integer.valueOf(br.readLine()));
			System.out.println("Enter Ars Books");
			libraray_Bean.setArts(br.readLine());
			System.out.println("Enter Science Books");
			libraray_Bean.setScience(br.readLine());
			System.out.println("Enter Commerce Books");
			libraray_Bean.setCommerce(br.readLine());

			PreparedStatement addlibrary = con
					.prepareStatement("insert into books(shelno,arts,science,commerce) values (?,?,?,?)");
			addlibrary.setInt(1, libraray_Bean.getShell());
			addlibrary.setString(2, libraray_Bean.getArts());
			addlibrary.setString(3, libraray_Bean.getScience());
			addlibrary.setString(4, libraray_Bean.getCommerce());
			addlibrary.executeUpdate();
			System.out.println("Inserted Succesdfully!!!");

		} catch (NumberFormatException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void librarian_show(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		try {
			PreparedStatement show = con.prepareStatement("select * from books");
			ResultSet showdata = show.executeQuery();
			while (showdata.next()) {
				System.out.println(showdata.getInt(1) + "\t" + showdata.getString(2) + "\t" + showdata.getString(3)
						+ "\t" + showdata.getString(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void librarian_delete(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		try {
			System.out.println("Enter Shell No You Want To Delete");
			int shelno = Integer.valueOf(br.readLine());
			PreparedStatement delete = con.prepareStatement("delete from books where shelno=" + shelno);
			delete.executeUpdate();
			System.out.println("Deleted Succesfully!!!!");
		} catch (NumberFormatException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void librarian_update(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		try {
			System.out.println("Enter Shell No You Want To Update");
			int shelno = Integer.valueOf(br.readLine());
			System.out.println("Enter Arts Books");
			libraray_Bean.setArts(br.readLine());
			System.out.println("Enter Science Books");
			libraray_Bean.setScience(br.readLine());
			System.out.println("Enter Commerce Books");
			libraray_Bean.setCommerce(br.readLine());

			PreparedStatement update = con
					.prepareStatement("update books set arts=?,science=?,commerce=? where shelno=" + shelno);
			update.setString(1, libraray_Bean.getArts());
			update.setString(2, libraray_Bean.getScience());
			update.setString(3, libraray_Bean.getCommerce());
			update.executeUpdate();
			System.out.println("Updated Succesfully!!!!");
		} catch (NumberFormatException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void exit(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		try {
			con.close();
			br.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

	public void student_Insert(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface, SimpleDateFormat sdf) {
		try {
			while (true) {
				System.out.println("Enter Id");
				int id = Integer.valueOf(br.readLine());
				PreparedStatement matchId = con.prepareStatement("select id from student where id=" + id);
				ResultSet mId = matchId.executeQuery();
				if (mId.next()) {
					if (id == mId.getInt(1)) {
						System.out.println("Id Connot Be Same");
					}
				} else {
					student_Bean.setId(id);
					break;
				}
			}
			System.out.println("Enter Name ");
			student_Bean.setName(br.readLine());
			while (true) {
				System.out.println("Enter Phone Number");
				String number = br.readLine();
				if (number.matches("^\\d{10}$")) {
					student_Bean.setNumber(number);
					break;
				} else {
					System.out.println("Enter Valid Number");
				}
			}
			while (true) {
				System.out.println("Enter Stream  Arts/Commerce/Science");
				String stream = br.readLine();
				if (stream.equalsIgnoreCase("arts")) {
					student_Bean.setStream(stream);
					PreparedStatement show = con.prepareStatement("select shelno,arts from books");
					ResultSet view = show.executeQuery();
					while (view.next()) {
						System.out.println(view.getInt(1) + "\t" + view.getString(2));
					}
					while (true) {
						System.out.println("Enter ShellNo To Select Book");
						int shelno = Integer.valueOf(br.readLine());
						PreparedStatement select = con
								.prepareStatement("select arts from books where shelno =" + shelno);
						ResultSet match = select.executeQuery();
						if (match.next()) {
							student_Bean.setNameOfBooks(match.getString(1));
							break;
						} else {
							System.out.println("Shell No Not Prersent In System!!!");
						}
					}
					break;
				} else if (stream.equalsIgnoreCase("science")) {
					student_Bean.setStream(stream);
					PreparedStatement show = con.prepareStatement("select shelno,science from books");
					ResultSet view = show.executeQuery();
					while (view.next()) {
						System.out.println(view.getInt(1) + "\t" + view.getString(2));
					}
					while (true) {
						System.out.println("Enter ShellNo To Select Book");
						int shelno = Integer.valueOf(br.readLine());
						PreparedStatement select = con
								.prepareStatement("select science from books where shelno =" + shelno);
						ResultSet match = select.executeQuery();
						if (match.next()) {
							student_Bean.setNameOfBooks(match.getString(1));
							break;
						} else {
							System.out.println("Shell No Not Prersent In System!!!");
						}
					}
					break;
				} else if (stream.equalsIgnoreCase("commerce")) {
					student_Bean.setStream(stream);
					PreparedStatement show = con.prepareStatement("select shelno,commerce from books");
					ResultSet view = show.executeQuery();
					while (view.next()) {
						System.out.println(view.getInt(1) + "\t" + view.getString(2));
					}
					while (true) {
						System.out.println("Enter ShellNo To Select Book");
						int shelno = Integer.valueOf(br.readLine());
						PreparedStatement select = con
								.prepareStatement("select commerce from books where shelno =" + shelno);
						ResultSet match = select.executeQuery();
						if (match.next()) {
							student_Bean.setNameOfBooks(match.getString(1));
							break;
						} else {
							System.out.println("Shell No Not Prersent In System!!!");
						}
					}
					break;
				} else {
					System.out.println("Invalid Entry!!!!");
				}
			}
			Calendar cal = Calendar.getInstance();
			student_Bean.setDateOfIssue(sdf.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_MONTH, 14);
			student_Bean.setDateOfReturn(sdf.format(cal.getTime()));
			PreparedStatement insert = con.prepareStatement(
					"insert into student(id,name,stream,phoneNumber,nameofBooks,dataOfIssue,dateOfReturn) values(?,?,?,?,?,?,?)");
			insert.setInt(1, student_Bean.getId());
			insert.setString(2, student_Bean.getName());
			insert.setString(3, student_Bean.getStream());
			insert.setString(4, student_Bean.getNumber());
			insert.setString(5, student_Bean.getNameOfBooks());
			insert.setString(6, student_Bean.getDateOfIssue());
			insert.setString(7, student_Bean.getDateOfReturn());
			int i = insert.executeUpdate();
			if (i > 0) {
				System.out.println("Successfull");
			} else {
				System.out.println("Something went Wrong!!!!");
			}

		} catch (NumberFormatException | IOException |

				SQLException e) {
			e.printStackTrace();
		}
	}

	public void student_Delete(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		while (true) {
			try {
				System.out.println("Enter Id To Delete ");
				int id = Integer.valueOf(br.readLine());
				PreparedStatement matchId = con.prepareStatement("select * from student where id=" + id);
				ResultSet mId = matchId.executeQuery();
				if (mId.next()) {
					PreparedStatement delete = con.prepareStatement("delete from student where id=" + id);
					delete.executeUpdate();
					System.out.println("Deleted Succesfully!!!!");
					break;
				} else {
					System.out.println("Enter Valid ID");
				}
			} catch (NumberFormatException | IOException |

					SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void student_Update(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface, SimpleDateFormat sdf) {
		while (true) {
			try {
				System.out.println("Enter Id To Update ");
				int id = Integer.valueOf(br.readLine());
				PreparedStatement matchId = con.prepareStatement("select * from student where id=" + id);
				ResultSet mId = matchId.executeQuery();
				if (mId.next()) {
					while (true) {
						System.out.println("Enter Stream  Arts/Commerce/Science");
						String stream = br.readLine();
						if (stream.equalsIgnoreCase("arts")) {
							student_Bean.setStream(stream);
							PreparedStatement show = con.prepareStatement("select shelno,arts from books");
							ResultSet view = show.executeQuery();
							while (view.next()) {
								System.out.println(view.getInt(1) + "\t" + view.getString(2));
							}
							while (true) {
								System.out.println("Enter ShellNo To Select Book");
								int shelno = Integer.valueOf(br.readLine());
								PreparedStatement select = con
										.prepareStatement("select arts from books where shelno =" + shelno);
								ResultSet match = select.executeQuery();
								if (match.next()) {
									student_Bean.setNameOfBooks(match.getString(1));
									break;
								} else {
									System.out.println("Shell No Not Prersent In System!!!");
								}
							}
							break;
						} else if (stream.equalsIgnoreCase("science")) {
							student_Bean.setStream(stream);
							PreparedStatement show = con.prepareStatement("select shelno,science from books");
							ResultSet view = show.executeQuery();
							while (view.next()) {
								System.out.println(view.getInt(1) + "\t" + view.getString(2));
							}
							while (true) {
								System.out.println("Enter ShellNo To Select Book");
								int shelno = Integer.valueOf(br.readLine());
								PreparedStatement select = con
										.prepareStatement("select science from books where shelno =" + shelno);
								ResultSet match = select.executeQuery();
								if (match.next()) {
									student_Bean.setNameOfBooks(match.getString(1));
									break;
								} else {
									System.out.println("Shell No Not Prersent In System!!!");
								}
							}
							break;
						} else if (stream.equalsIgnoreCase("commerce")) {
							student_Bean.setStream(stream);
							PreparedStatement show = con.prepareStatement("select shelno,commerce from books");
							ResultSet view = show.executeQuery();
							while (view.next()) {
								System.out.println(view.getInt(1) + "\t" + view.getString(2));
							}
							while (true) {
								System.out.println("Enter ShellNo To Select Book");
								int shelno = Integer.valueOf(br.readLine());
								PreparedStatement select = con
										.prepareStatement("select commerce from books where shelno =" + shelno);
								ResultSet match = select.executeQuery();
								if (match.next()) {
									student_Bean.setNameOfBooks(match.getString(1));
									break;
								} else {
									System.out.println("Shell No Not Prersent In System!!!");
								}
							}
							break;
						} else {
							System.out.println("Invalid Entry!!!!");
						}
					}
					Calendar cal = Calendar.getInstance();
					student_Bean.setDateOfIssue(sdf.format(cal.getTime()));
					cal.add(Calendar.DAY_OF_MONTH, 14);
					student_Bean.setDateOfReturn(sdf.format(cal.getTime()));
					PreparedStatement update = con.prepareStatement(
							"update student set nameofBooks=?,dataOfIssue=?,dateOfReturn=? where id=" + id);
					update.setString(1, student_Bean.getNameOfBooks());
					update.setString(2, student_Bean.getDateOfIssue());
					update.setString(3, student_Bean.getDateOfReturn());
					update.executeUpdate();
					System.out.println("Updated Succesfully!!!!");
					break;
				} else {
					System.out.println("Enter Valid ID");
				}
			} catch (NumberFormatException | IOException |

					SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void student_Show(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		while (true) {
			try {
				System.out.println("Enter Id To View ");
				int id = Integer.valueOf(br.readLine());
				PreparedStatement matchId = con.prepareStatement("select * from student where id=" + id);
				ResultSet mId = matchId.executeQuery();
				if (mId.next()) {
					System.out.println(
							mId.getInt(1) + "\t" + mId.getString(2) + "\t" + mId.getString(3) + "\t" + mId.getString(4)
									+ "\t" + mId.getString(5) + "\t" + mId.getString(6) + "\t" + mId.getString(7));
					break;
				} else {
					System.out.println("Enter Valid ID");
				}
			} catch (NumberFormatException | IOException |

					SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void student_Data(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface) {
		try {
			PreparedStatement matchId = con.prepareStatement("select * from student");
			ResultSet mId = matchId.executeQuery();
			while (mId.next()) {
				System.out.println(
						mId.getInt(1) + "\t" + mId.getString(2) + "\t" + mId.getString(3) + "\t" + mId.getString(4)
								+ "\t" + mId.getString(5) + "\t" + mId.getString(6) + "\t" + mId.getString(7));
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
