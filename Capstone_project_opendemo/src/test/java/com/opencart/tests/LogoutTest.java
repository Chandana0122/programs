package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.Base;
import com.opencart.pages.LogoutPage;

public class LogoutTest extends Base {

    @Test
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        boolean status = logoutPage.logout();
        Assert.assertTrue(status, "Logout failed.");
    }
}
