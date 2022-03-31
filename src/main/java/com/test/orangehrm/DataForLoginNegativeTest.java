package com.test.orangehrm;

import org.testng.annotations.DataProvider;

public class DataForLoginNegativeTest {
    @DataProvider(name="LoginNegativeTest")
    public Object[][]getNegativeData(){
        return new Object[][]{
                {"Admin","wrongPassword","Invalid credentials"},
                {"Atyra","admin123","Invalid credentials"},
                {"Atyra","atyra123","Invalid credentials"}
        };
    }
}
