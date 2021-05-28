package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver intializeDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\dmani7102\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
