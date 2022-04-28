package com.schrack.sfsAutomation;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.schrack.sfsAutomation.pages.PageManager;

public class DemoTest extends BaseTest_Mobile{
    
    @Autowired
    PageManager page;
   
    

    @Test
    public void testmethod() throws InterruptedException {
        startTest("Login to App");
        System.out.println("In Test Method");
        page.getLoginPage().loginToApp("danish","Password@1234");
        Thread.sleep(5000);
        page.getStudyPlatformPage().closeDownloadPopUp();
        Thread.sleep(5000);
    }
}
