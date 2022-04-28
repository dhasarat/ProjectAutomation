package com.schrack.sfsAutomation.pages;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class MainMenuPage extends BasePage {

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement mainMenuHamBurger;

    @AndroidFindBy(accessibility = "Clickthrough reaktivieren")
    @iOSXCUITFindBy(accessibility = "Clickthrough reaktivieren")
    private MobileElement clickThroughOption;

    @AndroidFindBy(accessibility = "App Einstellungen")
    @iOSXCUITFindBy(accessibility = "App Einstellungen")
    private MobileElement appSettingOption;

    @AndroidFindBy(accessibility = "Über uns")
    @iOSXCUITFindBy(accessibility = "Über uns")
    private MobileElement uberUnsOption;

    @AndroidFindBy(accessibility = "Kontakt")
    @iOSXCUITFindBy(accessibility = "Kontakt")
    private MobileElement contactUSOption;

    @AndroidFindBy(accessibility = "DSGVO")
    @iOSXCUITFindBy(accessibility = "DSGVO")
    private MobileElement dsgvoOption;

    @AndroidFindBy(accessibility = "Impressum")
    @iOSXCUITFindBy(accessibility = "Impressum")
    private MobileElement impressionOption;

    @AndroidFindBy(accessibility = "Abmelden")
    @iOSXCUITFindBy(accessibility = "Abmelden")
    private MobileElement logoutOption;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='Ja']")
    @iOSXCUITFindBy(accessibility = "Über uns")
    private MobileElement yesLogoutPopUp;

    @AndroidFindBy(xpath = ".//android.widget.Button[@text='Nein']")
    @iOSXCUITFindBy(accessibility = "Über uns")
    private MobileElement noLogoutPopUp;

    @AndroidFindBy(accessibility = "uit_search_searchIcon")
    @iOSXCUITFindBy(accessibility = "uit_search_searchIcon")
    private MobileElement backBtn;

    @AndroidFindBy(xpath = ".//*[@text='Über uns']")
    @iOSXCUITFindBy(xpath = ".//*[@text='Über uns']")
    private MobileElement aboutUsPageLabel;

    @AndroidFindBy(xpath = ".//*[@text='App Einstellungen']")
    @iOSXCUITFindBy(xpath = ".//*[@text='App Einstellungen']")
    private MobileElement appSettingPageLabel;

    @AndroidFindBy(xpath = ".//*[@text='DSGVO']")
    @iOSXCUITFindBy(xpath = ".//*[@text='DSGVO']")
    private MobileElement dsgvoPageLabel;

    @AndroidFindBy(xpath = ".//*[@text='Impressum']")
    @iOSXCUITFindBy(xpath = ".//*[@text='Impressum']")
    private MobileElement impressumPageLabel;

    public void clickMainMenu() {
        click(mainMenuHamBurger);
    }
    
    public void logoutFromApp() {
        click(logoutOption);
        click(yesLogoutPopUp);
    }

    public boolean isClickThroughDisplayed() {
        click(mainMenuHamBurger);
        boolean flag = isElementDisplayed(clickThroughOption);
        return flag;
    }
    
    public boolean isContactUSDisplayed() {
        boolean flag = isElementDisplayed(contactUSOption);
        return flag;
    }

    public boolean isAppSettingDisplayed() {
        boolean flag = false;
        if (isElementDisplayed(appSettingOption)) {
            click(appSettingOption);
            if (isElementDisplayed(appSettingPageLabel)) {
                flag = true;
            }
        }
        click(backBtn);
        click(mainMenuHamBurger);

        return flag;
    }

    public boolean isAboutUsDisplayed() {

        boolean flag = false;
        if (isElementDisplayed(uberUnsOption)) {
            click(uberUnsOption);
            if (isElementDisplayed(aboutUsPageLabel)) {
                flag = true;
            }
        }

        click(backBtn);
        click(mainMenuHamBurger);
        return flag;
    }

    public boolean isDSGVOPageDisplayed() {
        boolean flag = false;
        if (isElementDisplayed(dsgvoOption)) {
            click(dsgvoOption);
            if (isElementDisplayed(dsgvoPageLabel)) {
                flag = true;
            }
        }
        click(backBtn);
        click(mainMenuHamBurger);
        return flag;
    }

    public boolean isImpressionPageDisplayed() {
        boolean flag = false;
        if (isElementDisplayed(impressionOption)) {
            click(impressionOption);
            if (isElementDisplayed(impressumPageLabel)) {
                flag = true;
            }
        }
        click(backBtn);
        click(mainMenuHamBurger);
        return flag;
    }

}
