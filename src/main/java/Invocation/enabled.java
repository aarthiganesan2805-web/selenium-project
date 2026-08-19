package Invocation;

import org.testng.annotations.Test;

public class enabled {

	
	@Test(enabled = false)
	public void checkEnabled() {
		
		System.out.println("Enabled");
		
	}
	@Test(enabled  = true)
   public void checkDisabled() {
	   
	   System.out.println("Not Enabled");
	   
   }
	
}
