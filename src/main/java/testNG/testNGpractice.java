package testNG;

import org.testng.annotations.Test;

public class testNGpractice {
@Test(priority=1)
public void startCar() {
System.out.println("Car started");
}

@Test(priority=2)
public void driveCar() {
System.out.println("Car driving");
}
@Test(priority=3)
public void stopCar() {
System.out.println("Car stopped");
}
}
	
 