package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    private static final Logger logger = LogManager.getLogger(HomePageSteps.class);
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("HomePage is displayed")
    public void homepageIsDisplayed() {
        driver.get("https://www.elefant.md/homepage-mikrosite-cms-home");
        logger.log(Level.INFO,"The driver accessed home page");
    }

    @When("registerLink from Header menu is clicked")
    public void registerlinkFromHeaderMenuIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        logger.log(Level.INFO,"The register Link has been accessed from the Header Menu");
    }

}

