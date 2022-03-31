package TESTNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name="FullNameTest")
    public Object[][]getData(){
        return new Object[][]{
                {"atyra","nazar","atyra nazar"},
                {"Ivan","Ivanova","Ivan Ivanova"},
                {"eric","Eric2","eric Eric2"},
                {"Kani","Enes5","Kani Enes5"},
                {"Olivia","Sharapova","Olivia Sharapova"},
                {"Enes","Enes4","Enes Enes4"}
        };
    }
}
