package testqueue;

import static org.junit.Assert.*;
import org.junit.Test;
import queue.FifoQueue;

public class TestAppendFifoQueue {
	@Test
	public void testAppend() {
		FifoQueue<Integer> queue1 = new FifoQueue<Integer>();
		FifoQueue<Integer> queue2 = new FifoQueue<Integer>();
		queue1.append(queue2);
		assertEquals("Queue not empty after appending two empty queues", 0, queue1.size());
		queue2.offer(2);
		queue1.append(queue2);
		assertEquals("Wrong size of queue after appending non-empty queue to empty queue", 1, queue1.size());
		assertEquals("Does not contain the element appended to an empty queue", (Integer) 2, queue1.poll());
		queue1.offer(3);
		queue1.append(queue2);
		assertEquals("Wrong size of queue after appending empty queue to non-empty queue", 1, queue1.size());
		assertEquals("Does not contain the element appended to non-empty queue", (Integer) 3, queue1.poll());
		queue1.offer(1);
		queue2.offer(5);
		queue1.append(queue2);
		assertEquals("Wrong size of queue after appending empty queue to non-empty queue", 2, queue1.size());
		assertEquals("Does not yield the expected element for first poll after append", (Integer) 1, queue1.poll());
		assertEquals("Does not yield the expected element for second poll after append", (Integer) 5, queue1.poll());
		
	}
}