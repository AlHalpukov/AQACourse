package lesson002;

import org.junit.jupiter.api.Test;

public class ParallelJUnitTests {
    @Test
    void firstTest() throws InterruptedException {
        System.out.println("First Parallel Unit Test start -> " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("First Parallel Unit Test finish -> " + Thread.currentThread().getName());
    }

    @Test
    void secondTest() throws InterruptedException {
        System.out.println("Second Parallel Unit Test start -> " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("Second Parallel Unit Test finish -> " + Thread.currentThread().getName());
    }
}
