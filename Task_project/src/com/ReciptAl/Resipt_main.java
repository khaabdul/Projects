package com.ReciptAl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Resipt_main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		work wc = new Workclass();
		Bean bean = new Bean();
		//ArrayList list = new ArrayList();
		LinkedList<Bean> list=new LinkedList<Bean>();

		System.out.println("  * TACHSKILL IT SOLUTION *");
		System.out.println("    ------FEE RESIPT ------");
		System.out.println();
		System.out.println("Create New Resipt");
		wc.insert(sc, wc, bean, list);
		while (true) {
			System.out.println("1.insert/2.delete/3.update/4.generateRecipt/5.exit");
			int input = sc.nextInt();
			if (input == 1) {
				wc.insert(sc, wc, bean, list);
			} else if (input == 2) {
				wc.delete(sc, wc, bean, list);
			} else if (input == 3) {
				wc.Update(sc, wc, bean, list);
			} else if (input == 4) {
				wc.genrate_resipt(sc, wc, bean, list);
			} else if (input == 5) {
				break;
			}
		}

	}
}