package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='login-prompt js-login-prompt']")
    protected WebElement myAccount;


    @FindBy(xpath = "//a[contains(text(),'Creează cont')]")
    protected WebElement registerBtn;

    @FindBy(xpath = "//a[normalize-space()='Conectare']")

    protected WebElement loginBtn;

    public void navigateToRegisterPageFromHeader(){

        myAccount.click();
        registerBtn.click();

    }

    public void navigateToLoginPageFromHeader(){

        myAccount.click();
        loginBtn.click();
    }

}
