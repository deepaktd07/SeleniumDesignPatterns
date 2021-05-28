package org.example;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {
        driver = intializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {
        travelHomePage.launchApp();
        System.out.println(travelHomePage.getFooterNav().getFlightAttributes());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttributes());
        System.out.println(travelHomePage.getFooterNav().getLinksCount());
        System.out.println(travelHomePage.getNavigationBar().getLinksCount());
        travelHomePage.setBookingStratergy("multiTrip");
//        travelHomePage.checkAvailabiltiy(reservationDetails);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> reservationDetails = new HashMap<>();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destination2", "BLR");

        HashMap<String, String> reservationDetails2 = new HashMap<>();
        reservationDetails2.put("origin", "HYD");
        reservationDetails2.put("destination", "BLR");
        reservationDetails2.put("destination2", "MAA");
        return new Object[][]{{reservationDetails}, {reservationDetails2}};
    }

}
