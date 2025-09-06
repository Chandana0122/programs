package com.opencart.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utilities.WaitUtil;

public class RegisterPage {
    private WebDriver driver;

    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By subscribeYes = By.xpath("//label[text()='Yes']");
    private By subscribeNo = By.xpath("//label[text()='No']");
    private By policy = By.xpath("//input[@type='checkbox']");
    private By continueBtn = By.xpath("//input[@type='submit']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean registerUser(Map<String, String> data) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        WaitUtil.waitForPageLoad(driver, 20);

        driver.findElement(firstname).sendKeys(data.get("firstname"));
        driver.findElement(lastname).sendKeys(data.get("lastname"));
        driver.findElement(email).sendKeys(data.get("email")); // ✅ corrected key name
        driver.findElement(telephone).sendKeys(data.get("phone"));
        driver.findElement(password).sendKeys(data.get("password"));
        driver.findElement(confirmPassword).sendKeys(data.get("password"));

        driver.findElement(subscribeYes).click();
        driver.findElement(policy).click();
        driver.findElement(continueBtn).click();

        System.out.println("Registration completed");
        return true;
    }
}
