package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSUITE(){
        System.out.println("Before SuIte");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Before TEST");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before  Method");
    }
    @Test
    public void test1(){
        System.out.println("test-1");
    }
    @Test
    public void test2(){
        System.out.println("test-2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSUITE(){
        System.out.println("After Suite");
    }
}
