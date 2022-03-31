package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TESTNGAssertion {
    // create one method that takes two parameters
    // multiplication of these numbers

    public double multiplication(double number1, double number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplication(){
        double Actualresult = multiplication(5,6);
        double ExpectedResult=30;

      /*  if (Actualresult==ExpectedResult){
            System.out.println("passed");
        } */

        // it is going show up if it fails(message)
        Assert.assertEquals(Actualresult,ExpectedResult,"my numbers are 5 and 6");
    }
    public double getDivision(double num1, double num2){
        if (num1>=num2){
            return num1 / num2;
        }
        return num2 / num1;
    }
    public int substruction(int num1, int num2){
        if (num1>=num2){
            return num1 - num2;
        }
        return num2 - num1;
    }

    @Test
    public void validateDivision(){
        double actualResul=getDivision(8,2);
        double expectedResult = 4;
        Assert.assertEquals(actualResul,expectedResult);
    }

    @Test
    public void validateSubstruction(){
        int actualResult = substruction(65,43);
        int expectedResult = 22;
        Assert.assertEquals(actualResult,expectedResult);
        double actualResulOfDivision = getDivision(6,3);
        double expectedResulOfDivision=2;
        Assert.assertEquals(actualResulOfDivision,expectedResulOfDivision);

    }


}
