package phoneBookApplication;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String x = "hassan almaymn";
		String y = "ahmed bahbry";
		String e = "yasir mohammed";
		String[] Xsplited = x.split("");
		String[] ysplited = y.split("");
		int z = 0, j = 0, m = 0;
		for (int i = 0; i < ysplited.length; i++) {
			z += (int) x.charAt(i);
			j += (int) y.charAt(i);
			m += (int) e.charAt(i);

		}
		System.out.println(z + " " + j + " " + m);
		
		
		System.out.println(y.compareToIgnoreCase(x));

	}

}
