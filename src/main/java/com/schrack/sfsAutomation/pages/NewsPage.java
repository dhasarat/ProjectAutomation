package com.schrack.sfsAutomation.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class NewsPage extends BasePage {

    @Autowired
    private AppiumDriver<MobileElement> mDriver;

    @AndroidFindBy(accessibility = "uit_newsFeed_searchIcon")
    @iOSXCUITFindBy(accessibility = "uit_newsFeed_searchIcon")
    private MobileElement searchIconNews;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_newsFeed_newsArticleList']//android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private List<MobileElement> newsTitle;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_newsFeed_newsArticleList']//android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private List<MobileElement> newsSubTitle;

    @AndroidFindBy(xpath = "(.//android.widget.TextView[contains(@text,'News')])[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement newsTabHeading;

    @AndroidFindBy(xpath = "(.//*[contains(@resource-id,'search_src_text')])[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement searchTextBox;

    @AndroidFindBy(xpath = "(.//*[@content-desc='uit_search_newsArticleList_Container']//android.widget.TextView)[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement firstSearchResult;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_search_newsArticleList']//android.widget.ImageView/../android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private List<MobileElement> searchResultsList;

    @AndroidFindBy(accessibility = "uit_search_noResultLayout")
    @iOSXCUITFindBy(accessibility = "uit_search_noResultLayout")
    private MobileElement noSearchResultFound;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_search_searchIcon']")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement backBtnSearchResults;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'toolbar')]//android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement newsArticleTitle_ArticlePage;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement backBtnNewsArticles;

    @FindBy(xpath = "(.//div/p)[2]")
    private MobileElement newArticleText;

    /*
     * Page Methods
     */
    public boolean isNewsArticlesDisplayed() {
        boolean flag = true;
        LinkedHashSet<String> articles = scrollItemsInPage(newsTitle);

        for (String elm : articles) {
            if (elm.isEmpty()) {
                flag = false;
                Log.warn("News article is not present at - " + elm);
            }
        }

        return flag;
    }

    public boolean accessANewsArticle() {
        boolean flag = true;
        LinkedHashSet<String> articles = new LinkedHashSet<String>();
        HashMap<String, String> articleText = new HashMap<String, String>();
        int numOfArticles = newsTitle.size();
        int i = 1;
        while (i > 0) {
            String title = newsTitle.get(i - 1).getText();
            Log.info(title);
            articles.add(title);
            newsTitle.get(i - 1).click();
            switchToWebViewContext();
            Set<String> allWindowHandles = mDriver.getWindowHandles();
            for (String window : allWindowHandles) {
                String currentURL = mDriver.getCurrentUrl();
                if (currentURL.contains("http")) {
                    mDriver.switchTo().window(window);
                }

            }
            if (!isElementDisplayed(newArticleText)) {
                articleText.put(title, "");
            }
            switchToNativeContext();
            click(backBtnNewsArticles);
            i++;
            if (i == numOfArticles + 1) {
                scrollDown();
                if (!articles.add(newsTitle.get(newsTitle.size() - 1).getText())) {
                    break;
                } else {
                    numOfArticles = newsTitle.size();
                    i = 1;
                }

            }
        }
        if (!articleText.isEmpty()) {
            flag = false;
            System.out.println(articleText);
        }
        return flag;

    }

    public boolean getSearchResults(String searchText) {
        boolean flag = true;
        click(searchIconNews);
        sendKeys(searchTextBox, searchText);
        pressEnter();
        waitForElementToBeClickable(searchResultsList.get(0));
        String searchResultName = searchResultsList.get(0).getText();
        searchResultsList.get(0).click();
        if (!(searchResultName.contains(searchText) && isElementDisplayed(newsArticleTitle_ArticlePage))) {
            System.out.println("**** Inside IF - search results ----*******");
            flag = false;
        }
        click(backBtnNewsArticles);
        return flag;
    }

    public boolean isNewsHeadingDisplayed() {
        boolean flag = false;
        if (isElementDisplayed(newsTabHeading))
            flag = true;

        return flag;
    }

    public boolean noSearchResults(String searchText) {
        boolean flag = true;
        waitForElementToBeClickable(searchIconNews);
        searchIconNews.click();
        sendKeys(searchTextBox, searchText);
        pressEnter();
        waitForElementToBeClickable(noSearchResultFound);
        if (!isElementDisplayed(noSearchResultFound)) {
            System.out.println("**** Inside IF - No search results ----*******");
            flag = false;
        }
        click(backBtnSearchResults);
        return flag;
    }

}
