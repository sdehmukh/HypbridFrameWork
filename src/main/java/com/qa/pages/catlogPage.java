package com.qa.pages;

import com.qa.base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class catlogPage extends testBase {

    @FindBy(xpath = "//span[text()='Catalog']")
    public static WebElement Catlog;

    @FindBy(linkText = "Products")
    public static WebElement Products;

    @FindBy(linkText = "Add new")
    public static  WebElement AddProducet;

    @FindBy(linkText = "Categories")
    public static WebElement Categories;

    @FindBy(xpath = "//div[@id='product-info']//input[@name='Name']")
    public WebElement productName;

    @FindBy(xpath = "//form[@id='product-form']//button[@name='save']")
    WebElement saveBtn;



    ////td[text()='$100 Physical Gift Card']//preceding::td/input[@type='checkbox']

    public catlogPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void selectProduct(String productName)
    {
        driver.findElement(By.xpath("//td[text()='"+productName+"']//preceding::td/input[@type='checkbox']")).click();
    }

    public void addProduct(String pName,String selectGroup)
    {
        AddProducet.click();
        productName.sendKeys(pName);
        Select select=new Select(driver.findElement(By.name("ProductTypeId")));
        select.deselectByVisibleText(selectGroup);
        saveBtn.click();
    }
    public void mouseAction()
    {
        Actions action=new Actions(driver);
        action.moveToElement(Categories);

    }


}
