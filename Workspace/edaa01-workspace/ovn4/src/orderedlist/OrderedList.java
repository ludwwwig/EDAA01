package orderedlist;
import java.util.*;

public class OrderedList<E extends Comparable<E>> implements Iterable<E> { 
	private LinkedList<E> theList; 
	
	public OrderedList() { 
		theList = new LinkedList<E>(); 
	} 
	
	public void add(E x) { 
		ListIterator<E> itr = theList.listIterator(); 
		while (itr.hasNext()) { 
			if (x.compareTo(itr.next()) < 0) { 
				itr.previous(); 
				itr.add(x); 
				return; 
			} 
		} 
		itr.add(x); 
	} 
	
	public E get(int index) { 
		return theList.get(index); 
	} 
	
	public Iterator<E> iterator() { 
		return theList.iterator(); 
	}
	
	public int size() {
		return theList.size();
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present. If this list does not contain the element, it is
	 * unchanged. Returns true if this list contained the specified element (or
	 * equivalently, if this list changed as a result of the call).
	 */
	boolean remove(E obj) {
		//Fyll i egen kod
		return false;
	}	

	public static void main(String args[]) {
		OrderedList<Integer> list = new OrderedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);	
		list.add(4);
		list.add(5);
		
		list.remove(1);
		list.remove(3);
		list.remove(5);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
} 

