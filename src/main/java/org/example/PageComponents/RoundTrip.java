package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private By roundTripCheckBox = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.xpath("//input[@value ='Search']");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }



    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        System.out.println("I am inside RoundTrip");
        findElement(roundTripCheckBox).click();
        originCity(reservationDetails.get("origin"));
        destinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void originCity(String origin){
        findElement(from).click();
     findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void destinationCity(String destination){
        findElement(to).click();
       findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

}
