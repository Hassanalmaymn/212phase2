package phoneBookApplication;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Event x1 = new Event("hassan", "2023/03/5", 12.5, 13.5, "ryadh");
		Event x2 = new Event("hassan", "2023/03/5", 12.5, 13.5, "ryadh");
		Event x3 = new Event("hassan", "2023/03/5", 12.5, 13.5, "ryadh");
		Event x4 = new Event("hassan", "2023/03/5", 13.5, 14.5, "ryadh");
		Event x5 = new Event("hassan", "2023/03/5", 12.5, 13.5, "ryadh");
		LinkedListOfEvents l1 = new LinkedListOfEvents();
		l1.insert(x1);
		l1.insert(x2);
		l1.insert(x3);
		l1.insert(x5);
		System.out.println(l1.serchByTime(x4));

	}

}
