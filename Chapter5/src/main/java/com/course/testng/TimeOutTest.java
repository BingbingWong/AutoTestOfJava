package com.course.testng;

import org.testng.annotations.Test;

@Test(timeOut = 3000)//毫秒
public class TimeOutTest {
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}


