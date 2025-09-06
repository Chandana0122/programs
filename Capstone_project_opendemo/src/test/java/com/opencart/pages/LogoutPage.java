package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private By logoutLink = By.linkText("Logout");
    private By logoutMessage = By.cssSelector("#content h1");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean logout() {
        driver.findElement(logoutLink).click();
        return driver.findElement(logoutMessage).getText().contains("Account Logout");
    }
}
