package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.elefant.md/homepage-mikrosite-cms-home");

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

        String firstName = RandomDataGeneratorManager.generateLastName();
        System.out.println(firstName);

        String lastName = RandomDataGeneratorManager.generateFirstName();
        System.out.println(lastName);

        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(randomEmail);

        String randomPassword = RandomDataGeneratorManager.generatePassword();
        System.out.println(randomPassword);

        System.out.println(randomPassword);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword, randomPassword, true);

        registerPage.clickTheContinueBtn();
        Thread.sleep(5000);
        DriverManager.getInstance().tearDown();
        System.out.println("The execution is over and over again");

    }
}
