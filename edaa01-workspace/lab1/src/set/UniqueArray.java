package set;

import java.util.Iterator;

public class UniqueArray {
	public static int[] uniqueElements(int[] ints){
		MaxSet<Integer> set = new MaxSet<Integer>();
		for(Integer nbr : ints) {
			set.add(nbr);
		}
		int[] result = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		for(int i = 0; i < result.length; i++) {
			result[i] = iterator.next();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] intArray = new int[] {1,3,7,3,3,3,1,2,3,7};
		int[] uniqueArray = uniqueElements(intArray);
		for(int nbr : uniqueArray) {
			System.out.println(nbr);
		}
	}

}
