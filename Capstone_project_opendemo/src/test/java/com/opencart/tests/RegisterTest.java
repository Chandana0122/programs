package com.opencart.tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.Base;
import com.opencart.pages.RegisterPage;
import com.opencart.utilities.ExcelUtil;

public class RegisterTest extends Base {

    @Test
    public void testRegisterUser() {
        // Fetch data from Excel (assume row 1 has values)
        Map<String, String> data = ExcelUtil.getRegisterData(1);

        RegisterPage registerPage = new RegisterPage(driver);
        boolean result = registerPage.registerUser(data);

        // Report + Assert
        if (result) {
            test.pass("🎉 Registration successful for email: " + data.get("mail"));
        } else {
            test.fail("❌ Registration failed for email: " + data.get("mail"));
        }

        Assert.assertTrue(result, "User registration failed!");
    }
}
