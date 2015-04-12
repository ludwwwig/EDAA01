package sandbox;

public class Test {

	public static void main(String[] args) {
		move(4,1,3,2);
		System.out.println(fib(10));
		System.out.println(fib(9));
	}

	public static void move(int n, int start, int dest, int temp) {
		   if (n == 1) {
		      System.out.println("Move from " + start + " to " + dest);
		   } else {
		      move(n - 1, start, temp, dest); //kommer skifta hela tiden
		      System.out.println("Move from " + start + " to " + dest); //flytta sista klossen
		      move(n - 1, temp, dest, start);
		   } 
	}
	
	
	public static long fib(int n) {
		long[] table = new long[n+1]; // skapa en tabell
		for (int i = 0; i <= n; i++) {
			table[i] = -1; // negativt värde <=> ej beräknat
		}
		   return recfib(table, n);
	}
	
	private static long recfib(long[] table, int n) {
	   if (table[n] < 0 ) {
	      if (n <= 1) {
	         table[n] = n;
	      } else {
	    	  table[n] = recfib(table, n-1) + recfib(table, n-2);
	      }
	   }
	   return table[n];
	}
}
