package com.schrack.sfsAutomation.pages;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class ForgotPasswordPage extends BasePage {

    @AndroidFindBy(accessibility = "uit_login_forgotPwdBtn")
    @iOSXCUITFindBy(accessibility = "uit_login_forgotPwdBtn")
    private MobileElement ForgotPasswordLink_LoginPage;
    
    @AndroidFindBy(xpath = ".//android.widget.TextView[@text='Reset Password']")
    @iOSXCUITFindBy(xpath = "(//*[@name='Reset Password'])[1]")
    private MobileElement resetPasswordHeadingPopUp;

    @AndroidFindBy(accessibility = "uit_reset_closeBtnImage")
    @iOSXCUITFindBy(accessibility = "uit_reset_closeBtnImage")
    private MobileElement closeResetPasswordPopUp;

    @AndroidFindBy(accessibility = ".//android.widget.TextView[@text='Nickname*']")
    @iOSXCUITFindBy(xpath = ".//*[@name='Nickname*']")
    private MobileElement nickNameTextBoxLabel;

    @AndroidFindBy(accessibility = "uit_reset_nicknameEntry")
    @iOSXCUITFindBy(accessibility = "uit_reset_nicknameEntry")
    private MobileElement nickNameTextBox;

    @AndroidFindBy(accessibility = "uit_reset_emailLabel")
    @iOSXCUITFindBy(xpath = ".//*[@name='uit_reset_emailLabel']")
    private MobileElement emailIdTextBoxLabel;

    @AndroidFindBy(accessibility = "uit_reset_emailEntry")
    @iOSXCUITFindBy(accessibility = "uit_reset_emailEntry_Container")
    private MobileElement emailIdTextBox;

    @AndroidFindBy(accessibility = "uit_reset_resetBtn")
    @iOSXCUITFindBy(accessibility = "uit_reset_resetBtn")
    private MobileElement resetPasswordButton;

    @AndroidFindBy(accessibility = "uit_reset_nicknameError")
    @iOSXCUITFindBy(accessibility = "uit_reset_nicknameError")
    private MobileElement errorNickName;

    @AndroidFindBy(accessibility = "uit_reset_emailError")
    @iOSXCUITFindBy(accessibility = "uit_reset_emailError")
    private MobileElement errorEmailIDField;

    @AndroidFindBy(accessibility = "uit_reset_resetDataError")
    @iOSXCUITFindBy(accessibility = "uit_reset_resetDataError")
    private MobileElement errorInvalidUser;

    @AndroidFindBy(accessibility = "uit_reset_resetSuccessMessage")
    @iOSXCUITFindBy(accessibility = "uit_reset_resetSuccessMessage")
    private MobileElement successMsgResetPassword;

    public void clickForgotPasswordLink() {
        click(ForgotPasswordLink_LoginPage);
    }
    
    // Reset Password heading label
    public String resetPasswordLabel() {
        return resetPasswordHeadingPopUp.getText();
    }

    // Nickname label
    public String nickNameLabel() {
        return nickNameTextBoxLabel.getText();
    }

    // emailID label
    public String emailIDLabel() {
        return nickNameTextBoxLabel.getText();
    }

    //Is Reset password button enabled?
    public boolean isResetPasswordBtnEnabled() {
        boolean flag = true;
        if (resetPasswordButton.getAttribute("enabled").equalsIgnoreCase("false"))
            flag = false;

        return flag;
    }

    // Get Nickname error message
    public String getNickNameErrMsg() {
        click(ForgotPasswordLink_LoginPage);
        click(nickNameTextBox);
        click(emailIdTextBox);
        waitForElementToBeClickable(errorNickName);
        String errMsg = errorNickName.getText();
        System.out.println("Nickname err: "+errMsg);
        click(closeResetPasswordPopUp);
        return errMsg;
    }

    // Get EmailID error message
    public String getEmailIDErrMsg() {
        waitForElementToBeClickable(ForgotPasswordLink_LoginPage);
        click(ForgotPasswordLink_LoginPage);
        click(emailIdTextBox);
        click(nickNameTextBox);
        waitForElementToBeClickable(errorEmailIDField);
        String errMsg = errorEmailIDField.getText();
        System.out.println("email ID err: "+errMsg);
        click(closeResetPasswordPopUp);
        return errMsg;
    }

    // Invalid error message
    public String getInvalidUserErrMsg() {
        waitForElementToBeClickable(ForgotPasswordLink_LoginPage);
        click(ForgotPasswordLink_LoginPage);
        sendKeys(nickNameTextBox, "absd");
        sendKeys(emailIdTextBox, "emailsajd@yopmail.com");
        click(resetPasswordButton);
        waitForElementToBeClickable(errorInvalidUser);
        String errMsg = errorInvalidUser.getText();
        System.out.println("invalid user err: "+errMsg);
        click(closeResetPasswordPopUp);
        return errMsg;
    }

    // Wrong email id message
    public String getWrongEmailIDErrMsg() {
        waitForElementToBeClickable(ForgotPasswordLink_LoginPage);
        click(ForgotPasswordLink_LoginPage);
        click(emailIdTextBox);
        sendKeys(emailIdTextBox, "emailasdsafa");
        click(nickNameTextBox);
        waitForElementToBeClickable(errorEmailIDField);
        String errMsg = errorEmailIDField.getText();
        System.out.println("wrong emailid err: "+errMsg);
        click(closeResetPasswordPopUp);
        return errMsg;
    }

    // successful reset password
    public String resetPassword(String nickname, String emailID) {
        waitForElementToBeClickable(ForgotPasswordLink_LoginPage);
        click(ForgotPasswordLink_LoginPage);
        sendKeys(nickNameTextBox, nickname);
        sendKeys(emailIdTextBox, emailID);
        click(resetPasswordButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String successMsg = successMsgResetPassword.getText();
        System.out.println("success msg: "+successMsg);
        click(closeResetPasswordPopUp);
        return successMsg;
    }
    
 
}
