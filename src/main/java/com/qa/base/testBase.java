package com.qa.base;

import com.qa.util.testUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {
    public static WebDriver driver;
    public static Properties prop;
    public static String path;
    public testBase()
    {
        try{
            path = System.getProperty("user.dir");
            System.out.println(path);
            prop= new Properties();

            //InputStream in = testBase.class.getResourceAsStream("config.properties");
        File fp=new File(path+"\\src\\main\\java\\com\\qa\\config\\config.properties");
        FileInputStream ip=new FileInputStream(fp);
        prop.load(ip);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization()
    {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\java\\com\\qa\\drivers\\chromedriver.exe");
            driver=new ChromeDriver();
        }else if(browserName.equals("firFox"))
        {
            System.setProperty("webdriver.gecko.driver",path+"\\src\\main\\java\\com\\qa\\drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
}
