package com.schrack.sfsAutomation.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class TutorialsPage extends BasePage {

    @AndroidFindBy(accessibility = "uit_study_tutorialsheadingLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_booksheadingLabel")
    private MobileElement tutorialsTab;

    @AndroidFindBy(accessibility = "uit_study_topicsdowntitleLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_topicsdowntitleLabel")
    private List<MobileElement> tutorialsTopics;

    @AndroidFindBy(accessibility = "uit_study_tutorialstitleLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_tutorialstitleLabel")
    private List<MobileElement> tutorialsVideoTitle;

    @AndroidFindBy(accessibility = "uit_study_tutorialsauthorLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_tutorialsauthorLabel")
    private List<MobileElement> tutorialsVideoSubTitle;

    @AndroidFindBy(accessibility = "uit_study_tutorialsbackImage")
    @iOSXCUITFindBy(accessibility = "uit_study_tutorialsbackImage")
    private MobileElement backBtn_VideoList;

    @AndroidFindBy(xpath = ".//*[@resource-id='movie_player']//android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "uit_study_booksheadingLabel")
    private MobileElement videoTitleInVideoPlayer;

    @AndroidFindBy(xpath = ".//*[@resource-id='movie_player']//android.widget.Button")
    @iOSXCUITFindBy(accessibility = "uit_study_booksheadingLabel")
    private MobileElement videoPlayBtn_VideoPlayer;

    @AndroidFindBy(accessibility = "uit_startChat_backButton")
    @iOSXCUITFindBy(accessibility = "uit_startChat_backButton")
    private MobileElement backBtnInVideoPlayer;

    @AndroidFindBy(accessibility = "uit_videoPage_videoTitle")
    @iOSXCUITFindBy(accessibility = "uit_study_booksheadingLabel")
    private MobileElement videoTitle_PlayerPage;

    @AndroidFindBy(accessibility = "uit_study_searchIcon")
    @iOSXCUITFindBy(accessibility = "uit_study_searchIcon")
    private MobileElement searchIcon_Tutorials;

    @AndroidFindBy(xpath = "(.//*[contains(@resource-id,'search_src_text')])[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement searchTextBox;

    @AndroidFindBy(accessibility = "uit_search_filterIcon")
    @iOSXCUITFindBy(accessibility = "uit_search_filterIcon")
    private MobileElement filterIcon_Tutorials;

    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'Tutorials')]/../*[@content-desc='uit_search_checkBoxIcon']")
    @iOSXCUITFindBy(accessibility = "uit_search_filterIcon")
    private MobileElement checkBoxTutorial_Filter;

    @AndroidFindBy(accessibility = "uit_search_applyBtn")
    @iOSXCUITFindBy(accessibility = "uit_search_applyBtn")
    private MobileElement applyFilterBtn_Tutorials;

    @AndroidFindBy(xpath = "(.//*[@content-desc='uit_search_globalSearchResultsList']//android.widget.TextView)[1]")
    @iOSXCUITFindBy(accessibility = "uit_search_filterIcon")
    private MobileElement firstSearchResultTitle;

    @AndroidFindBy(xpath = "//*[@content-desc='uit_search_noResultLayout']/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "uit_search_filterIcon")
    private MobileElement noSearchResultMsg;
    
    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement backBtnFromNoSearchResultsPage;

    /*
     * / Page Methods
     */

    public boolean isTutorialTabDisplayed() {
        boolean flag = isElementDisplayed(tutorialsTab);
        click(tutorialsTab);
        return flag;
    }

    public LinkedHashMap<String, ArrayList<String>> getTutorialTopics() {
        ArrayList<String> list = new ArrayList<String>();
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
        for (int i = 0; i < tutorialsTopics.size(); i++) {
            String tutorialTopic = tutorialsTopics.get(i).getText();
            click(tutorialsTopics.get(i));
            scrollUp();
            set = scrollItemsInPage(tutorialsVideoTitle);
            list.clear();
            for (String s : set) {
                list.add(s);
            }
            map.put(tutorialTopic, list);
            click(backBtn_VideoList);

        }
        System.out.println(map);

        return map;
    }

    public boolean searchInTutorials(String str) throws InterruptedException {
        boolean flag = false;
        click(searchIcon_Tutorials);
        click(filterIcon_Tutorials);
        click(checkBoxTutorial_Filter);
        click(applyFilterBtn_Tutorials);
        sendKeys(searchTextBox, str);
        pressEnter();
        Thread.sleep(200);
        click(searchTextBox);
        pressEnter();
        click(firstSearchResultTitle);
        String title = getTextOfElement(videoTitleInVideoPlayer);
        if (title.toLowerCase().contains(str.toLowerCase())) {
            flag = true;
        }
        click(backBtnInVideoPlayer);
        return flag;
    }

    public boolean noSearchResultsInTutorials(String str) throws InterruptedException {
        boolean flag = false;
        click(searchIcon_Tutorials);
        click(filterIcon_Tutorials);
        click(checkBoxTutorial_Filter);
        click(applyFilterBtn_Tutorials);
        sendKeys(searchTextBox, str);
        click(searchTextBox);
        pressEnter();
        if (isElementDisplayed(noSearchResultMsg)) {
            flag = true;
        }
        click(backBtnFromNoSearchResultsPage);
        return flag;
    }
}
