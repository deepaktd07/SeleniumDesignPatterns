package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver ;
    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver= driver;
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By FindElementBy){
      return  sectionElement.findElement(FindElementBy);
    }
    public List<WebElement> findElements(By FindElementsBy){
        return  sectionElement.findElements(FindElementsBy);
    }
    public void waitForTheElementToDisapear(By FindElementBy){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(FindElementBy));
    }
}
