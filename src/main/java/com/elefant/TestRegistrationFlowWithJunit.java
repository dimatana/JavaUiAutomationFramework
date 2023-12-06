package com.elefant;

import com.elefant.managers.DriverManager;
import com.elefant.managers.RandomDataGeneratorManager;
import com.elefant.pageobjects.HomePage;
import com.elefant.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    
    @BeforeAll
    public static void executeThisMethodBeforeAllTests(){
        System.out.println("The execution of the tests has started");
    }
    @BeforeEach
    public void executeTheCodeBeforeEachTest() throws InterruptedException {
        System.out.println("The code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.elefant.md/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();
        registerPage = new RegisterPage(driver);


    }

    @Test
    @Disabled
    @Order(1)
    @DisplayName("The registration of a new user with valid data redirects to the account page")

    public void registerWithValidCredentialTest() throws InterruptedException {
        String firstName = RandomDataGeneratorManager.generateLastName();
        String lastName = RandomDataGeneratorManager.generateFirstName();
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        String randomPassword = RandomDataGeneratorManager.generatePassword();
        System.out.println(randomEmail);
        System.out.println(randomPassword);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword, randomPassword, true);
        registerPage.clickTheContinueBtn();
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean doesTheCurrentUrlContainsSuccesAccountRoute = currentUrl.contains("my-account/profile?");
        //      https://www.elefant.md/my-account/profile?Consent=UserRegistration
        Assertions.assertTrue(doesTheCurrentUrlContainsSuccesAccountRoute, "The current url: " + currentUrl +  " contains: my-account/profile?");

    }
    @Test
    @Order(2)
    @DisplayName("The user is remaining on register page when trying to register with invalid passord")
    public void registerWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is the test number 2");
        String firstName = RandomDataGeneratorManager.generateLastName();
        String lastName = RandomDataGeneratorManager.generateFirstName();
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail,"didi", "didi", true);
        registerPage.clickTheContinueBtn();

        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.elefant.md/new-account?TargetPipeline=ViewProfileSettings-ViewProfile";

        Assertions.assertEquals(expectedUrl, actualUrl);


    }

    @Test
    @Order(3)
    @DisplayName("error Message Is Displayed When Invalid Password Is Used For Register Flow")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() throws InterruptedException {
        System.out.println("This is the test number 3");
        String firstName = RandomDataGeneratorManager.generateLastName();
        String lastName = RandomDataGeneratorManager.generateFirstName();
        String randomEmail = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, "Ag1", "Ag1", true);
        registerPage.clickTheContinueBtn();

        Thread.sleep(1000);

        String expectedErrorMessageForInvalidPassword = "Parola ta trebuie să conțină cel puțin 6 caractere .";
        String actualErrorMessage = driver.findElement(By.xpath("//small[contains(text(),'Parola ta trebuie să conțină cel puțin 6 caractere')]")).getText();
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);


    }

    @AfterEach
    public void afterEachTestCase(){
        DriverManager.getInstance().tearDown();
        System.out.println("The test case execution has been finished");
    }
    @AfterAll
    public static void afterAllTestCases(){
        System.out.println("All test suite execution is finished");
    }

 //   @Test
 //   @Disabled
 //   public void sampleTest(String[] args) throws InterruptedException {

 //   }

}
