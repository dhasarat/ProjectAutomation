package com.schrack.sfsAutomation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

@LazyCompMobile
public class BasePage {
    private WebDriverWait wait;

    @Autowired
    private AppiumDriver<MobileElement> mDriver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(this.mDriver), this);
        wait = new WebDriverWait(this.mDriver, 20);

    }

    // Return MobileElement with AccessibilityID
    public MobileElement findElementByAccessibilityID(String ID) {
        return mDriver.findElementByAccessibilityId(ID);
    }

    // Return MobileElement with XPath
    public MobileElement findElementByXPath(String xpath) {
        return mDriver.findElementByXPath(xpath);
    }

    // Method to enter any text in text box
    public void sendKeys(MobileElement elm, String text) {
        waitForElementToBeClickable(elm);
        elm.clear();
        elm.sendKeys(text);
    }

    //Get text of an element
    public String getTextOfElement(MobileElement elm) {
        waitForElementToBeVisible(elm);
        String text = elm.getText();
        return text;
    }

    //Get Text of elements from a list
    public String getTextOfElement(List<MobileElement> element, int index) {
        String text = "";
        try {
            MobileElement elm = element.get(index);
            waitForElementToBeVisible(elm);
            text = elm.getText();
        } catch (Exception e) {

        }
        return text;
    }

    // Method to click on any element
    public void click(MobileElement elm) {
        waitForElementToBeClickable(elm);
        elm.click();

    }

    //Click on an element
    public void click(MobileElement elm, String msg) {
        waitForElementToBeClickable(elm);
        elm.click();
        Log.info(msg);

    }

    // Wait for an element to be clickable
    public void waitForElementToBeClickable(MobileElement elm) {
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    // Wait for an element to be visible
    public void waitForElementToBeVisible(MobileElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    //Switch to alert
    public void switchToAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        mDriver.switchTo().alert();
    }

    //Method to check if an element is displayed
    public boolean isElementDisplayed(MobileElement element) {

        try {
            return element.isDisplayed();

        } catch (Exception e) {
            // System.out.println(e);
            return false;
        }
    }

    //Method to check if elements from a list are displayed
    public boolean isElementDisplayed(List<MobileElement> element, int index) {

        try {
            MobileElement elm = element.get(index);
            return elm.isDisplayed();

        } catch (Exception e) {
            // System.out.println(e);
            return false;
        }
    }
    

    //Generic Scroll method
    public void scroll(int startx, int starty, int endx, int endy) {
        if (mDriver instanceof AndroidDriver) {
            AndroidTouchAction touch = new AndroidTouchAction(mDriver);
            touch.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release()
                    .perform();
        } else if (mDriver instanceof IOSDriver) {
            IOSTouchAction touch = new IOSTouchAction(mDriver);
            touch.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release()
                    .perform();
        }

    }

    //Long press on an element
    public void longPress(MobileElement elm) {
        if (mDriver instanceof AndroidDriver) {
            AndroidTouchAction touch = new AndroidTouchAction(mDriver);
            touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(elm))
                    .withDuration(Duration.ofSeconds(3))).release().perform();
        } else if (mDriver instanceof IOSDriver) {
            IOSTouchAction touch = new IOSTouchAction(mDriver);
            touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(elm))
                    .withDuration(Duration.ofSeconds(3))).release().perform();
        }

    }

    public void clickAndHoldWeb(WebElement elm) {
        if (mDriver instanceof AndroidDriver) {
            Actions action = new Actions(mDriver);
            action.moveToElement(elm).clickAndHold(elm).perform();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            action.release(elm).perform();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (mDriver instanceof IOSDriver) {
            Actions touch = new Actions(mDriver);
            touch.moveToElement(elm).clickAndHold().build().perform();
        }
    }

    //Scroll Down on the page
    public void scrollDown() {
        Dimension size = mDriver.manage().window().getSize();

        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = (int) size.width / 2;

        scroll(startx, starty, startx, endy);
    }

    // Scroll up on the page
    public void scrollUp() {
        Dimension size = mDriver.manage().window().getSize();

        int starty = (int) (size.height * 0.20);
        int endy = (int) (size.height * 0.80);
        int startx = (int) size.width / 2;

        scroll(startx, starty, startx, endy);
    }

    // Press Enter key
    public void pressEnter() {
        Actions action = new Actions(mDriver);
        action.sendKeys(Keys.ENTER).perform();
    }

    // Switch to web context
    public void switchToWebViewContext() {

        Set<String> contextNames = mDriver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")) {
                mDriver.context(contextName);
            }
        }

    }

    // Switch to Native Context
    public void switchToNativeContext() {
        Set<String> contextNames = mDriver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE")) {
                mDriver.context(contextName);
            }
        }

    }

    // Method to scroll items in the list
    public LinkedHashSet<String> scrollItemsInPage(List<MobileElement> elm) {
        LinkedHashSet<String> articles = new LinkedHashSet<String>();

        int numOfArticles = elm.size();
        int i = 1;
        while (i > 0) {
            articles.add(elm.get(i - 1).getText());
            i++;
            if (i == numOfArticles + 1) {
                scrollDown();
                if (!articles.add(elm.get(elm.size() - 1).getText())) {
                    break;
                } else {
                    numOfArticles = elm.size();
                    i = 1;
                }

            }
        }
        return articles;
    }

    // Method to scroll and access each item in the list
    public ArrayList<LinkedHashSet<String>> scrollAndAccessEachItemInList(List<MobileElement> elm, MobileElement e,
            MobileElement backBtn) {
        LinkedHashSet<String> articles = new LinkedHashSet<String>();
        LinkedHashSet<String> articleDetail = new LinkedHashSet<String>();
        ArrayList<LinkedHashSet<String>> list = new ArrayList<LinkedHashSet<String>>();

        int numOfArticles = elm.size();
        int i = 1;
        while (i > 0) {
            articles.add(elm.get(i - 1).getText());
            elm.get(i - 1).click();
            waitForElementToBeClickable(e);
            articleDetail.add(getTextOfElement(e));
            click(backBtn);
            i++;
            if (i == numOfArticles + 1) {
                scrollDown();
                if (!articles.add(elm.get(elm.size() - 1).getText())) {
                    break;
                } else {
                    numOfArticles = elm.size();
                    i = 1;
                }

            }
        }
        list.add(articles);
        list.add(articleDetail);
        return list;
    }

    // Method to check if all list items are displayed
    public boolean isAllListElementsDisplayed(List<MobileElement> elm) {
        boolean flag = true;
        for (MobileElement el : elm) {
            if (el.getText().isEmpty()) {
                flag = false;
            }
        }
        return flag;
    }

}
