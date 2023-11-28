package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickTheContinueBtn();
        System.out.println("The continue button has been clicked");
    }
}
