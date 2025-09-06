package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.opencart.utilities.WaitUtil;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By logoutLink = By.linkText("Logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean login(String email, String password) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        WaitUtil.waitForPageLoad(driver, 20);

        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        return driver.findElements(logoutLink).size() > 0;
    }
}
