package org.example.AbstractComponents;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StratergyFactor {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");


    public StratergyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStratergy(String stratergyType) {

        if (stratergyType.equalsIgnoreCase("multiTrip")) {
            return new MultiTrip(driver, sectionElement);
        }
        if (stratergyType.equalsIgnoreCase("roundTrip")) {
            return new RoundTrip(driver, sectionElement);
        } else {
            return null;
        }
    }
}
