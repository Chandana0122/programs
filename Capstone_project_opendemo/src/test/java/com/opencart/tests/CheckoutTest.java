package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.Base;
import com.opencart.pages.CheckoutPage;

public class CheckoutTest extends Base {

    @Test
    public void testCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        boolean status = checkoutPage.checkout();
        Assert.assertTrue(status, "Checkout process failed.");
    }
}
