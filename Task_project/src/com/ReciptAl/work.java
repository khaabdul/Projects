package com.ReciptAl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public interface work {

	void insert(Scanner sc, work wc,Bean bean,LinkedList<Bean> list);

	void Update(Scanner sc, work wc, Bean bean, LinkedList<Bean> list);

	void genrate_resipt(Scanner sc, work wc, Bean bean, LinkedList<Bean> list);

	void delete(Scanner sc, work wc, Bean bean, LinkedList<Bean> list);
}
