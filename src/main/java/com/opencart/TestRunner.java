package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowsName = driver.getWindowHandle();

        Thread.sleep(1000);
        // New Window Code
    //    driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.elefant.md/homepage-mikrosite-cms-home");


        WebElement conectareIcon = driver.findElement(By.xpath("//span[@class='login-prompt js-login-prompt']"));
        conectareIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[contains(text(),'Creează cont')]"));
        Thread.sleep(2000);
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement domnDoamnaOption = driver.findElement(By.xpath("//label[normalize-space()='Dl.']"));

        domnDoamnaOption.click();

        WebElement prenumeUtilizator = driver.findElement(By.xpath("//input[@id='PostCheckoutRegisterForm_FirstName']"));
        String lastname = RandomDataGeneratorManager.generateLastName();
        prenumeUtilizator.sendKeys(lastname);
        System.out.println(lastname);

        WebElement numeUtilizator = driver.findElement(By.cssSelector("#PostCheckoutRegisterForm_LastName"));
        String numeUtilizatorRandom = RandomDataGeneratorManager.generateFirstName();
        numeUtilizator.sendKeys(numeUtilizatorRandom);
        System.out.println(numeUtilizatorRandom);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='PostCheckoutRegisterForm_Login']"));
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);



     //   WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
     //   phoneInput.sendKeys(RandomDataGeneratorManager.generatePhoneNumber());


        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='PostCheckoutRegisterForm_Password']"));
        String randomPassword = RandomDataGeneratorManager.generatePassword();
        passwordInput.sendKeys(randomPassword);
        System.out.println(randomPassword);

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#PostCheckoutRegisterForm_RetypedPassword"));


        confirmPasswordInput.sendKeys(randomPassword);
        System.out.println(randomPassword);



        WebElement privacyPolicyInput = driver.findElement(By.cssSelector("div[class='checkbox'] label small"));

        JavascriptExecutor je = (JavascriptExecutor) driver;

        je.executeScript("arguments[0].scrollIntoView(true);", privacyPolicyInput);


      //  je.executeScript("\"window.scrollBy(0, 250)\", \" 250\"");

        privacyPolicyInput.click();

        WebElement registerButton = driver.findElement(By.xpath("//button[contains(text(),'Creează cont')]"));
        registerButton.click();

        Thread.sleep(5000);


        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
        System.out.println("The execution is over and over again");

    }
}
