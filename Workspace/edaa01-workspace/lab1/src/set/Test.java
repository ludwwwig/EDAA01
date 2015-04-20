package set;

public class Test {

	public static void main(String[] args) {
		Integer[] ints = {1,2,3,3,3999,3,4,5,56,6,7,7,7};
		@SuppressWarnings("rawtypes")
		Comparable[] result = uniqueElements(ints);
		for(int i = 0; i < result.length; ++i)
			System.out.println(result[i]);
	}

	public static <E extends Comparable<E>> E[] uniqueElements(E[] array)
	{
		MaxSet<E> a = new MaxSet<E>(); 
		@SuppressWarnings("unchecked")
		E[] result = (E[]) new Comparable[a.size()];
		for(int i = 0; i < array.length; ++i)
			a.add(array[i]);
		for(int i = a.size()-1; i >= 0; --i)
			a.remove(result[i] = a.getMax());
		return result;
	}
}