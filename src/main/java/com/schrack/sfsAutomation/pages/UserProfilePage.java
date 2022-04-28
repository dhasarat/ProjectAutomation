package com.schrack.sfsAutomation.pages;

import java.util.List;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class UserProfilePage extends BasePage {

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement hamBurgerMenuOption;

    @AndroidFindBy(accessibility = "uit_hamburger_profilepcic_Container")
    @iOSXCUITFindBy(accessibility = "uit_hamburger_profilepcic_Container")
    private MobileElement userProfileOption;

    @AndroidFindBy(accessibility = "uit_myaccount_changeProfileLabel")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_changeProfileLabel")
    private MobileElement changeProfilePicBtn;

    @AndroidFindBy(accessibility = "uit_myaccount_firstnameEntry")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_firstnameEntry")
    private MobileElement firstNameField;

    @AndroidFindBy(accessibility = "uit_myaccount_lastnameEntry")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_lastnameEntry")
    private MobileElement nickNameField;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_myaccount_nicknameFrame']//android.widget.TextView")
    private MobileElement userNameField;

    @AndroidFindBy(accessibility = "uit_myaccount_pickerImage")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_pickerImage")
    private MobileElement schoolNameField;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_myaccount_schoolNamePicker_Container']/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_pickerImage")
    private MobileElement schoolNameTextInField;

    @AndroidFindBy(xpath = ".//*[@resource-id='android:id/text1']")
    @iOSXCUITFindBy(xpath = ".//*[@type='XCUIElementTypePickerWheel']")
    private List<MobileElement> schoolPickerWheel;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_myaccount_emailFrame']//android.widget.TextView")
    private MobileElement emailIDField;

    @AndroidFindBy(accessibility = "uit_myaccount_changePwdLabel")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_changePwdLabel")
    private MobileElement updateProfileBtn;

    @AndroidFindBy(accessibility = "uit_myaccount_headingLabel")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_headingLabel")
    private MobileElement userProfilePageLabel;

    @AndroidFindBy(accessibility = "uit_myaccount_closeBtnImage")
    @iOSXCUITFindBy(accessibility = "uit_myaccount_closeBtnImage")
    private MobileElement backBtnUserProfilePage;

    @AndroidFindBy(xpath = ".//android.widget.Button[contains(@text,'Passwort ')]")
    private MobileElement resetPasswordBtn;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_reset_closeBtnImage']/../*[contains(@text,'Passwort ändern')]")
    private MobileElement resetPasswordTitle_Popup;

    @AndroidFindBy(accessibility = "uit_changePassword_CurrentPassEntry_Container")
    @iOSXCUITFindBy(accessibility = "uit_changePassword_CurrentPassEntry_Container")
    private MobileElement currentPassField_ResetPassPopUp;

    @AndroidFindBy(accessibility = "uit_changePassword_newPassEntry")
    @iOSXCUITFindBy(accessibility = "uit_changePassword_newPassEntry")
    private MobileElement newPassField_ResetPassPopUp;

    @AndroidFindBy(accessibility = "uit_changePassword_reEnterPassEntry")
    @iOSXCUITFindBy(accessibility = "uit_changePassword_reEnterPassEntry")
    private MobileElement repeatNewPassField_ResetPassPopUp;

    @AndroidFindBy(accessibility = "uit_changePassword_Btn")
    @iOSXCUITFindBy(accessibility = "uit_changePassword_Btn")
    private MobileElement resetPassBtn_ResetPassPopUp;

    @AndroidFindBy(accessibility = "uit_reset_closeBtnImage")
    @iOSXCUITFindBy(accessibility = "uit_reset_closeBtnImage")
    private MobileElement closeBtn_ResetPassPopUp;

    /*
     * Page Methods
     */
    public boolean isUserProfileScreenDisplayed() {
        boolean flag = false;
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        if (isElementDisplayed(userProfilePageLabel) && isElementDisplayed(firstNameField)
                && isElementDisplayed(nickNameField) && isElementDisplayed(schoolNameField)
                && isElementDisplayed(resetPasswordBtn)) {
            flag = true;
        }
        return flag;

    }

    // Method to update user's first name
    public boolean updateFirstName(String firstName) {
        boolean flag = false;
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        sendKeys(firstNameField, firstName);
        click(updateProfileBtn, "Update profile button is clicked.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnUserProfilePage, "back button is clicked from user profile page.");
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        String firstNameInField = getTextOfElement(firstNameField);

        if (firstNameInField.equalsIgnoreCase(firstName)) {
            flag = true;
        }
        click(backBtnUserProfilePage);
        return flag;
    }

    // Method to update user's nick name
    public boolean updateNickName(String nickName) {
        boolean flag = false;
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        sendKeys(nickNameField, nickName);
        click(updateProfileBtn, "Update profile button is clicked.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnUserProfilePage, "back button is clicked from user profile page.");
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        String nickNameInField = getTextOfElement(nickNameField);

        if (nickNameInField.equalsIgnoreCase(nickName)) {
            flag = true;
        }
        click(backBtnUserProfilePage);
        return flag;
    }

    // Method to update user's school name
    public boolean updateSchoolName(String schoolName) {
        boolean flag = false;
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        click(schoolNameField);
        for (MobileElement el : schoolPickerWheel) {
            if (el.getText().equalsIgnoreCase(schoolName)) {
                el.click();
                break;
            }
        }
        click(updateProfileBtn, "Update profile button is clicked.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnUserProfilePage, "back button is clicked from user profile page.");
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        waitForElementToBeVisible(schoolNameTextInField);
        String schoolNameInField = getTextOfElement(schoolNameTextInField);
        System.out.println("School name in field: " + schoolNameTextInField);

        if (schoolNameInField.equalsIgnoreCase(schoolName)) {
            flag = true;
        }
        click(backBtnUserProfilePage);
        return flag;
    }

    // Method to validate reset password feature
    public boolean resetPasswordFeature() {
        boolean flag = false;
        click(hamBurgerMenuOption, "Hamburger menu option is clicked.");
        click(userProfileOption, "User profile option is clicked.");
        scrollDown();
        click(resetPasswordBtn);
        if (isElementDisplayed(resetPasswordTitle_Popup) && isElementDisplayed(currentPassField_ResetPassPopUp)
                && isElementDisplayed(newPassField_ResetPassPopUp)
                && isElementDisplayed(repeatNewPassField_ResetPassPopUp)
                && isElementDisplayed(resetPassBtn_ResetPassPopUp)) {
            flag = true;
        }
        click(closeBtn_ResetPassPopUp);
        click(backBtnUserProfilePage);
        return flag;
    }

}
