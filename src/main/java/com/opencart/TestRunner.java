package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowsName = driver.getWindowHandle();
        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opencart.antropy.co.uk/");


        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));

        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));

        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstname = RandomDataGeneratorManager.generateFirstName();
        firstNameInput.sendKeys(firstname);
        System.out.println(firstname);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataGeneratorManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastNameInput);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        phoneInput.sendKeys(RandomDataGeneratorManager.generatePhoneNumber());


        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String randomPassword = RandomDataGeneratorManager.generatePassword();
        passwordInput.sendKeys(randomPassword);
        System.out.println(randomPassword);

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));


        confirmPasswordInput.sendKeys(randomPassword);
        System.out.println(randomPassword);

        WebElement privacyPolicyInput = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicyInput.click();

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerButton.click();


        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
        System.out.println("The execution is over and over again");

    }
}
