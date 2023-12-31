package com.elefant.stepdefinitions;

import com.elefant.managers.DataSubstituteManager;
import com.elefant.managers.DriverManager;
import com.elefant.managers.ExplicitWaitManager;
import com.elefant.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.Map;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    private static final Logger logger = LogManager.getLogger(GenericSteps.class);

    @Then("the current Url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keyWordFromTheUrl) throws InterruptedException {
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keyWordFromTheUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keyWordFromTheUrl + " is present in " + currentUrl);

        logger.log(Level.INFO, "The step number 3 prints the keyword: " + keyWordFromTheUrl);
    }

    @Given("{string} endpoint is accessed")
    public void endpointIsAccessed(String endpointValue) {
        driver.get("https://www.elefant.md" + endpointValue);
    }

    @And("the {string} from {string} is clicked")
    public void theFromIsClicked(String elementName, String pageName) {
        try {
            Class classInstance = Class.forName("com.elefant.pageobjects." + pageName);
            Field classField = classInstance.getDeclaredField("elementName");
            classField.setAccessible(true);
            WebElement elementToBeClicked = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ExplicitWaitManager.waitTilElementIsClickable(elementToBeClicked);
            ScrollManager.scrollToTheElement(elementToBeClicked);
            elementToBeClicked.click();
            logger.log(Level.INFO, "The element " + elementToBeClicked.getAccessibleName() + " is clicked");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("the following form {string} is populated as follow:")
    public void theFollowingFormIsPopulatedAsFollow(String pageName, Map<String, String> fieldAndValuesMap) {
        fieldAndValuesMap.forEach((fieldName, fieldValue) -> {
            Class classInstance = null;
            try {
                classInstance = Class.forName("com.elefant.pageobjects." + pageName);
                Field classField = classInstance.getDeclaredField(fieldName);
                classField.setAccessible(true);
                WebElement inputElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
                fieldValue = DataSubstituteManager.substituteString(fieldValue);
                ExplicitWaitManager.waitTilElementIsVisible(inputElement);
                inputElement.sendKeys(fieldValue);

                logger.log(Level.INFO, "The field [" + fieldName +"] is populated with [" + fieldValue +"]");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
         });
    }
}