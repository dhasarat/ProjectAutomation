package com.project.automation;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.project.automation.config.AppCenterAPIs;

public class DownloadBuildFromAppCenter extends BaseTest{
    @Autowired
    AppCenterAPIs dw;

    @Test
    public void getReleaseDetails() throws Exception {
        dw.downloadBuildFromAppCenter();
    }
    
    @AfterClass
    public void tearDown() {
        dw.quitDriver();
    }

}
