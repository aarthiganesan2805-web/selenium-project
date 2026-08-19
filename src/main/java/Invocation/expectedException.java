package Invocation;

import org.testng.annotations.Test;

public class expectedException {
	
	public class exception {
		
		@Test(expectedExceptions = ArithmeticException.class)
		public void divideByZeroTest() {
		int a = 10 / 0; // This throws ArithmeticException
		System.out.println(a);
		}
		}


}
