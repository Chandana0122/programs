package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.opencart.utilities.WaitUtil;

public class CheckoutPage {
    private WebDriver driver;

    private By checkoutLink = By.linkText("Checkout");
    private By billingDetails = By.id("button-payment-address");
    private By deliveryDetails = By.id("button-shipping-address");
    private By deliveryMethod = By.id("button-shipping-method");
    private By paymentMethod = By.id("button-payment-method");
    private By confirmOrder = By.id("button-confirm");
    private By successMessage = By.cssSelector("#content h1");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkout() {
        driver.findElement(checkoutLink).click();
        WaitUtil.waitForPageLoad(driver, 20);

        driver.findElement(billingDetails).click();
        driver.findElement(deliveryDetails).click();
        driver.findElement(deliveryMethod).click();
        driver.findElement(paymentMethod).click();
        driver.findElement(confirmOrder).click();

        return driver.findElement(successMessage).getText().contains("Your order has been placed!");
    }
}
