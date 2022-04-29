package com.project.automation;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.project.automation.annotations.LazyCompMobile;

@LazyCompMobile
public class TestSuite extends BaseTest_Mobile {

    @Autowired
    LinkedHashMap<String, String> getLoginUsers;

    @Autowired
    LinkedHashMap<String, String> getLoginPageData;

    @Autowired
    LinkedHashMap<String, String> getForgotPasswordPageData;

    String validSearchKeyword = "test";
    String invalidSearchKeyword = "ashdsdf";

    Faker faker = new Faker();

    @Test(priority = 0, groups = {
            "LoginPageTests" }, description = "TC#1 Test to validate the links present on login page.")
    public void LinksValidation_LoginPage() {
        startTest("TC#1 Login Page Test - Link Validations");
        Assert.assertTrue(page.getLoginPage().isforgotPassLinkDisplayed(), "Forgot Password link is not displayed.");
        log("Forgot Password link is displayed.");
    }


}
