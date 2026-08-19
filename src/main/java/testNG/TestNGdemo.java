package testNG;

import org.testng.annotations.Test;

public class TestNGdemo {
	@Test(priority = 2)
public void startCar() {
		System.out.println("Car Started");
	}
	
	@Test(priority = 3)
	public void driveCar() {
		System.out.println("Drive car");
	
	}
	
	
	@Test(priority = 1)
	public void stopCar() {
		System.out.println("Car Stopped");
	}
}
