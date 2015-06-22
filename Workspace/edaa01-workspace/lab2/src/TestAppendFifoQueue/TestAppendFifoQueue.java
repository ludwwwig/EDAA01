package TestAppendFifoQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<Integer> yourIntQueue;
	
	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
		yourIntQueue = new FifoQueue<Integer>();
	}
	
	@Test
	public void appendToEmpty() {
		System.out.println("appendToEmpty starting.");

		yourIntQueue.offer(1);
		yourIntQueue.offer(2);
		yourIntQueue.offer(3);
		
		myIntQueue.append(yourIntQueue);
		for(Integer i : myIntQueue)
			System.out.println(i);
		System.out.println("appendToEmpty done.");
	}
	
	@Test
	public void appendEmpty() {
		System.out.println("appendEmpty starting.");

		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		myIntQueue.append(yourIntQueue);
		for(Integer i : myIntQueue)
			System.out.println(i);
		System.out.println("appendEmpty done.");
	}
	
	@Test
	public void appendBothNotEmpty() {
		System.out.println("appendBotNotEmpty starting.");

		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);

		yourIntQueue.offer(7);
		yourIntQueue.offer(8);
		yourIntQueue.offer(10);
		
		myIntQueue.append(yourIntQueue);

		for(Integer i : myIntQueue)
			System.out.println(i);
		assertTrue(myIntQueue.size() == 6);
		System.out.println("appendBothNotEmpty done.");
		
	}
	
	@Test
	public void appendBothEmpty() {
		System.out.println("appendBothEmpty starting.");
		myIntQueue.append(yourIntQueue);
		System.out.println(myIntQueue.size());
		assertTrue(myIntQueue.size() == 0);
		System.out.println("appendBothEmpty done.");
		
	}

}
