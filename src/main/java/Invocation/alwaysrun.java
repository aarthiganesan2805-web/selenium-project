package Invocation;


import org.testng.Assert;
import org.testng.annotations.Test;

public class alwaysrun {
	
	public void error() {
		System.out.println("Failed");
		
		Assert.fail();
	}
	
	@Test(alwaysRun = true)
	public void checkAlwaysRun() {
		System.out.println("Running...");
	}

}
