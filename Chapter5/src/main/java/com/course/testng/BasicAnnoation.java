package com.course.testng;
import org.testng.annotations.*;

public class BasicAnnoation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test(groups = "stu")
    public void testCase1(){
        System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
        System.out.println("Test这是测试用例1");
    }
 /*   @Test
    public void testCase2(){
        System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
        System.out.println("Test这是测试用例2");
    }*/
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void atferMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass这是在类运行之后运行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
    @BeforeGroups(groups = "stu")
    public void beforeGroup(){
        System.out.println("BeforeGroups测试组");
    }
    @AfterGroups(groups = "stu")
    public void afterGroup(){
        System.out.println("AfterGroups测试组");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest测试");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest测试");
    }

}
