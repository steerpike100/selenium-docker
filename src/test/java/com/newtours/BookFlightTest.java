package com.newtours;

import com.newtours.pages.*;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;


    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setUpParameters(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;

    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("spadgehopkins", "docker");
        registrationPage.enterUserCredentials("spadgehopkins", "Zynr2xJ8imByySG");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailsPageTest() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPageTest")
    public void findFlightPageTest() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPageTest")
    public void flightConfirmationPageTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);


    }


}
