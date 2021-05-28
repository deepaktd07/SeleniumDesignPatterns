package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");


    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttributes(){
      return findElement(flights).getAttribute("class");
    }

    public int getLinksCount(){
        return findElements(links).size();
    }
}
