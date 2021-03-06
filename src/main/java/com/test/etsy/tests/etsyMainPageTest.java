package com.test.etsy.tests;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class etsyMainPageTest extends EtsyTestBase {
    @Parameters("itemSearch")
    @Test
    public void EtsySearchTest(String item){
        EtsyMainPage mainPage= new EtsyMainPage(driver);
        mainPage.LookForIphone(item);
        Assert.assertTrue(mainPage.validateHeader());
    }
}
