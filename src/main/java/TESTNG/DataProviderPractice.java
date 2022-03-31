package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

 /*   @DataProvider(name="FullNameTest")
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

  */



    @Test(dataProvider="FullNameTest",dataProviderClass = DataForNames.class)
    public void test1(String username, String lastname, String expectedFullName){
        String userName=username;
        String lastName=lastname;
        String fullName=username+" "+lastName;
        Assert.assertEquals(fullName,expectedFullName);
    }


}
