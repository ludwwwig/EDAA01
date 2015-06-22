package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		this.size = 0;
		this.last = null;
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new MyQueueIterator();
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		QueueNode<E> node = new QueueNode<E>(x);
		if (last == null) {
			last = node;
			last.next = last;
		} else {
			node.next = last.next;
			last.next = node;
			last = node;
		}
		size++;
		return true;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (last == null)
			return null;
		else if (last.next == last) { //ett element
			E a = last.element;
			last = null;
			size--;
			return a;
		} else {
			E a = last.next.element;
			last.next = last.next.next;
			size--;
			return a;
		}
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (last == null)
			return null;
		return last.next.element;
	}
	
	/**
     * Appends the specified queue to this queue
     * post: all elements from the specified queue are appended
     *       to this queue. The specified queue (q) is empty
     * @param q the queue to append
     */
	public void append(FifoQueue<E> q) {
		if (q.last == null && last == null)
			return;
		else if (q.last == null)
			return;
		else if (last == null) {
			last = q.last;
			size = q.size();
			return;
		} else {
			QueueNode<E> first = last.next;
			last.next = q.last.next;
			q.last.next = first;
			last = q.last;
			size += q.size();
			return;
		}
		
	}


	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}
	private class MyQueueIterator implements Iterator<E> {
		int sizeCopy = size;
		private QueueNode<E> pos;
		
		private MyQueueIterator() {
			pos = last.next;
			
		}
		public boolean hasNext() {
			return sizeCopy > 0;
		}
		public E next() {
			if (hasNext()) {
				E a = pos.element;
				pos = pos.next;
				sizeCopy--;
				return a;
			}
			throw new NoSuchElementException();
		}
		public void remove() {
            throw new UnsupportedOperationException();
		}
	}

}
