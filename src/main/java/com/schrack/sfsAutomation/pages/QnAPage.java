package com.schrack.sfsAutomation.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class QnAPage extends BasePage {

    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'.')]")
    @iOSXCUITFindBy(xpath = ".//android.widget.TextView[contains(@text,'.')]")
    private List<MobileElement> listOfQnATopics;

    @AndroidFindBy(xpath = "//button[contains(.,'Lösung')]")
    @iOSXCUITFindBy(xpath = ".//android.widget.Button[contains(@text,'Lösung Verbergen')]")
    private MobileElement hideAnswerBtn;

    @AndroidFindBy(xpath = "//button[contains(.,'Lösung')]")
    @iOSXCUITFindBy(xpath = "//android.widget.Button[contains(@text,'Lösung Anzeigen')]")
    private MobileElement showAnswerBtn;

    @AndroidFindBy(className = "android.widget.ImageButton")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private MobileElement backButton;

    @AndroidFindBy(accessibility = "qna_questioncontent_searchImage")
    @iOSXCUITFindBy(accessibility = "qna_questioncontent_searchImage")
    private MobileElement searchIcon;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'search_src_text')]")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private MobileElement searchTextBox;

    @AndroidFindBy(xpath = ".//android.widget.ImageView/../android.widget.TextView")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private List<MobileElement> searchResults;

    @AndroidFindBy(accessibility = "uit_search_noResultLayout")
    @iOSXCUITFindBy(accessibility = "uit_search_noResultLayout")
    private MobileElement noSearchResultsFound;

    @AndroidFindBy(xpath = ".//android.widget.Button/../../../android.widget.ImageView")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private List<MobileElement> accessQuestionBtn;

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement mainMenu;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_search_searchIcon']")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private MobileElement backBtnFromSearchResults;

    @AndroidFindBy(xpath = ".//android.view.View[contains(@resource-id,'MathJax-Element')]")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private List<MobileElement> formulaText;

    @AndroidFindBy(className = "android.widget.Image")
    @iOSXCUITFindBy(className = "android.widget.ImageButton")
    private List<MobileElement> imageInQnA;
    /*
     * Page Methods
     * 
     */

    public void accessAQuestion(int topicNum, int subTopicNum, int queNum) {
        click(listOfQnATopics.get(topicNum - 1));
        click(listOfQnATopics.get(subTopicNum));
        click(listOfQnATopics.get(queNum));
    }

    public ArrayList<String> getListOfTopics() {
        ArrayList<String> list = new ArrayList<String>();
        for (MobileElement elm : listOfQnATopics) {
            waitForElementToBeClickable(elm);
            list.add(elm.getText());
        }
        return list;

    }

    public LinkedHashMap<String, ArrayList<String>> getListOfSubTopics() throws InterruptedException {
        ArrayList<String> list = new ArrayList<String>();
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
        String topicName;
        for (int i = 0; i < listOfQnATopics.size(); i++) {
            waitForElementToBeClickable(listOfQnATopics.get(i));
            topicName = listOfQnATopics.get(i).getText();
            listOfQnATopics.get(i).click();

            for (int j = 1; j < listOfQnATopics.size() - 1; j++) {
                list.add(listOfQnATopics.get(j).getText());
            }
            map.put(topicName, list);
            backButton.click();
            Thread.sleep(500);
        }

        return map;

    }

    public boolean isShowAnswerBtnVisible(int topicNum, int subTopicNum, int queNum) {
        boolean flag = false;
        accessAQuestion(topicNum, subTopicNum, queNum);
        flag = isElementDisplayed(showAnswerBtn);
        return flag;
    }

    public boolean isHideAnswerBtnVisible() {
        boolean flag = false;
        waitForElementToBeClickable(showAnswerBtn);
        showAnswerBtn.click();
        flag = isElementDisplayed(hideAnswerBtn);
        return flag;
    }

    public boolean getSearchResults(String searchText) {
        boolean flag = false;
        waitForElementToBeClickable(searchIcon);
        searchIcon.click();
        sendKeys(searchTextBox, searchText);
        pressEnter();
        waitForElementToBeClickable(searchResults.get(0));
        String searchResultName = searchResults.get(0).getText();
        searchResults.get(0).click();
        if (searchResultName.contains(searchText))
            flag = true;
        return flag;
    }

    public boolean noSearchResults(String searchText) {
        boolean flag = false;
        waitForElementToBeClickable(searchIcon);
        searchIcon.click();
        sendKeys(searchTextBox, searchText);
        pressEnter();
        waitForElementToBeClickable(noSearchResultsFound);
        if (isElementDisplayed(noSearchResultsFound))
            flag = true;

        return flag;
    }

    public void reachHomeQnAPage() {
        waitForElementToBeClickable(backButton);
        while (isElementDisplayed(backButton) && !isElementDisplayed(mainMenu)) {
            click(backButton);
        }
    }

    public void fromSearchResultsToHomeQnAPage() {
        waitForElementToBeClickable(backBtnFromSearchResults);
        while (isElementDisplayed(backBtnFromSearchResults)) {
            click(backBtnFromSearchResults);
        }
    }

    public boolean verifyFormulaInQnA(int topicNum, int subTopicNum, int queNum) {
        boolean flag = true;
        accessAQuestion(topicNum, subTopicNum, queNum);
        for (MobileElement elm : formulaText) {
            flag = isElementDisplayed(elm);
            if (flag = false) {
                break;
            }
        }
        return flag;

    }

    public boolean verifyImageInQnA(int topicNum, int subTopicNum, int queNum) {
        boolean flag = true;
        accessAQuestion(topicNum, subTopicNum, queNum);
        for (MobileElement elm : imageInQnA) {
            flag = isElementDisplayed(elm);
            if (flag = false) {
                break;
            }
        }
        return flag;

    }

}
