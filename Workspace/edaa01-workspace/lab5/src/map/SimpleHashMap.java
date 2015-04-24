package map;

import java.util.*;

import javax.xml.crypto.Data;


public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K,V>[] table;
	private int capacity;
	
	/** Constructs an empty hashmap with the default initial capacity (16)
    and the default load factor (0.75). */
	@SuppressWarnings("unchecked")
	public SimpleHashMap() {
		table = (Entry<K,V>[]) new Entry[this.capacity = 16];
	}
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		table = (Entry<K,V>[]) new Entry[this.capacity = capacity];
	}
	@Override
	public V get(Object arg0) {
		K key = (K) arg0;
		Entry<K,V> a;
		for (int i = 0; i < table.length; ++i) {
			if ((a =find(i,key)) == null) continue;
			else return a.getValue();
		}
			
		return null;
	}

	@Override
	public boolean isEmpty() {
		System.out.println(size());
		return size() == 0;
	}

	@Override
	public V put(K key, V value) {
		if (size() / (float)capacity > 0.75) {
			rehash();
		}
		int index = index(key);
		Entry<K,V> a = table[index];
		if (a == null) {
			table[index] = new Entry<K,V>(key,value);
			return null;
		}
		while (a != null) {
			if (a.getKey() == (key))
				return a.setValue(value);
			if (a.next == null) break;
			a = a.next;
		}
		a.next = new Entry<K,V>(key,value);
		return null;
	}
	private void rehash() {
		System.out.println("rehashiiing");
		Entry<K,V>[] oldTable = table;
		table = (Entry<K,V>[]) new Entry[capacity *= 2];
		for (int i = 0; i < oldTable.length; ++i) {
			Entry<K,V> a = oldTable[i];
			while (a != null) {
				put(a.getKey(), a.getValue());
				a = a.next;
			}
		}

	}
	@Override
	public V remove(Object arg0) {
		
		K key = (K) arg0;
		int index = index(key);
		if (table[index] == null) return null;
		System.out.println("Im here");
		Entry<K, V> a = table[index];
		
		Entry<K,V> copy;
		if (a.getKey().equals(key)) {
			copy = a;
			table[index] = a.next;
			return copy.getValue();
		}
		while (a.next != null) {
			if (a.next.getKey().equals(key)) {
				copy = a.next;
				a = a.next.next;
				return copy.getValue();
			}
			a = a.next;
		}
		return null;
		
	}

	@Override
	public int size() {
		int elements = 0;
		Entry<K,V> a;
		for (int i = 0; i < table.length; ++i) {
			a = table[i];
			while(a != null) {
				elements++;
				a = a.next;
			}
		}
		return elements;
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		Entry<K,V> a;
		for (int i = 0; i < table.length; ++i) {
			a = table[i];
			sb.append(i + " ");
			while(a != null) {
				sb.append(a.toString());
				a = a.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private int index(K key) {
		//System.out.println(key.hashCode());
		int index = key.hashCode() % capacity;
		return index > 0 ? index : -1*index;
	}
	
    private Entry<K,V> find(int index, K key) {
    	Entry<K,V> a = table[index];
    	while (a != null) {
    		if (a.getKey().equals(key))
    			return a;
    		a = a.next;
    	}
    	return null;
    }
	public static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V previous = this.value;
			this.value = value;
			return previous;
		}
		public String toString() {
			return "" + key + " = " + value;
		}

	}
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> a = new SimpleHashMap<Integer, Integer>();
		for(int key = 1; key < 63; key++) {
			a.put(key, key*3);
		}
		for(int key = 1; key < 63; key++) {
			a.remove(key);
		}

		System.out.println(a.show());
	}
}
