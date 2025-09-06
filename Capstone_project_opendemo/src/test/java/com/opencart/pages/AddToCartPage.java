package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.opencart.utilities.WaitUtil;

public class AddToCartPage {
    private WebDriver driver;

    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
    private By successMessage = By.cssSelector(".alert-success");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean addProductToCart(String productName) {
        driver.get("https://tutorialsninja.com/demo/index.php");
        WaitUtil.waitForPageLoad(driver, 20);

        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
        driver.findElement(By.linkText(productName)).click();
        driver.findElement(By.id("button-cart")).click();

        return driver.findElement(successMessage).getText().contains("Success: You have added");
    }
}
