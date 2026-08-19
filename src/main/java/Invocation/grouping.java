package Invocation;

import org.testng.annotations.Test;

public class grouping {

	public class group {
		@Test(groups = {"sanity"})
		public void testA() {
		System.out.println("Sanity Test A");
		}

		@Test(groups = {"regression"})
		public void testB() {
		System.out.println("Regression Test B");
		}

		@Test(groups = {"sanity", "regression"})
		public void testC() {
		System.out.println("Sanity and Regression Test C");
		}
		}

}
