package test;
import map.*;

public class Test {

	public static void main(String[] args) {
		Map<Integer, Integer> a = new SimpleHashMap<Integer, Integer>();
		System.out.println(a.put(1,1));
		System.out.println(a.put(1,2));
		System.out.println(a.size());
		
	}

}