package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MutiThreadOnAnnotion {
    @Test(invocationCount = 3,threadPoolSize = 3)
    public void test(){
       // System.out.println(1);
        System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
    }
}
