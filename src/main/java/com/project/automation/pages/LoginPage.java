package com.project.automation.pages;

import com.project.automation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class LoginPage extends BasePage {

    @AndroidFindBy(id = "username")
    @iOSXCUITFindBy(id = "loginBtn")
    private MobileElement userIDTxtBox;

    @AndroidFindBy(id = "passwrd")
    @iOSXCUITFindBy(id = "passwrd")
    private MobileElement passwordTxtBox;
    
    @AndroidFindBy(id = "loginBtn")
    @iOSXCUITFindBy(id = "loginBtn")
    private MobileElement loginBtn;
    
    @AndroidFindBy(id = "forgotPWLink")
    @iOSXCUITFindBy(id = "forgotPWLink")
    private MobileElement forgotPasswordLink;

    public void loginToApp(String username,String password) {
    	userIDTxtBox.sendKeys(username);
    	passwordTxtBox.sendKeys(password);
    	loginBtn.click();

    }
    
    public boolean isforgotPassLinkDisplayed() {
    	return isElementDisplayed(forgotPasswordLink);
    }

}
