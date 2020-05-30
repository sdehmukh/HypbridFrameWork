package com.qa.test;

import com.qa.base.testBase;
import com.qa.pages.catlogPage;
import com.qa.pages.dashboardPage;
import com.qa.pages.loginPage;
import com.qa.util.testUtil;
import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dashboardPageTest extends testBase {
    dashboardPage dashBoardPage;
    loginPage lgpage;
    catlogPage catPage;
    public String sheetName="newProduct";

    public dashboardPageTest()
    {

        super();
    }

    @BeforeClass
    public void setup()
    {
        initialization();
        dashBoardPage=new dashboardPage();
        lgpage=new loginPage();
        catPage=new catlogPage();
        dashBoardPage=lgpage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyLoginUserName()
    {
        boolean loginuser=dashBoardPage.verifyLoginUser();
        String uname=dashboardPage.loginUsername.getText();
        System.out.println(uname);
        Assert.assertTrue(loginuser);

    }

    @Test(priority = 2)
    public void selectProduct()
    {
        catPage.Catlog.click();
        catPage.Products.click();
        catPage.selectProduct("$25 Virtual Gift Card");

    }

    @DataProvider
    public Object[][] getProductData()
    {
        Object data[][]=testUtil.getSheetData(sheetName);
        return data;
    }

    @Test(priority = 3,dataProvider = "getProductData")
    public void AddProduct(String ProductName,String ProductType)
    {
     catPage.addProduct(ProductName,ProductType);

    }

    @Test(priority = 4)
    public void logout()
    {
        dashboardPage.logout.click();
    }



    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
