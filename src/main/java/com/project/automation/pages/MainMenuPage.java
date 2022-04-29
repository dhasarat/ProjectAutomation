package com.project.automation.pages;

import com.project.automation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class MainMenuPage extends BasePage {

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement menu;

   
    public void isDSGVOPageDisplayed() {
        click(menu);
    }


}
