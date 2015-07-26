package phonebook;
import java.util.*;

public class Test_PhoneBook {
	public static void main(String[] args) {
		PhoneBook p = new PhoneBook();
		p.put("Zebra", "085-z");
		p.put("Antony", "070-a");
		p.put("Boris", "071-b");
		p.put("Boris", "085-q");
		p.put("Antony", "072-a");
		p.put("Desiré", "085-q");
		p.put("Antony", "085-q");
		p.put("Antony", "070-a");
		p.put("Annelie", "082-t");
		p.put("Citron", "071-b");
		
		for(String s : p.names()) {
			System.out.println(s);
		}
		/*for(String s : p.findNumber("Antony")) {
			System.out.println(s);
		}*/
		
	}
}
