package map;

public class SimpleHashMap<K,V> implements Map<K, V> {
	private Entry<K,V>[] table;
	private int capacity;
	private double load;
	private int size;
	
	/** Constructs an empty hashmap with the default initial capacity (16)
    and the default load factor (0.75). */
	@SuppressWarnings("unchecked")
	public SimpleHashMap() {
		capacity = 16;
		table = (Entry<K,V>[]) new Entry[capacity];
		load = 0.75;
	}
	
	/** Constructs an empty hashmap with the specified initial capacity
     and the default load factor (0.75). */
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		this.capacity = capacity;
		table = (Entry<K,V>[]) new Entry[capacity];
		load = 0.75;
	}
	
	/** 
	 * Returns a string of every element in the hashmap table. Entries with 
	 * the same index are put on the same row. 
	 */
	public String show() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(Entry<K,V> entry : table) {
			sb.append(count++);
			sb.append("   ");
			sb.append(show(entry));
			sb.append('\n');
		}
		return sb.toString();
	}
	
	private StringBuilder show(Entry<K,V> e) {
		StringBuilder sb = new StringBuilder();
		if(e != null) {
			sb.append(e.toString());
			sb.append(" ");
			sb.append(show(e.getNext()));
		}
		return sb;
	}
	
	@Override
	public V get(Object key) {
		@SuppressWarnings("unchecked")
		K k = (K) key;
		Entry<K,V> result = find(index(k), k);
		return result == null ? null : result.value;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public V put(K key, V value) {
		if(((size+1) / (double) capacity) > load)
			rehash();
		
		int index = index(key);
		Entry<K,V> entry = find(index, key);
		if(entry != null) {
			V oldVal = entry.value;
			entry.value = value;
			return oldVal;
		} else {
			if(table[index] != null)
				table[index].addTail(new Entry(key, value));
			else
				table[index] = new Entry(key, value);
			size++;
			return null;
		}
	}

	@Override
	public V remove(Object key) {
		@SuppressWarnings("unchecked")
		K k = (K) key;
		int index = index(k);
		Entry<K,V> entry = find(index, k);
		if(entry != null) {
			if(entry.getNext() != null) {
				entry.getNext().setNext(table[index]);
				table[index] = entry.getNext();
			}
			V result = entry.value;
			System.out.println(result);
			entry = null;
			size--;
			return result;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % capacity);
	}
	
	private Entry<K,V> find(int index, K key) {
		Entry<K,V> e = table[index];
		while(e != null) {
			if(e.key.equals(key)) 
				return e;
			e = e.getNext();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void rehash() {
		Entry<K,V>[] oldTable = table;
		table = (Entry<K,V>[]) new Entry[capacity *= 2];
		for (int i = 0; i < oldTable.length; ++i) {
			Entry<K,V> e = oldTable[i];
			while (e != null) {
				put(e.getKey(), e.getValue());
				size--;
				e = e.getNext();
			}
		}

	}
	
//	private void rehash() {
//		Entry<K,V>[] oldTable = table;
//		capacity *= 2;
//		table = (Entry<K,V>[]) new Entry[capacity];
//		for(Entry<K,V> entry : oldTable) {
//			if(entry != null)
//				rehashEntry(entry);
//		}
//	}
//	
//	private void rehashEntry(Entry<K,V> e) {
//		int index = index(e.key);
//		if(table[index] == null) 
//			table[index] = e;
//		else 
//			table[index].addTail(e);
//		if(e.getNext() != null) 
//			rehashEntry(e.getNext());
//	}
	
	
	private static class Entry<K,V> implements Map.Entry<K,V> {
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
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
			V oldVal = this.value;
			this.value = value;
			return oldVal;
		}
		
		public Entry<K,V> getNext() {
			return next;
		}
		
		public void setNext(Entry<K,V> entry) {
			if(!this.equals(entry))
				next = entry;
		}
		
		public void addTail(Entry<K,V> entry) {
			if(next == null) 
				setNext(entry);
			else 
				next.addTail(entry);
		}
		
		@Override
		public String toString() {
			return key.toString() + "=" + value.toString();
		}
	}
	
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> map = new SimpleHashMap<Integer, Integer>(10);
		for(int i = -17; i < 5; i++) {
			map.put(i, i);
		}
		System.out.println(map.show());
	}
}
