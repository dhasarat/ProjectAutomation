package com.schrack.sfsAutomation.pages;

import java.util.LinkedHashMap;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "uit_login_userNameEntry")
    @iOSXCUITFindBy(accessibility = "uit_login_userNameEntry")
    private MobileElement userNameTxtBox;

    @AndroidFindBy(accessibility = "uit_login_userNameLabel")
    @iOSXCUITFindBy(accessibility = "uit_login_userNameLabel")
    private MobileElement userNameTxtBoxLabel;

    @AndroidFindBy(accessibility = "uit_login_passwordEntry")
    @iOSXCUITFindBy(accessibility = "uit_login_passwordEntry")
    private MobileElement passwordTxtBox;

    @AndroidFindBy(accessibility = "uit_login_passwordLabel")
    @iOSXCUITFindBy(accessibility = "uit_login_passwordLabel")
    private MobileElement passwordTxtBoxLabel;

    @AndroidFindBy(accessibility = "uit_login_loginBtn")
    @iOSXCUITFindBy(accessibility = "uit_login_loginBtn")
    private MobileElement loginBtn;

    @AndroidFindBy(accessibility = "uit_login_forgotPwdBtn")
    @iOSXCUITFindBy(accessibility = "uit_login_forgotPwdBtn")
    private MobileElement forgotPasswordLink;

    @AndroidFindBy(accessibility = "uit_login_registerBtn")
    @iOSXCUITFindBy(accessibility = "uit_login_registerBtn")
    private MobileElement registrationLink;

    @AndroidFindBy(accessibility = "uit_login_infoTextLbl")
    @iOSXCUITFindBy(accessibility = "uit_login_infoTextLbl")
    private MobileElement infoMsgLoginPage;

    @AndroidFindBy(accessibility = "uit_login_schrackLogo")
    @iOSXCUITFindBy(accessibility = "uit_login_schrackLogo")
    private MobileElement schrackLogo;

    @AndroidFindBy(accessibility = "uit_register_showPasswordIcon")
    @iOSXCUITFindBy(accessibility = "uit_register_showPasswordIcon")
    private MobileElement showPasswordIcon;

    @AndroidFindBy(accessibility = "uit_login_userNameError")
    @iOSXCUITFindBy(accessibility = "uit_login_userNameError")
    private MobileElement errorMsgUserName;

    @AndroidFindBy(accessibility = "uit_login_passwordError")
    @iOSXCUITFindBy(accessibility = "uit_login_passwordError")
    private MobileElement errorMsgPassword;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_login_loginDataError'][@text='Wrong email or password!']")
    @iOSXCUITFindBy(accessibility = "uit_login_loginDataError")
    private MobileElement errorWrongEmailOrPassword;

    // --- Method to login to App ---//
    public StudyPlatformPage loginToApp(String userName, String password) {
        sendKeys(userNameTxtBox, userName);
        Log.info("Username is entered.");
        sendKeys(passwordTxtBox, password);
        Log.info("Password is entered");
        click(loginBtn);
        Log.info("login button is clicked.");
        return new StudyPlatformPage();
    }

    public LinkedHashMap<String, String> loginPageLabelsAndErrMgs() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        waitForElementToBeClickable(userNameTxtBoxLabel);
        map.put("usernameLabel", userNameTxtBoxLabel.getText());
        map.put("passwordLabel", passwordTxtBoxLabel.getText());
        map.put("loginBtnLabel", loginBtn.getText());
        map.put("forgotPassLabel", forgotPasswordLink.getText());
        map.put("registrationLabel", registrationLink.getText());
        click(userNameTxtBox);
        click(passwordTxtBox);
        waitForElementToBeClickable(errorMsgUserName);
        click(userNameTxtBox);
        waitForElementToBeClickable(errorMsgPassword);
        map.put("errUserName", getTextOfElement(errorMsgUserName));
        map.put("errPassword", getTextOfElement(errorMsgPassword));
        sendKeys(userNameTxtBox, "asdhsjs");
        sendKeys(passwordTxtBox, "Password");
        click(loginBtn);
        waitForElementToBeClickable(errorWrongEmailOrPassword);
        map.put("errInvalidUser", getTextOfElement(errorWrongEmailOrPassword));
        return map;
    }

    public boolean isforgotPassLinkDisplayed() {
        waitForElementToBeVisible(forgotPasswordLink);
        return isElementDisplayed(forgotPasswordLink);
    }

    public boolean isRegistrationLinkDisplayed() {
        waitForElementToBeVisible(registrationLink);
        return isElementDisplayed(registrationLink);
    }

    public boolean isLoginButtonEnabled() {
        boolean isEnabled = false;
        String value = loginBtn.getAttribute("enabled");
        if (value.equalsIgnoreCase("true"))
            isEnabled = true;
        return isEnabled;
    }

}
