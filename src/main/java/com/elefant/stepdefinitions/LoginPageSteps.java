package com.elefant.stepdefinitions;

import com.elefant.managers.DriverManager;
import com.elefant.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
    @When("the login form is populated with following details")
    public void theLoginFormIsPopulatedWithFollowingDetails(List<String> loginCredentials) {
        loginPage.fillInTheLoginForm(loginCredentials.get(0), loginCredentials.get(1));
    }

    @And("loginButton is clicked")
    public void loginbuttonIsClicked() {
        loginPage.clickTheLoginButton();
    }
}
