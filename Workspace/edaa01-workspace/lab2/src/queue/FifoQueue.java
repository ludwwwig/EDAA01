package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {

	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
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
		QueueNode<E> newElement = new QueueNode<E>(x);
		if(last != null) {
			newElement.next = last.next;
			last.next = newElement;
		} else
			newElement.next = newElement;
		last = newElement;
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
		if(last != null) {
			E result = last.next.element;
			if(size > 1)
				last.next = last.next.next;
			else
				last = null;
			size--;
			return result;
		}
		return null;
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last != null)
			return last.next.element;
		return null;
	}

    /**
     * Appends the specified queue to this queue
     * post: all elements from the specified queue are appended
     *       to this queue. The specified queue (q) is empty
     * @param q the queue to append
     */
    public void append(FifoQueue<E> q){
    	if(size != 0 && q.size != 0) {
    		QueueNode<E> currentFirst = last.next;
    		last.next = q.last.next;
    		last = q.last;
    		last.next = currentFirst;
		}
		else if (size == 0 && q.size != 0) {
    		last = q.last;
    	}
    	size += q.size;
    	q.last = null;
    	q.size = 0;
    }

	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int itrSize = size;
		
		private QueueIterator() {
			if(last != null)
				pos = last.next;
			else
				pos = null;
		}
		
		public boolean hasNext() {
			return itrSize > 0;
		}
		
		public E next() {
			if(hasNext()) {
				itrSize--;
				E currentElement = pos.element;
				pos = pos.next;
				return currentElement;
			}
			throw new NoSuchElementException();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
