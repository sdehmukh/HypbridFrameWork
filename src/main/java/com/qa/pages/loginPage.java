package com.qa.pages;

import com.qa.base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends testBase {

    //Page Factory and OR(Object Repository):
    @FindBy(xpath="//input[@id='Email']")
    //Mostly used element stored in cached memory.
    //When page is refresh page element / dom get changed(Steal element exception).
    //Q-how will you improve your script performance
    @CacheLookup
    WebElement username;

    @FindBy(xpath="//input[@id='Password']")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;


    //Initializing the page Objects:
    public loginPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }

    public dashboardPage login(String un,String pass){
        username.clear();
        username.sendKeys(un);
        password.clear();
        password.sendKeys(pass);
        loginBtn.click();

        return new dashboardPage();

    }

}
