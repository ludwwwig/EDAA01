package phonebook;
import java.io.*;
import java.util.*;

public class PhoneBook{
	private Map<String,LinkedList<String>> phoneBook;
	
	public PhoneBook() {
		phoneBook = new HashMap<String,LinkedList<String>>();
	}
	
	/** 
	 * Associates the specified number with the specified 
	 * name in this phone book. 
	 * post: If the specified name is not present in this phone book,
	 *        the specified name is added and associated  with
	 *  	  the specified number. Otherwise the specified 
	 *  	  number is added to the set of number associated with name.
	 * @param name The name for which a phone number is to be added
	 * @param number The number associated with the specified name
	 * @return true if the specified name and number was inserted
	 */
	public boolean put(String name, String number) {
		LinkedList<String> nbrs = phoneBook.get(name);
		if(nbrs != null){
			if(nbrs.contains(number))
				return false;
			nbrs.add(number);
		} else {
			LinkedList<String> newList = new LinkedList<String>();
			newList.add(number);
			phoneBook.put(name, newList);
		}
		return true;
	}
	
	
	/**
	 * Removes the the specified name from this phone book.
	 * post: If the specified name is present in this phone book,
	 * 		 it is removed. Otherwise this phone book is
	 * 		 unchanged.
	 * @param name The name to be removed
	 * @return true if the specified name was present
	 */
	public boolean remove(String name) {
		LinkedList<String> removedList = phoneBook.remove(name);
		return removedList != null;
	}
	
	/**
	 * Retrieves a list of phone numbers for the specified name. If the 
	 * specified name is not present in this phone book an empty list is 
	 * returned.
	 * @param name The name whose associated phone numbers are to be returned  
	 * @return The phone numbers associated with the specified name
	 */
	public List<String> findNumber(String name) {
		LinkedList<String> result = phoneBook.get(name);
		if(result == null){
			return new LinkedList<String>();
		} else return result;
	}
	
	/**
	 * Retrieves a list of names associated with the specified phone number. 
	 * If the specified number is not present in this phone book an empty 
	 * list is returned.
	 * @param number The number for which the set of associated
	 * names is to be returned.
	 * @return The list of names associated with the specified number
	 */
	public List<String> findNames(String number) {
		Set<Map.Entry<String, LinkedList<String>>> pbSet = phoneBook.entrySet();
		LinkedList<String> listOfNames = new LinkedList<String>();
		for(Map.Entry entry : pbSet){
			LinkedList<String> currentNbrs = (LinkedList<String>) entry.getValue();
			for(String nbr : currentNbrs) {
				if(nbr.equals(number)){
					listOfNames.add((String) entry.getKey());
					break; //ett namn kan bara ha ett nummer en gång
				}
			}
		}
		return listOfNames;
	}
	
	/**
	 * Retrieves the set of all names present in this phone book.
	 * The set's iterator will return the names in ascending order
	 * @return The set of all names present in this phone book
	 */
	public Set<String> names() {
		TreeSet<String> result = new TreeSet<String>();
		for(String name : phoneBook.keySet()) {
			result.add(name);
		}
		return result;
	}
	
	/**
	 * Returns true if this phone book is empty
	 * @return true if this phone book is empty
	 */	
	public boolean isEmpty() {
		return phoneBook.isEmpty();
	}
	
	/**
	 * Returns the number of names in this phone book
	 * @return The number of names in this phone book
	 */
	public int size() {
		return phoneBook.size();
	}
	
	/**
	 * The 
	 */
	public void writeData(String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void readData(String fileName) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			phoneBook = (Map<String,LinkedList<String>>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}