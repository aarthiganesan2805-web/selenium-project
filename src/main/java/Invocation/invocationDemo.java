package Invocation;

import org.testng.annotations.Test;

public class invocationDemo {
	
	
@Test(invocationCount=5)
	public void invocationTest() {
		System.out.println("Aarthi");
	}
	
}
