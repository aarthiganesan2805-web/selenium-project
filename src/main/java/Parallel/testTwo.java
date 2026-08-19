package Parallel;

import org.testng.annotations.Test;

public class testTwo {

    @Test
    public void method3() {
        System.out.println("TestTwo - Method3 - Thread: "
                + Thread.currentThread().getId());
    }

    @Test
    public void method4() {
        System.out.println("TestTwo - Method4 - Thread: "
                + Thread.currentThread().getId());
    }
}