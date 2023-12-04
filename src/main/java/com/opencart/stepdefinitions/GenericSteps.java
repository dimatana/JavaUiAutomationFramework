package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the current Url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keyWordFromTheUrl) throws InterruptedException {
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keyWordFromTheUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keyWordFromTheUrl + " is present in " + currentUrl);

        System.out.println("The step number 3 prints the keyword: " + keyWordFromTheUrl);
    }

    @Given("{string} endpoint is accessed")
    public void endpointIsAccessed(String endpointValue) {
        driver.get("https://www.elefant.md" + endpointValue);
    }

//    @Then("the following list of error messages is displayed")
//    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
//        Thread.sleep(500);
//        errorMessagesList.forEach(errorMessage -> {
//            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//small[@data-bv-for='PostCheckoutRegisterForm_FirstName'][normalize-space()='" + errorMessage + "']")).isDisplayed();
//            Assertions.assertTrue(errorMessageIsDisplayed, "The error message " + errorMessage + "is displayed");
//        });
 //   }
}
