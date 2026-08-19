package Parallel;

import org.testng.annotations.Test;

public class testOne {

    @Test
    public void method1() {
        System.out.println("TestOne - Method1 - Thread: "
                + Thread.currentThread().getId());
    }

    @Test
    public void method2() {
        System.out.println("TestOne - Method2 - Thread: "
                + Thread.currentThread().getId());
    }
}