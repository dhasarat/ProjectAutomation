package com.schrack.sfsAutomation.pages;

import java.util.List;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class UserRegistrationPage extends BasePage {

    @AndroidFindBy(accessibility = "uit_login_registerBtn")
    @iOSXCUITFindBy(accessibility = "uit_login_registerBtn")
    private MobileElement registrationLink;

    @AndroidFindBy(accessibility = "uit_register_headingLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_headingLabel")
    private MobileElement registrationHeading;

    @AndroidFindBy(accessibility = "uit_register_schrackLogo")
    @iOSXCUITFindBy(accessibility = "uit_register_schrackLogo")
    private MobileElement schrackLogo;

    @AndroidFindBy(accessibility = "uit_register_genderLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_genderLabel")
    private MobileElement genderFieldLabel;

    @AndroidFindBy(accessibility = "uit_register_maleRadioImage")
    @iOSXCUITFindBy(accessibility = "uit_register_maleRadioImage")
    private MobileElement gender_maleRadioButton;

    @AndroidFindBy(accessibility = "uit_register_maleOption")
    @iOSXCUITFindBy(accessibility = "uit_register_maleOption")
    private MobileElement gender_maleRadioButtonLabel;

    @AndroidFindBy(accessibility = "uit_register_femaleRadioImage")
    @iOSXCUITFindBy(accessibility = "uit_register_femaleRadioImage")
    private MobileElement gender_femaleRadioButton;

    @AndroidFindBy(accessibility = "uit_register_femaleOption")
    @iOSXCUITFindBy(accessibility = "uit_register_femaleOption")
    private MobileElement gender_femaleRadioButtonLabel;

    @AndroidFindBy(accessibility = "uit_register_firstNameLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_firstNameLabel")
    private MobileElement firstNameLabel;

    @AndroidFindBy(accessibility = "uit_register_firstnameEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_firstnameEntry")
    private MobileElement firstNameTextBox;

    @AndroidFindBy(accessibility = "uit_register_lastNameLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_lastNameLabel")
    private MobileElement nickNameLabel;

    @AndroidFindBy(accessibility = "uit_register_lastnameEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_lastnameEntry")
    private MobileElement nickNameTextBox;

    @AndroidFindBy(accessibility = "uit_register_birthDateLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_birthDateLabel")
    private MobileElement birthDateLabel;

    @AndroidFindBy(xpath = ".//*[@text='Select date of birth']")
    @iOSXCUITFindBy(xpath = ".//*[@value='Select date of birth']")
    private MobileElement birthDateField;

    @iOSXCUITFindBy(accessibility = "Date Picker")
    private MobileElement openCalendarForDOB;

    @iOSXCUITFindBy(accessibility = "Show year picker")
    private MobileElement selectYearOnCalForDOB;

    @iOSXCUITFindBy(xpath = "(.//*[@type='XCUIElementTypePickerWheel'])[1]")
    private MobileElement datePickWheelMonth;

    @iOSXCUITFindBy(xpath = "(.//*[@type='XCUIElementTypePickerWheel'])[2]")
    private MobileElement datePickWheelYear;

    @AndroidFindBy(xpath = ".//*[@text='Username*']")
    @iOSXCUITFindBy(accessibility = "Username*")
    private MobileElement userNameLabel;

    @AndroidFindBy(accessibility = "uit_register_nicknameEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_nicknameEntry")
    private MobileElement userNameTextBox;

    @AndroidFindBy(accessibility = "uit_register_emailLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_emailLabel")
    private MobileElement emailIDLabel;

    @AndroidFindBy(accessibility = "uit_register_emailEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_emailEntry")
    private MobileElement emailIDTextBox;

    @AndroidFindBy(accessibility = "uit_register_schoolNameLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_schoolNameLabel")
    private MobileElement schoolNameLabel;

    @AndroidFindBy(xpath = ".//*[@text='--Select School--']")
    @iOSXCUITFindBy(accessibility = "uit_register_schoolNamePicker")
    private MobileElement schoolNamePicker;

    @AndroidFindBy(xpath = ".//*[@resource-id='android:id/text1']")
    @iOSXCUITFindBy(xpath = ".//*[@type='XCUIElementTypePickerWheel']")
    private List<MobileElement> schoolPickerWheel;

    @AndroidFindBy(accessibility = "uit_register_passwordLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_passwordLabel")
    private MobileElement passwordLabel;

    @AndroidFindBy(accessibility = "uit_register_passwordEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_passwordEntry")
    private MobileElement passwordTextBox;

    @AndroidFindBy(accessibility = "uit_register_showPasswordIcon")
    @iOSXCUITFindBy(accessibility = "uit_register_showPasswordIcon")
    private MobileElement showPasswordBtn;

    @AndroidFindBy(accessibility = "uit_register_reEnterPwdLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_reEnterPwdLabel")
    private MobileElement reEnterPasswordLabel;

    @AndroidFindBy(accessibility = "uit_register_reEnterPwdEntry")
    @iOSXCUITFindBy(accessibility = "uit_register_reEnterPwdEntry")
    private MobileElement reEnterPasswordTextBox;

    @AndroidFindBy(accessibility = "uit_register_showReEnterPwdIcon")
    @iOSXCUITFindBy(accessibility = "uit_register_showReEnterPwdIcon")
    private MobileElement showReEnteredPasswordBtn;

    @AndroidFindBy(accessibility = "uit_register_tAndCCheckboxImage")
    @iOSXCUITFindBy(accessibility = "uit_register_tAndCCheckboxImage")
    private MobileElement tncCheckBox;

    @AndroidFindBy(accessibility = "uit_register_tAndCText")
    @iOSXCUITFindBy(accessibility = "uit_register_tAndCText")
    private MobileElement tncLinkText;

    @AndroidFindBy(accessibility = "uit_register_gdprCheckboxImage")
    @iOSXCUITFindBy(accessibility = "uit_register_gdprCheckboxImage")
    private MobileElement gdprCheckBox;

    @AndroidFindBy(accessibility = "uit_register_gdprText")
    @iOSXCUITFindBy(accessibility = "uit_register_gdprText")
    private MobileElement gdprLinkText;

    @AndroidFindBy(accessibility = "uit_register_privacyCheckboxImage")
    @iOSXCUITFindBy(accessibility = "uit_register_privacyCheckboxImage")
    private MobileElement privacyCheckBox;

    @AndroidFindBy(accessibility = "uit_register_privacyText")
    @iOSXCUITFindBy(accessibility = "uit_register_privacyText")
    private MobileElement privacyLinkText;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_register_registerBtn'][@enabled='false']")
    @iOSXCUITFindBy(xpath = ".//*[@name='uit_register_registerBtn'][@enabled='false']")
    private MobileElement disabledRegisterButton;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_register_registerBtn'][@enabled='true']")
    @iOSXCUITFindBy(xpath = ".//*[@name='uit_register_registerBtn'][@enabled='true']")
    private MobileElement enabledRegisterButton;

    @AndroidFindBy(accessibility = "uit_register_firstNameError")
    @iOSXCUITFindBy(xpath = ".//*[@value='Vorname muss ausgefüllt sein.']")
    private MobileElement errorBlankFirstName;

    @AndroidFindBy(accessibility = "uit_register_lastNameError")
    @iOSXCUITFindBy(xpath = ".//*[@value='Nachname muss ausgefüllt sein.']")
    private MobileElement errorBlankNickName;

    @AndroidFindBy(accessibility = "uit_register_nicknameError")
    @iOSXCUITFindBy(xpath = "//*[@value='Username wird benötigt.']")
    private MobileElement errorBlankUserName;

    @AndroidFindBy(accessibility = "uit_register_emailError")
    @iOSXCUITFindBy(xpath = "//*[@value='Email Adresse wird benötigt.']")
    private MobileElement errorBlankEmailID;

    @AndroidFindBy(accessibility = "uit_register_passwordError")
    @iOSXCUITFindBy(xpath = "//*[@value='Passwort eingeben.']")
    private MobileElement errorBlankPassword;

    @iOSXCUITFindBy(accessibility = "uit_register_firstNameError")
    private MobileElement errorFirstName;

    @iOSXCUITFindBy(accessibility = ".//*[@value='Nutzername vergeben']")
    private MobileElement errorExistingUserName;

    @iOSXCUITFindBy(xpath = ".//*[@name='Schon angemeldet?']")
    private MobileElement errorExistingEmailIDPopUp;

    @iOSXCUITFindBy(xpath = ".// XCUIElementTypeButton[@name='zum Login']")
    private MobileElement loginBtnErrorPopUp_ExistingEmailID;

    @iOSXCUITFindBy(accessibility = "cancel popup button")
    private MobileElement cancelBtnErrorPopUp_ExistingEmailID;

    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'Studie')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Studie'])[2]")
    private MobileElement studyPlatformHeading;

    public boolean isRegistrationPageDisplayed() {
        boolean flag = false;
        click(registrationLink);

        if (isElementDisplayed(registrationHeading) && isElementDisplayed(firstNameLabel)
                && isElementDisplayed(nickNameLabel))
            flag = true;
        return flag;
    }

    public boolean registerAUser(String firstName, String nickname, String dob, String username, String emailID,
            String schoolName, String password) {
        boolean flag = false;

        click(gender_maleRadioButton);
        sendKeys(firstNameTextBox, firstName);
        sendKeys(nickNameTextBox, nickname);
        // sendKeys(birthDateField, dob);
        sendKeys(userNameTextBox, username);
        sendKeys(emailIDTextBox, emailID);
        click(schoolNamePicker);
        for (MobileElement el : schoolPickerWheel) {
            if (el.getText().equalsIgnoreCase(schoolName)) {
                el.click();
                break;
            }
        }
        scrollDown();
        sendKeys(passwordTextBox, password);
        sendKeys(reEnterPasswordTextBox, password);
        click(tncCheckBox);
        click(gdprCheckBox);
        click(privacyCheckBox);
        click(enabledRegisterButton);
        waitForElementToBeClickable(studyPlatformHeading);
        if (isElementDisplayed(studyPlatformHeading)) {
            flag = true;
        }
        return flag;

    }

}
