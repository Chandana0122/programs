package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.Base;
import com.opencart.pages.LoginPage;

public class LoginTest extends Base {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        boolean status = loginPage.login("john@test.com", "Test@123");
        Assert.assertTrue(status, "Login failed with valid credentials.");
    }
}
