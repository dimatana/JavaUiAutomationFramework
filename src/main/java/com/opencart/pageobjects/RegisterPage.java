package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private String xpath;

    @FindBy(xpath = "//label[normalize-space()='Dl.']")
    private WebElement domnDoamnaOption;

    @FindBy(xpath = "//input[@id='PostCheckoutRegisterForm_FirstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='PostCheckoutRegisterForm_LastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='PostCheckoutRegisterForm_Login']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='PostCheckoutRegisterForm_Password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='PostCheckoutRegisterForm_RetypedPassword']")
    private WebElement confirmPassInput;
    @FindBy(css = "div[class='checkbox'] label small")
    private WebElement privacyTooggle;
    @FindBy(xpath = "//button[contains(text(),'Creează cont')]")
    private WebElement conitueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password, String confirmPass, boolean toggle){
        domnDoamnaOption.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPassInput.sendKeys(password);

        if (toggle) {
            ScrollManager.scrollToTheElement(privacyTooggle);
            privacyTooggle.click();
        }


    }

    public void clickTheContinueBtn(){
        conitueBtn.click();
    }

    public String getXpath(){
        return xpath;
    }
    public void setXpath(final String xpath) {
        this.xpath = xpath;
    }

}
