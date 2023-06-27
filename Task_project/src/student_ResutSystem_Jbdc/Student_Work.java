package student_ResutSystem_Jbdc;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//import com.mysql.cj.xdevapi.Statement;

import jdbcconection.Connectionjdbc;

public class Student_Work implements Student_Interface {
	int seatno, accountancy, economics, english, mathematics, ocm, it, total;
	float percentage;
	String name, remark;
	Connection con = Connectionjdbc.connection();

	public void insert(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls) {
		try {
			System.out.println("Enter Seat No");
			seatno = Integer.parseInt(br.readLine());
			sb.setSeatNo(seatno);
			System.out.println("Enter Name ");
			name = br.readLine();
			sb.setName(name);
			while (true) {
				System.out.println("Enter Accountancy Marks");
				accountancy = Integer.parseInt(br.readLine());
				if (accountancy <= 100 && accountancy >= 0) {
					sb.setAccountancy(accountancy);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			while (true) {
				System.out.println("Enter Economics Marks");
				economics = Integer.parseInt(br.readLine());
				if (economics <= 100 && economics >= 0) {
					sb.setEconomics(economics);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			while (true) {
				System.out.println("Enter EnGlisH Marks");
				english = Integer.parseInt(br.readLine());
				if (english <= 100 && english >= 0) {
					sb.setEnglish(english);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			while (true) {
				System.out.println("Enter Mathematics Marks");
				mathematics = Integer.parseInt(br.readLine());
				if (mathematics <= 100 && mathematics >= 0) {
					sb.setMathematics(mathematics);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			while (true) {
				System.out.println("Enter OCM Marks");
				ocm = Integer.parseInt(br.readLine());
				if (ocm <= 100 && ocm >= 0) {
					sb.setOcm(ocm);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			while (true) {
				System.out.println("Enter IT Marks");
				it = Integer.parseInt(br.readLine());
				if (it <= 100 && it >= 0) {
					sb.setIt(it);
					break;
				} else {
					System.out.println("Marks Cannot Be More THan 100.... Try AGain");
				}
			}
			total = sb.getAccountancy() + sb.getEconomics() + sb.getEnglish() + sb.getMathematics() + sb.getOcm()
					+ sb.getIt();
			sb.setTotal(total);
			percentage = (total * 100) / 600;
			sb.setPercentage(percentage);
			if (sb.getAccountancy() >= 35 && sb.getEconomics() >= 35 && sb.getEnglish() >= 35
					&& sb.getMathematics() >= 35 && sb.getOcm() >= 35 && sb.getIt() >= 35) {
				sb.setRemark("PASS");
			} else {
				sb.setRemark("FAIL");
			}
			PreparedStatement ps = con.prepareStatement(
					"insert into result(seatno,name,accountancy,economics,english,mathematics,ocm,it,total,percentage,remark) values (?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, sb.getSeatNo());
			ps.setString(2, sb.getName());
			ps.setInt(3, sb.getAccountancy());
			ps.setInt(4, sb.getEconomics());
			ps.setInt(5, sb.getEnglish());
			ps.setInt(6, sb.getMathematics());
			ps.setInt(7, sb.getOcm());
			ps.setInt(8, sb.getIt());
			ps.setInt(9, sb.getTotal());
			ps.setFloat(10, sb.getPercentage());
			ps.setString(11, sb.getRemark());
			ps.execute();
		} catch (SQLException | NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public void show(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls) {
		try {
			System.out.println("1.All DATA/2.INDIVIDUL DATA");
			int in = Integer.parseInt(br.readLine());
			if (in == 1) {
				PreparedStatement ps = con.prepareStatement("select * from result");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
							+ "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t" + rs.getInt(7) + "\t" + rs.getInt(8)
							+ "\t" + rs.getInt(9) + "\t" + rs.getFloat(10) + "\t" + rs.getString(11));
				}
			} else if (in == 2) {
				System.out.println("Enter Seat NO");
				int seat = Integer.valueOf(br.readLine());
				PreparedStatement ps = con.prepareStatement("select * from result where seatno=" + seat);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("Seat No = " + rs.getInt(1) + "\t" + "Name  = " + rs.getString(2));
					System.out.println("Accountancy = \t" + rs.getInt(3));
					System.out.println("Economics   = \t" + rs.getInt(4));
					System.out.println("English     = \t" + rs.getInt(5));
					System.out.println("Mathematics = \t" + rs.getInt(6));
					System.out.println("OCM         = \t" + rs.getInt(7));
					System.out.println("IT          = \t" + rs.getInt(8));
					System.out.println("Total       = \t" + rs.getInt(9));
					System.out.println(" Percentage = \t" + rs.getFloat(10) + "\t Remark = \t" + rs.getString(11));
					if (rs.getString(11).equalsIgnoreCase("pass")) {
						System.out.println("Congratulations You Are Pass!!!!!!");
					} else {
						System.out.println("Sorry You Are Failed !!!! Better Luck Next Time");
					}
					String file_Name = "E:\\PdfOfMarkssheet\\" + rs.getString(2) + "Marksheet.pdf";
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream(file_Name));
					document.open();
					Paragraph par = new Paragraph("Seat No = " + rs.getInt(1) + "\t" + "Name = " + rs.getString(2)
							+ "\n" + "Accountancy = \t" + rs.getInt(3) + "\n" + "Economics   = \t" + rs.getInt(4) + "\n"
							+ "English     = \t" + rs.getInt(5) + "\n" + "English     = \t" + rs.getInt(6) + "\n"
							+ "English     = \t" + rs.getInt(7) + "\n" + "English     = \t" + rs.getInt(8) + "\n"
							+ "English     = \t" + rs.getInt(9) + "\n" + " Percentage = \t" + rs.getFloat(10)
							+ "\t Remark = \t" + rs.getString(11));
					document.add(par);
					document.close();
					System.out.println("Pdf Downloaded Succesfully");
				}

			} else {
				System.out.println("Enter Proper Option ");
			}
		} catch (SQLException | NumberFormatException | IOException | DocumentException e) {
			e.printStackTrace();
		}

	}

	public void update(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls) {
		System.out.println("Enter Seat No");
		try {
			int seat = Integer.valueOf(br.readLine());
			sb.setSeatNo(seat);
			while (true) {
				System.out.println("1.accountancy/2.economics/3.english/4.mathematics/5.ocm/6.it");
				int in = Integer.valueOf(br.readLine());
				if (in == 1) {
					while (true) {
						System.out.println("Enter Accountancy Marks");
						accountancy = Integer.parseInt(br.readLine());
						if (accountancy <= 100 && accountancy >= 0) {
							sb.setAccountancy(accountancy);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(4) + rs.getInt(5) + rs.getInt(6) + rs.getInt(7) + rs.getInt(8)
								+ sb.getAccountancy();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(4) >= 35 && rs.getInt(5) >= 35 && rs.getInt(6) >= 35 && rs.getInt(7) >= 35
								&& rs.getInt(8) >= 35 && sb.getAccountancy() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,accountancy=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getAccountancy());
						ps1.executeUpdate();
					}

				} else if (in == 2) {
					while (true) {
						System.out.println("Enter Economics Marks");
						economics = Integer.parseInt(br.readLine());
						if (economics <= 100 && economics >= 0) {
							sb.setEconomics(economics);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(3) + rs.getInt(5) + rs.getInt(6) + rs.getInt(7) + rs.getInt(8)
								+ sb.getEconomics();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(3) >= 35 && rs.getInt(5) >= 35 && rs.getInt(6) >= 35 && rs.getInt(7) >= 35
								&& rs.getInt(8) >= 35 && sb.getEconomics() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,economics=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getEconomics());
						ps1.executeUpdate();
					}
				} else if (in == 3) {
					while (true) {
						System.out.println("Enter EnGlisH Marks");
						english = Integer.parseInt(br.readLine());
						if (english <= 100 && english >= 0) {
							sb.setEnglish(english);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(3) + rs.getInt(4) + rs.getInt(6) + rs.getInt(7) + rs.getInt(8)
								+ sb.getEnglish();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(3) >= 35 && rs.getInt(4) >= 35 && rs.getInt(6) >= 35 && rs.getInt(7) >= 35
								&& rs.getInt(8) >= 35 && sb.getEnglish() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,english=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getEnglish());
						ps1.executeUpdate();

					}

				} else if (in == 4) {
					while (true) {
						System.out.println("Enter Mathematics Marks");
						mathematics = Integer.parseInt(br.readLine());
						if (mathematics <= 100 && mathematics >= 0) {
							sb.setMathematics(mathematics);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(3) + rs.getInt(4) + rs.getInt(5) + rs.getInt(7) + rs.getInt(8)
								+ sb.getMathematics();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(3) >= 35 && rs.getInt(4) >= 35 && rs.getInt(5) >= 35 && rs.getInt(7) >= 35
								&& rs.getInt(8) >= 35 && sb.getMathematics() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,mathematics=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getMathematics());
						ps1.executeUpdate();

					}

				} else if (in == 5) {
					while (true) {
						System.out.println("Enter OCM Marks");
						ocm = Integer.parseInt(br.readLine());
						if (ocm <= 100 && ocm >= 0) {
							sb.setOcm(ocm);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(3) + rs.getInt(4) + rs.getInt(5) + rs.getInt(6) + rs.getInt(8) + sb.getOcm();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(3) >= 35 && rs.getInt(4) >= 35 && rs.getInt(5) >= 35 && rs.getInt(6) >= 35
								&& rs.getInt(8) >= 35 && sb.getOcm() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,ocm=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getOcm());
						ps1.executeUpdate();

					}

				} else if (in == 6) {
					while (true) {
						System.out.println("Enter IT Marks");
						it = Integer.parseInt(br.readLine());
						if (it <= 100 && it >= 0) {
							sb.setIt(it);
							break;
						} else {
							System.out.println("Marks Cannot Be More THan 100.... Try AGain");
						}
					}
					PreparedStatement st = con.prepareStatement("select * from result where seatno =" + seat);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						total = rs.getInt(3) + rs.getInt(4) + rs.getInt(5) + rs.getInt(6) + rs.getInt(7) + sb.getIt();
						sb.setTotal(total);

						percentage = (total * 100) / 600;
						sb.setPercentage(percentage);

						if (rs.getInt(3) >= 35 && rs.getInt(4) >= 35 && rs.getInt(5) >= 35 && rs.getInt(6) >= 35
								&& rs.getInt(7) >= 35 && sb.getIt() >= 35) {
							sb.setRemark("PASS");
						} else {
							sb.setRemark("FAIL");
						}
						PreparedStatement ps1 = con.prepareStatement(
								"update result set total=?,percentage=?,remark=?,it=? where seatno =" + seat);
						ps1.setInt(1, sb.getTotal());
						ps1.setFloat(2, sb.getPercentage());
						ps1.setString(3, sb.getRemark());
						ps1.setInt(4, sb.getIt());
						ps1.executeUpdate();

					}
				} else {
					System.out.println("Enter Proper Option ");
				}
				System.out.println("DO YOU WANT TO DO MORE CHANEGS");
				String input = br.readLine();
				if (input.equalsIgnoreCase("n")) {
					break;
				}

			}
		} catch (NumberFormatException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls) {
		try {
			System.out.println("Enter Seat No");
			int seat = Integer.parseInt(br.readLine());
			PreparedStatement ps = con.prepareStatement("delete from result where seatno = ?");
			ps.setInt(1, seat);
			ps.executeUpdate();
		} catch (SQLException | NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public void exit(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
