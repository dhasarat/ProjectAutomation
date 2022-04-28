package com.schrack.sfsAutomation.pages;

import java.util.LinkedHashSet;
import java.util.List;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class ChatsPage extends BasePage {

    @AndroidFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement allChatsTab;

    @AndroidFindBy(accessibility = "uit_chats_myChatsHeadingLabel")
    @iOSXCUITFindBy(accessibility = "uit_chats_myChatsHeadingLabel")
    private MobileElement myChatsTab;

    @AndroidFindBy(accessibility = "uit_chats_addChatIcon")
    @iOSXCUITFindBy(accessibility = "uit_chats_addChatIcon")
    private MobileElement createNewChat;

    @AndroidFindBy(xpath = ".//*[@text='Chats']")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement chatsPageHeading;

    @AndroidFindBy(accessibility = "uit_chats_chatItemWithoutImage_questionText")
    @iOSXCUITFindBy(accessibility = "uit_chats_chatItemWithoutImage_questionText")
    private List<MobileElement> questionTextList;

    @AndroidFindBy(accessibility = "uit_chats_chatItemWithoutImage_owner")
    @iOSXCUITFindBy(accessibility = "uit_chats_chatItemWithoutImage_owner")
    private List<MobileElement> questionCreatorNameList;

    @AndroidFindBy(accessibility = "uit_chats_chatItemWithoutImage_followIcon")
    @iOSXCUITFindBy(accessibility = "uit_chats_chatItemWithoutImage_followIcon")
    private List<MobileElement> favouriteIconList;

    @AndroidFindBy(xpath = "(.//*[@content-desc = 'uit_chats_chatItemWithoutImage_followIcon'])[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_chatItemWithoutImage_followIcon")
    private MobileElement favouriteQue;

    @AndroidFindBy(accessibility = "uit_chats_chatItemWithoutImage_datePosted")
    @iOSXCUITFindBy(accessibility = "uit_chats_chatItemWithoutImage_datePosted")
    private List<MobileElement> questionDateList;

    @AndroidFindBy(accessibility = "uit_detailedChat_questionText")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_questionText")
    private MobileElement questionTextInAChatWindow;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_detailedChat_galleryIcon']/..//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_galleryIcon")
    private MobileElement answerTextBox;

    @AndroidFindBy(accessibility = "uit_detailedChat_sendIcon")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_sendIcon")
    private MobileElement sendAnswerBtn;

    @AndroidFindBy(accessibility = "uit_startChat_backButton")
    @iOSXCUITFindBy(accessibility = "uit_startChat_backButton")
    private MobileElement backBtnFromSingleChat;

    @AndroidFindBy(accessibility = "uit_register_headingLabel")
    @iOSXCUITFindBy(accessibility = "uit_register_headingLabel")
    private MobileElement chatsHeadingInSingleChat;

    @AndroidFindBy(xpath = "(.//android.widget.TextView[contains(@text,'by')])[1]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement createdByNameInSingleChat;

    @AndroidFindBy(accessibility = "uit_detailedChat_closeChatLabel")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_closeChatLabel")
    private MobileElement closeChatBtn;

    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'Achtung')]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement closeChatPopUpHeading;

    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'geschlossen')]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement closeChatPopUpInfoText;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private List<MobileElement> closeChatPopUpButtons;

    @AndroidFindBy(accessibility = "uit_startChat_titleText")
    @iOSXCUITFindBy(accessibility = "uit_startChat_titleText")
    private MobileElement newChatHeading;

    @AndroidFindBy(accessibility = "uit_startChat_editorPlaceholder")
    @iOSXCUITFindBy(accessibility = "uit_startChat_editorPlaceholder")
    private MobileElement textBox_NewChatWindow;

    @AndroidFindBy(accessibility = "uit_startChat_PostBtn")
    @iOSXCUITFindBy(accessibility = "uit_startChat_PostBtn")
    private MobileElement postChatBtn;

    @AndroidFindBy(accessibility = "uit_startChat_pictureText")
    @iOSXCUITFindBy(accessibility = "uit_startChat_pictureText")
    private MobileElement newChatPictureText;

    @AndroidFindBy(accessibility = "uit_startChat_galleryIcon")
    @iOSXCUITFindBy(accessibility = "uit_startChat_galleryIcon")
    private MobileElement addImageBtnNewChat;

    @AndroidFindBy(accessibility = "uit_startChat_closeBtnImage")
    @iOSXCUITFindBy(accessibility = "uit_startChat_closeBtnImage")
    private MobileElement closeNewChatBtn;

    @AndroidFindBy(xpath = ".//*[contains(@text,'chster')]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement closeInformativeChatPopup;

    @AndroidFindBy(xpath = ".//*[contains(@content-desc,'Image_owner')]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private List<MobileElement> chatOwnerName;

    @AndroidFindBy(accessibility = "uit_detailedChat_closeChatLabel")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_closeChatLabel")
    private MobileElement closeChatBtn_ChatOwner;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    @iOSXCUITFindBy(accessibility = "uit_chats_allChatsHeadingLabel")
    private MobileElement apply_closeChatPopUp;

    @AndroidFindBy(accessibility = "uit_detailedChat_checkedIcon")
    @iOSXCUITFindBy(accessibility = "uit_detailedChat_checkedIcon")
    private MobileElement checkedIconClosedChat;

    /*
     * Page Methods
     */

    public boolean isChatsPageDisplayed() {
        click(closeInformativeChatPopup);
        boolean flag = isElementDisplayed(chatsPageHeading);
        return flag;
    }

    public boolean isAllChatsTabDisplayed() {
        boolean flag = isElementDisplayed(allChatsTab);
        return flag;
    }

    public boolean isMyChatsTabDisplayed() {
        boolean flag = isElementDisplayed(myChatsTab);
        return flag;
    }

    public boolean isQuestionListDisplayed() {
        boolean flag = isAllListElementsDisplayed(questionTextList);
        return flag;
    }

    public boolean isCreatorNameDisplayed() {
        boolean flag = isAllListElementsDisplayed(questionCreatorNameList);
        return flag;
    }

    public boolean isFavouriteBtnDisplayed() {
        boolean flag = isAllListElementsDisplayed(favouriteIconList);
        return flag;
    }

    public boolean isDateListDisplayed() {
        boolean flag = isAllListElementsDisplayed(questionDateList);
        return flag;
    }

    public boolean accessAQuestion() {
        boolean flag = false;
        String questionText = questionTextList.get(0).getText();
        click(questionTextList.get(0));
        String questionTxtInQuestionWindow = questionTextInAChatWindow.getText();

        if (questionText.equalsIgnoreCase(questionTxtInQuestionWindow)
                && isElementDisplayed(createdByNameInSingleChat)) {
            flag = true;
        }

        return flag;
    }

    public boolean typeAnswer(String str) {
        boolean flag = false;

        sendKeys(answerTextBox, str);

        String txt = answerTextBox.getText();
        if (txt.equalsIgnoreCase(str)) {
            flag = true;
        }
        click(backBtnFromSingleChat);
        return flag;
    }

    public boolean markAChatFav() {
        boolean flag = false;

        click(myChatsTab);
        if (!isElementDisplayed(favouriteQue)) {
            click(allChatsTab);
            String queTxt = questionTextList.get(0).getText();
            click(favouriteIconList.get(0));
            click(myChatsTab);
            int i = 0;
            for (MobileElement e : questionTextList) {

                if (e.getText().equals(queTxt)) {
                    flag = true;
                    click(favouriteIconList.get(i));
                }
                i++;
            }
        } else {
            flag = isElementDisplayed(favouriteIconList.get(0));
        }
        click(allChatsTab);
        return flag;
    }

    public boolean createANewQuestion(String str) {
        boolean flag = false;
        click(createNewChat);
        sendKeys(textBox_NewChatWindow, str);
        String text = textBox_NewChatWindow.getText();
        if (isElementDisplayed(newChatHeading) && text.equals(str) && isElementDisplayed(postChatBtn)
                && isElementDisplayed(addImageBtnNewChat)) {
            flag = true;
        }
        click(closeNewChatBtn);
        return flag;
    }

    public boolean closeChatCreatedByLoggedInUser(String ownerName) {
        boolean flag = false;
        LinkedHashSet<String> articles = new LinkedHashSet<String>();
        int numOfArticles = chatOwnerName.size();
        int i = 1;
        while (i > 0) {
            articles.add(chatOwnerName.get(i - 1).getText());
            if (chatOwnerName.get(i - 1).getText().contains(ownerName)) {
                click(chatOwnerName.get(i - 1));
                break;
            }
            i++;
            if (i == numOfArticles + 1) {
                scrollDown();
                if (!articles.add(chatOwnerName.get(chatOwnerName.size() - 1).getText())) {
                    break;
                } else {
                    numOfArticles = chatOwnerName.size();
                    i = 1;
                }

            }
        }
        click(closeChatBtn_ChatOwner);
        click(apply_closeChatPopUp);
        if (isElementDisplayed(checkedIconClosedChat)) {
            flag = true;
        }

        return flag;
    }
}
