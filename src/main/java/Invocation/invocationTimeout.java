package Invocation;

import org.testng.annotations.Test;

public class invocationTimeout {

	
	@Test(invocationTimeOut = 3000)
	public void invocationTimeTest() throws InterruptedException {
		
		System.out.println("Aarthi");
		
		Thread.sleep(3000);
	}
	
}
