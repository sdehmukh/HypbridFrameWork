package com.qa.test;

import com.qa.base.testBase;
import com.qa.pages.dashboardPage;
import com.qa.pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginPageTest extends testBase {
    loginPage lgpage;
    dashboardPage dashboardPage;
    public loginPageTest()
    {
        super();
    }

    @BeforeClass
    public void setup() {
        initialization();
        lgpage=new loginPage();
    }

    @Test(priority = 1)
    public void loginPageTitle(){
       String title= lgpage.validateLoginPageTitle();
        Assert.assertEquals(title,"Your store. Login");
    }

    @Test(priority = 2)
    public void login()
    {
        dashboardPage=lgpage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

  /*  @AfterMethod
    public void tearDown(){
        driver.close();
    }*/

}
