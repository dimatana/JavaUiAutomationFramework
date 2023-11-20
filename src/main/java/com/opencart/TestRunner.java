package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowsName = driver.getWindowHandle();
    // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");

        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowsName);
        driver.get("https://www.investing.com/currencies/eur-usd-commentary");
        Thread.sleep(2000);

        driver.quit();

        System.out.println("The execution is over");

    }
}
