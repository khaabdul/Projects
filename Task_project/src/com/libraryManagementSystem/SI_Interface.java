package com.libraryManagementSystem;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;

public interface SI_Interface {

	void librarian_Insert(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void librarian_show(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void librarian_delete(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void librarian_update(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void exit(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean, SI_Interface si_interface);

	void student_Insert(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface,SimpleDateFormat sdf);

	void student_Delete(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void student_Update(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface,SimpleDateFormat sdf);

	void student_Show(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

	void student_Data(BufferedReader br, Student_Bean student_Bean, Libraray_Bean libraray_Bean,
			SI_Interface si_interface);

}
