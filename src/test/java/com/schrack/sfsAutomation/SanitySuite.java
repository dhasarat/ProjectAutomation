package com.schrack.sfsAutomation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.schrack.sfsAutomation.annotations.LazyCompMobile;

@LazyCompMobile
public class SanitySuite extends BaseTest_Mobile {

    @Autowired
    LinkedHashMap<String, String> getLoginUsers;

    @Autowired
    LinkedHashMap<String, String> getLoginPageData;

    @Autowired
    LinkedHashMap<String, String> getForgotPasswordPageData;

    String validSearchKeyword = "mit";
    String invalidSearchKeyword = "ashdsdf";

    Faker faker = new Faker();

    @Test(priority = 1, groups = {
            "LoginPageTests" }, description = "TC#1 Test to validate the login function of the application.")
    public void loginToApp() {
        startTest("TC#1 Login Page Test - Login to App");
        page.getLoginPage().loginToApp(getLoginUsers.get("username"), getLoginUsers.get("password"));
        Assert.assertTrue(page.getStudyPlatformPage().isDownloadPopUpDisplayed(), "User is not logged in...!!!");
    }

    @Test(priority = 2, groups = {
            "StudyPlatformTests" }, description = "TC#2 Test to validate all the book download pop ups and close them.")
    public void closeDownloadPopUp() {
        startTest("TC#2 Study Platform Tests - Close Download Book Pop Up");
        page.getStudyPlatformPage().closeDownloadPopUp();

    }

    @Test(priority = 3, groups = {
            "StudyPlatformTests" }, description = "TC#3 Test to download all the available books")
    public void downloadAllBooks() throws InterruptedException {
        startTest("TC#3 Study Platform Tests - Download available books");
        // int numOfBooks = page.getStudyPlatformPage().getAllBooks();
        page.getStudyPlatformPage().downloadAllBooks(1);

    }

    @Test(priority = 4, groups = {
            "StudyPlatformTests" }, description = "TC#4 Test to validate search functionality in books tab")
    public void verifySearchInBooksTab() {
        startTest("TC#4 Study Platform Tests - search functionality in books tab");
        Assert.assertTrue(page.getStudyPlatformPage().searchInBooksTab(validSearchKeyword),
                "Search in Books tab is not working.");

    }

    @Test(priority = 5, groups = {
            "StudyPlatformTests" }, description = "TC#5 Test to validate search functionality using filters.")
    public void verifySearchInBooksTab_Filters() {
        startTest("TC#5 Study Platform Tests - search functionality using filters");
        Assert.assertTrue(page.getStudyPlatformPage().searchWithFilters(validSearchKeyword, "Elektro"),
                "Search in books tab(with filter) is not working.");
    }

    @Test(priority = 6, groups = {
            "StudyPlatformTests" }, description = "TC#6 Test to validate search functionality inside a book.")
    public void verifySearchInsideBook() {
        startTest("TC#6 Study Platform Tests - search functionality inside a book.");
        Assert.assertTrue(page.getStudyPlatformPage().searchInsideABook(validSearchKeyword),
                "Search inside a book is not working.");
    }

    @Test(priority = 7, groups = { "Tutorials" }, description = "TC#7 Test Tutorial section")
    public void verifyTutorialsTab() {
        startTest("TC#7 Tutorials Page Test - Verify Tutorials Tab");
        page.getCommonPage().clickStudyPlatformTab();
        Assert.assertTrue(page.getTutorialsPage().isTutorialTabDisplayed(), "Tutorials Tab is not displayed.");
    }

    @Test(priority = 8, groups = { "Tutorials" }, description = "TC#8 Verify Tutorial Topics")
    public void verifySearchInTutorials() throws InterruptedException {
        startTest("TC#8 Tutorials Page Test - Verify Search in Tutorials Tab");
        Assert.assertTrue(page.getTutorialsPage().searchInTutorials("mit"), "Search in Tutorials is not working.");
    }

    @Test(priority = 9, groups = { "StudyNotesTests" }, description = "TC#9 Test to validate Study Notes page")
    public void deleteFilesAndFolders() {
        startTest("TC#9 Study Notes Tests - Delete files and folders");
        page.getCommonPage().clickStudyNotesTab();
        page.getStudyNotesPage().deleteTestFiles();
    }

    @Test(priority = 10, groups = {
            "StudyNotesTests" }, description = "TC#10 Test to create a new folder in study notes")
    public void createANewFolderAndFile() {
        startTest("TC#10 Study Notes Tests - Create a new folder");
        Assert.assertTrue(page.getStudyNotesPage().addANewFolder("test folder"), "New Folder is not created.");
        Assert.assertTrue(page.getStudyNotesPage().addANewNotes("test notes"), "New Folder is not created.");
    }

    @Test(priority = 11, groups = { "StudyNotesTests" }, description = "TC#11 Test to rename a file in study notes")
    public void renameAFile() {
        startTest("TC#11 Study Notes Tests - rename a file in study notes");
        Assert.assertTrue(page.getStudyNotesPage().verifyRenameFeature("test notes"), "File has not been renamed.");
    }

    @Test(priority = 12, groups = { "StudyNotesTests" }, description = "TC#12 Test to copy a file in study notes")
    public void copyAFile() {
        startTest("TC#12 Study Notes Tests - copy a file in study notes");
        Assert.assertTrue(page.getStudyNotesPage().copyAfile("test notes 123", "test folder"),
                "File has not been copied.");
    }

    @Test(priority = 13, groups = {
            "StudyNotesTests" }, description = "TC#13 Test to copy multiple folders in study notes")
    public void moveMultipleFilesAndFolders() {
        startTest("TC#13 Study Notes Tests - move multiple files and folders in study notes");
        Assert.assertTrue(page.getStudyNotesPage().moveFilesAndFolders(), "Folders and files have not been moved.");
    }

    @Test(priority = 14, groups = {
            "StudyNotesTests" }, description = "TC#14 Test to copy multiple folders in study notes")
    public void searchInStudyNotes() {
        startTest("TC#14 Study Notes Tests - Search functionality in study notes");
        Assert.assertTrue(page.getStudyNotesPage().searchInNotes("test"), "Search is not working in study notes.");
    }

    @Test(priority = 15, groups = { "StudyNotesTests" }, description = "TC#15 Test to add text in notes in study notes")
    public void addTextInStudyNotes() {
        startTest("TC#15 Study Notes Tests - Search functionality in study notes(No Search Results Found)");
        Assert.assertTrue(page.getStudyNotesPage().addTextInNotes("This is a dummy test notes."),
                "Add text in notes in study notes.");
    }

    @Test(priority = 16, groups = {
            "StudyNotesTests" }, description = "TC#16 Test to verify pdf preview in study notes")
    public void verifyPDFPreview() {
        startTest("TC#16 Study Notes Tests - Search functionality in study notes(No Search Results Found)");
        Assert.assertTrue(page.getStudyNotesPage().verifyPDFPreview("This is a dummy test notes."),
                "Add text in notes in study notes.");
    }

    @Test(priority = 17, groups = { "Chats" }, description = "TC#17 Verify Chats Tab")
    public void verifyChatsTab() {
        startTest("TC#17 Chats Tab - Verify All Chats Tab details.");
        page.getCommonPage().clickChatsTab();
        page.getChatsPage().isChatsPageDisplayed();
    }

    @Test(priority = 18, groups = { "Chats" }, description = "TC#18 Access a Question from Chats")
    public void accessAQuestionInChat() {
        startTest("TC#18 Chats Tab - Verify Question and answer in chats");
        page.getChatsPage().accessAQuestion();
        Assert.assertTrue(page.getChatsPage().typeAnswer("test answer"), "User is unable to answer the question.");
    }

    @Test(priority = 19, groups = { "Chats" }, description = "TC#19 Verify New Chat Window details")
    public void verifyNewChatWindow() {
        startTest("TC#19 Chats Tab - Verify new chats window");
        Assert.assertTrue(page.getChatsPage().createANewQuestion("Test Question"),
                "Create a new question feature is not working.");
    }

    @Test(priority = 20, groups = { "QnA" }, description = "TC#20 Test QnA page")
    public void verifyQnA() throws InterruptedException {
        startTest("TC#20 QnA Page Test - Verify Topics and Subtopics");
        page.getCommonPage().clickQnATab();
        ArrayList<String> listOfTopics = page.getQnAPage().getListOfTopics();
        for (String el : listOfTopics) {
            Assert.assertTrue(!el.isEmpty(), "QnA is empty: " + el);
            log(el);
        }
        LinkedHashMap<String, ArrayList<String>> map = page.getQnAPage().getListOfSubTopics();
        for (String s : listOfTopics) {
            if (map.get(s) != null) {
                for (String str : map.get(s)) {
                    log(str);
                }
            } else {
                Assert.assertTrue(false);
            }
        }

    }

    @Test(priority = 21, groups = { "QnA" }, description = "TC#21 Test search feature in QnA page")
    public void verifyQnASearch() {
        startTest("TC#21 QnA Page Test - Verify Search in QnA");
        page.getQnAPage().reachHomeQnAPage();
        Assert.assertTrue(page.getQnAPage().getSearchResults("mit"), "No Search results are displayed...!!!");
    }

    @Test(priority = 22, groups = { "News" }, description = "TC#22 Verify News Articles in News Tab")
    public void verifyNewsPage() {
        startTest("TC#25 News Page Test - News Articles");
        page.getCommonPage().clickNewsTab();
        Assert.assertTrue(page.getNewsPage().isNewsArticlesDisplayed(), "News Article is not displayed...!!");
    }

    @Test(priority = 23, groups = { "News" }, description = "TC#23 Access Every News Articles")
    public void verifyNewsArticles() {
        startTest("TC#23 News Page Test - Testing Each News Article");
        Assert.assertTrue(page.getNewsPage().accessANewsArticle(), "News Article details are not displayed.");
    }

    @Test(priority = 24, groups = { "News" }, description = "TC#24 Test search feature in News")
    public void verifyNewsSearch() {
        startTest("TC#24 News Page Test - Verify Search feature in News");
        Assert.assertTrue(page.getNewsPage().getSearchResults("Test"), "Search is not working properly.");
        Assert.assertTrue(page.getNewsPage().isNewsHeadingDisplayed(),
                "News Tab is not displayed after clicking on back button from news article.");
    }

    @Test(priority = 25, groups = { "Logout" }, description = "TC#25 Test to Log out functionality")
    public void logoutFromApp() {
        startTest("TC#25 Logout Functionality - User logs out from the app.");
        page.getMainMenuPage().clickMainMenu();
        page.getMainMenuPage().logoutFromApp();
    }

    @Test(priority = 26, groups = {
            "ForgotPassword" }, description = "TC#26 Test to Validate Reset Password functionality at login page")
    public void verifyForgotPassFunctionality() {
        startTest("TC#26 Forgot Password Functionality - Validation of Reset Password Link on Login page");
        String username = getForgotPasswordPageData.get("username");
        String email = getForgotPasswordPageData.get("email");
        Assert.assertEquals(page.getForgotPassPage().resetPassword(username, email),
                getForgotPasswordPageData.get("successMsg"));
    }

    @Test(priority = 27, groups = {
            "UserRegistration" }, description = "TC#27 Test to validate the user registration functionality")
    public void registerAUser() {
        String firstName = faker.name().firstName();
        String nickName = faker.name().lastName();
        String userName = faker.name().name();
        String email = faker.name().firstName() + "." + faker.name().lastName() + "@yopmail.com";
        String dob = "23-01-1990";
        String schoolName = "Arya Model";
        String password = "Password@123";

        startTest("TC#27 Registration Page Test - Register a user");
        Assert.assertTrue(page.getUserRegPage().isRegistrationPageDisplayed(), "Registration page is not displayed.");
        Assert.assertTrue(
                page.getUserRegPage().registerAUser(firstName, nickName, dob, userName, email, schoolName, password),
                "User has not successfully registered.");

    }

    @Test(priority = 28, groups = { "MainMenu" }, description = "TC#28 Test to validate the main menu options")
    public void verifyMainMenu() {
        startTest("TC#28 Main menu Page Test - Verify main menu options");
        softAssert.assertTrue(page.getMainMenuPage().isClickThroughDisplayed(), "ClickThrough option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isContactUSDisplayed(), "Contact US option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isAppSettingDisplayed(), "App Setting option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isAboutUsDisplayed(), "About us option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isDSGVOPageDisplayed(), "DSSGVO option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isImpressionPageDisplayed(), "Impression option is not displayed");
    }

    @Test(priority = 29, groups = {
            "MyAccount" }, description = "TC#29 Test to validate update profile functionality - User Profile Page")
    public void updateFirstName() {
        startTest("TC#32 User Profile Page Test - validate update profile functionality - User Profile Page");
        Assert.assertTrue(page.getUserProfilePage().isUserProfileScreenDisplayed());

    }

}
