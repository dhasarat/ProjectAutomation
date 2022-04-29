package com.project.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.project.automation.pages.PageManager;

public class DemoTest extends BaseTest_Mobile{
    
    @Autowired
    PageManager page;
   
    

    @Test
    public void testmethod() throws InterruptedException {
        startTest("Login to App");
        System.out.println("In Test Method");
        page.getLoginPage().loginToApp("John","Password@1234");
    }
}
