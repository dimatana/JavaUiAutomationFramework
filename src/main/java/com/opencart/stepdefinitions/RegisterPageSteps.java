package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);



    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {
        String firstName = RandomDataGeneratorManager.generateLastName();
        String lastName = RandomDataGeneratorManager.generateFirstName();
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        String randomPassword = RandomDataGeneratorManager.generatePassword();
        System.out.println(randomEmail);
        System.out.println(randomPassword);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword, randomPassword, true);

        System.out.println("The register form is populated with valid random data");
    }

    @When("the register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = RandomDataGeneratorManager.generateFirstName();
        }
        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = RandomDataGeneratorManager.generateLastName();
        }
        String emailInput = formDataMap.get("email");
        if (emailInput != null && emailInput.equalsIgnoreCase("RANDOM")) {
            emailInput = RandomDataGeneratorManager.generateRandomEmail();
            String password = formDataMap.get("password");
            if (password != null && password.equalsIgnoreCase("RANDOM")) {
                password = RandomDataGeneratorManager.generatePassword();

                registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailInput, password, password, true);
            }
        }
    }

    @Then("the following list of error messages is displayed")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(10000);
        errorMessagesList.forEach(errorMessage -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//small[@data-bv-for='PostCheckoutRegisterForm_" + registerPage.getXpath() +"'][normalize-space()='" + errorMessage + "']")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "The error message " + errorMessage + "is displayed");
        });
    }
}