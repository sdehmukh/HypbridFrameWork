package com.qa.pages;

import com.qa.base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage extends testBase {

    @FindBy(xpath = "//li[@class='account-info']")
    public static WebElement loginUsername;

    @FindBy(linkText = "Logout")
    public static WebElement logout;

    public dashboardPage()
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyLoginUser()
    {
        return loginUsername.isDisplayed();
    }

    public boolean verifyLogout()
    {
        return logout.isDisplayed();
    }


}
