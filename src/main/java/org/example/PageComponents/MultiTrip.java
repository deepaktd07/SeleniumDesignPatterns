package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By multiTripCheckBox = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By to = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.xpath("//input[@value ='Search']");
    private By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By MultiCityModelAlert = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }



    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        findElement(search).click();
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
    public void selectDestinationCity2(String destination2){
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside multitrip");
        findElement(multiTripCheckBox).click();
        findElement(MultiCityModelAlert).click();
        consumer.accept(this);
        System.out.println("test done");
    }

}
