package com.schrack.sfsAutomation.pages;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class Common extends BasePage {

    @AndroidFindBy(accessibility = "Studie")
    @iOSXCUITFindBy(accessibility = "Studie")
    private MobileElement studyPlatformTab;

    @AndroidFindBy(accessibility = "Notizen")
    @iOSXCUITFindBy(accessibility = "Notizen")
    private MobileElement studyNotesTab;

    @AndroidFindBy(accessibility = "Chats")
    @iOSXCUITFindBy(accessibility = "Chats")
    private MobileElement chatsTab;

    @AndroidFindBy(accessibility = "Beispiele")
    @iOSXCUITFindBy(accessibility = "Beispiele")
    private MobileElement qnATab;

    @AndroidFindBy(accessibility = "News")
    @iOSXCUITFindBy(accessibility = "News")
    private MobileElement newsTab;

    public void clickStudyPlatformTab() {
        click(studyPlatformTab);
    }

    public void clickStudyNotesTab() {
        click(studyNotesTab);
    }

    public void clickChatsTab() {
        click(chatsTab);
    }

    public void clickQnATab() {
        click(qnATab);
    }

    public void clickNewsTab() {
        click(newsTab);
    }

}
