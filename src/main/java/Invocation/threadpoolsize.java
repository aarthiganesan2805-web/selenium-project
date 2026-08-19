package Invocation;

import org.testng.annotations.Test;

public class threadpoolsize {
	
	
	@Test(invocationCount = 6, threadPoolSize = 3)
	public void showThreadPoolsize() {
		
		System.out.println("Thread id: " + Thread.currentThread().getId());
		
	}

}
