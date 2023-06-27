package student_ResutSystem_Jbdc;

import java.io.BufferedReader;
import java.util.LinkedHashSet;

public interface Student_Interface {
	void insert(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls);

	void show(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls);

	void update(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls);

	void delete(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls);

	void exit(Student_Interface si, Student_Bean sb, BufferedReader br, LinkedHashSet ls);
}
