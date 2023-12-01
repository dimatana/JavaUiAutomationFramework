package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver){super(driver);}

    @FindBy(id = "ShopLoginForm_Login")
    private WebElement emailInput;

    @FindBy(id = "ShopLoginForm_Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Conectare']")
    private WebElement loginButton;

    public void fillInTheLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickTheLoginButton(){
    //    ScrollManager.scrollToTheElement(loginButton);
        loginButton.click();
    }


}
