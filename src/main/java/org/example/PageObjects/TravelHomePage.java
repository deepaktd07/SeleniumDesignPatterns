package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvail;
import org.example.AbstractComponents.StratergyFactor;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By SectionElement = By.id("traveller-home");
    By HeaderSectionElement = By.className("search-buttons-heading");
    SearchFlightAvail searchFlightAvail;
    WebDriver driver;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void launchApp(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver,HeaderSectionElement);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver,SectionElement);
    }
    public void setBookingStratergy(String stratergyType){
        StratergyFactor stratergyFactor = new StratergyFactor(driver);
        searchFlightAvail = stratergyFactor.createStratergy(stratergyType);
        this.searchFlightAvail =searchFlightAvail;
    }
    public void checkAvailabiltiy(HashMap<String, String> reservationDetails){
        searchFlightAvail.checkAvail(reservationDetails);
    }

}
