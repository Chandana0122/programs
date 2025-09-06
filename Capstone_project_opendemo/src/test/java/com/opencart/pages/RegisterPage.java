package com.opencart.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utilities.WaitUtil;

public class RegisterPage {

    WebDriver driver;

    // Locators
    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By mail = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By cpassword = By.id("input-confirm");
    private By subscribeYes = By.xpath("//label[text()='Yes']");
    private By subscribeNo = By.xpath("//label[text()='No']");
    private By policy = By.xpath("//input[@type='checkbox']");
    private By continueBtn = By.xpath("//input[@value='Continue']");
    private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Registers a new user using data from Excel
     * 
     * @param data Map<String,String> from Excel
     * @return true if registration successful
     */
    public boolean registerUser(Map<String, String> data) {
        try {
            // Open register page
            driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
            WaitUtil.waitForPageLoad(driver, 20);
            System.out.println("✅ Register page opened");

            // Read data from Excel map (keys must match Excel exactly)
            String first = data.getOrDefault("firstname", "");
            String last = data.getOrDefault("lastname", "");
            String email = data.getOrDefault("email", "");
            String phone = data.getOrDefault("phone", "");
            String pass = data.getOrDefault("password", "");
            String subscribe = data.getOrDefault("subscribe", "no");

            // Check mandatory fields
            if (first.isEmpty() || last.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                System.out.println("❌ Missing mandatory Excel data, skipping registration");
                return false;
            }

            // Fill the form
            driver.findElement(firstname).sendKeys(first);
            driver.findElement(lastname).sendKeys(last);
            driver.findElement(mail).sendKeys(email);
            driver.findElement(telephone).sendKeys(phone);
            driver.findElement(password).sendKeys(pass);
            driver.findElement(cpassword).sendKeys(pass);

            // Subscribe option
            if (subscribe.equalsIgnoreCase("yes")) {
                driver.findElement(subscribeYes).click();
            } else {
                driver.findElement(subscribeNo).click();
            }

            // Accept privacy policy and submit
            driver.findElement(policy).click();
            driver.findElement(continueBtn).click();

            // Wait for page load after submission
            WaitUtil.waitForPageLoad(driver, 10);

            // Verify success
            boolean success = driver.findElements(successMessage).size() > 0;

            if (success) {
                System.out.println("🎉 Registration successful for email: " + email);
            } else {
                System.out.println("❌ Registration failed for email: " + email);
            }

            return success;

        } catch (Exception e) {
            System.out.println("❌ Exception during registration: " + e.getMessage());
            return false;
        }
    }
}
