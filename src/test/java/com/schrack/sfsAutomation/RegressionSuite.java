package com.schrack.sfsAutomation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.JavaUtil;

@LazyCompMobile
public class RegressionSuite extends BaseTest_Mobile {

    @Autowired
    LinkedHashMap<String, String> getLoginUsers;

    @Autowired
    LinkedHashMap<String, String> getLoginPageData;

    @Autowired
    LinkedHashMap<String, String> getForgotPasswordPageData;

    String validSearchKeyword = "mit";
    String invalidSearchKeyword = "ashdsdf";

    Faker faker = new Faker();

    @Test(priority = 0, groups = {
            "LoginPageTests" }, description = "TC#1 Test to validate the links present on login page.")
    public void LinksValidation_LoginPage() {
        startTest("TC#1 Login Page Test - Link Validations");
        Assert.assertTrue(page.getLoginPage().isforgotPassLinkDisplayed(), "Forgot Password link is not displayed.");
        log("Forgot Password link is displayed.");
        Assert.assertTrue(page.getLoginPage().isRegistrationLinkDisplayed(), "Registration Link is not displayed.");
        log("Registration link is displayed.");
        Assert.assertFalse(page.getLoginPage().isLoginButtonEnabled(),
                "Login button is enabled without filling username and password");
        log("Login button is not enabled.");
    }

    @Test(priority = 1, groups = { "LoginPageTests" }, description = "TC#2 Test to validate the labels on login page")
    public void LabelsValidation_LoginPage() {
        startTest("TC#2 Login Page Test - Lables Validations");
        softAssert.assertTrue(JavaUtil.areEqual(page.getLoginPage().loginPageLabelsAndErrMgs(), getLoginPageData),
                "Label is incorrect.");
    }

    @Test(priority = 2, groups = {
            "LoginPageTests" }, description = "TC#3 Test to validate the login function of the application.")
    public void loginToApp() {
        startTest("TC#3 Login Page Test - Login to App");
        page.getLoginPage().loginToApp(getLoginUsers.get("username"), getLoginUsers.get("password"));
        Assert.assertTrue(page.getStudyPlatformPage().isDownloadPopUpDisplayed(), "User is not logged in...!!!");
    }

    @Test(priority = 3, groups = {
            "StudyPlatformTests" }, description = "TC#4 Test to validate all the book download pop ups and close them.")
    public void closeDownloadPopUp() {
        startTest("TC#4 Study Platform Tests - Close Download Book Pop Up");
        page.getStudyPlatformPage().closeDownloadPopUp();

    }

    @Test(priority = 4, groups = {
            "StudyPlatformTests" }, description = "TC#5 Test to download all the available books")
    public void downloadAllBooks() throws InterruptedException {
        startTest("TC#5 Study Platform Tests - Download available books");
        // int numOfBooks = page.getStudyPlatformPage().getAllBooks();
        page.getStudyPlatformPage().downloadAllBooks(1);

    }

    @Test(priority = 5, groups = {
            "StudyPlatformTests" }, description = "TC#6 Test to validate index of all the downloaded books")
    public void verifyIndexOfEachBook() {
         //page.getStudyPlatformPage().verifyIndexOfABook();
    }

    @Test(priority = 6, groups = {
            "StudyPlatformTests" }, description = "TC#7 Test to validate search functionality in books tab")
    public void verifySearchInBooksTab() {
        startTest("TC#7 Study Platform Tests - search functionality in books tab");
        Assert.assertTrue(page.getStudyPlatformPage().searchInBooksTab(validSearchKeyword),
                "Search in Books tab is not working.");

    }

    @Test(priority = 7, groups = {
            "StudyPlatformTests" }, description = "TC#8 Test to validate search functionality using filters.")
    public void verifySearchInBooksTab_Filters() {
        startTest("TC#8 Study Platform Tests - search functionality using filters");
        Assert.assertTrue(page.getStudyPlatformPage().searchWithFilters(validSearchKeyword, "Elektro"),
                "Search in books tab(with filter) is not working.");
    }

    @Test(priority = 8, groups = {
            "StudyPlatformTests" }, description = "TC#9 Test to validate search functionality inside a book.")
    public void verifySearchInsideBook() {
        startTest("TC#9 Study Platform Tests - search functionality inside a book.");
        Assert.assertTrue(page.getStudyPlatformPage().searchInsideABook(validSearchKeyword),
                "Search inside a book is not working.");
    }

    @Test(priority = 9, groups = {
            "StudyPlatformTests" }, description = "TC#10 Test to validate search functionality inside a book(No Results found).")
    public void verifySearchInsideBook_NoSearchResults() {
        startTest("TC#10 Study Platform Tests - search functionality inside a book(No Results found)");
        Assert.assertTrue(page.getStudyPlatformPage().searchInsideABook_NoSearchResults(invalidSearchKeyword),
                "Search inside a book is not working(No Results Found).");
    }

    @Test(priority = 10, groups = { "Tutorials" }, description = "TC#11 Test Tutorial section")
    public void verifyTutorialsTab() {
        startTest("TC#11 Tutorials Page Test - Verify Tutorials Tab");
        page.getCommonPage().clickStudyPlatformTab();
        Assert.assertTrue(page.getTutorialsPage().isTutorialTabDisplayed(), "Tutorials Tab is not displayed.");
    }

    @Test(priority = 11, groups = { "Tutorials" }, description = "TC#12 Verify Tutorial Topics")
    public void verifyTutorialsTopics() {
        startTest("TC#12 Tutorials Page Test - Verify Tutorials Topics");
        page.getCommonPage().clickStudyPlatformTab();
        page.getTutorialsPage().getTutorialTopics();
    }

    @Test(priority = 12, groups = { "Tutorials" }, description = "TC#13 Verify Tutorial Topics")
    public void verifySearchInTutorials() throws InterruptedException {
        startTest("TC#13 Tutorials Page Test - Verify Search in Tutorials Tab");
        Assert.assertTrue(page.getTutorialsPage().searchInTutorials("mit"), "Search in Tutorials is not working.");
    }

    @Test(priority = 13, groups = { "Tutorials" }, description = "TC#14 Verify Tutorial Topics")
    public void verifyNoSearchResultsFoundTutorials() throws InterruptedException {
        startTest("TC#14 Tutorials Page Test - Verify Search feature when no search results are found");
        Assert.assertTrue(page.getTutorialsPage().noSearchResultsInTutorials("mitsasa"),
                "Search(No Results Found) in Tutorials is not working.");
    }

    @Test(priority = 14, groups = { "StudyNotesTests" }, description = "TC#15 Test to validate Study Notes page")
    public void verifyStudyNotesPage() {
        startTest("TC#15 Study Notes Tests - Verify Study Notes page");
        page.getCommonPage().clickStudyNotesTab();
        Assert.assertTrue(page.getStudyNotesPage().verifyRootFolder(), "Root Folder is not present.");
        page.getStudyNotesPage().deleteTestFiles();
    }

    @Test(priority = 15, groups = {
            "StudyNotesTests" }, description = "TC#16 Test to create a new folder in study notes")
    public void createANewFolder() {
        startTest("TC#16 Study Notes Tests - Create a new folder");
        Assert.assertTrue(page.getStudyNotesPage().addANewFolder("test folder"), "New Folder is not created.");
    }

    @Test(priority = 16, groups = {
            "StudyNotesTests" }, description = "TC#17 Test to create a new notes in study notes")
    public void createANewFile() {
        startTest("TC#17 Study Notes Tests - Create a new file");
        Assert.assertTrue(page.getStudyNotesPage().addANewNotes("test notes"), "New Folder is not created.");
    }

    @Test(priority = 17, groups = { "StudyNotesTests" }, description = "TC#18 Test to rename a file in study notes")
    public void renameAFile() {
        startTest("TC#18 Study Notes Tests - rename a file in study notes");
        Assert.assertTrue(page.getStudyNotesPage().verifyRenameFeature("test notes"), "File has not been renamed.");
    }

    @Test(priority = 18, groups = {
            "StudyNotesTests" }, description = "TC#19 Test to copy a file in root folder in study notes")
    public void copyAFileInRootFolder() {
        startTest("TC#19 Study Notes Tests - copy a file in root folder in study notes");
        Assert.assertTrue(page.getStudyNotesPage().copyAfileInRootFolder("test notes 123"),
                "File has not been copied to the root folder");
    }

    @Test(priority = 19, groups = { "StudyNotesTests" }, description = "TC#20 Test to copy a file in study notes")
    public void copyAFile() {
        startTest("TC#20 Study Notes Tests - copy a file in study notes");
        Assert.assertTrue(page.getStudyNotesPage().copyAfile("test notes 123", "test folder"),
                "File has not been copied.");
    }

    @Test(priority = 20, groups = {
            "StudyNotesTests" }, description = "TC#21 Test to delete multiple files in study notes")
    public void deleteMultipleFiles() {
        startTest("TC#21 Study Notes Tests - delete multiple files in study notes");
        Assert.assertTrue(page.getStudyNotesPage().deleteMultipleFiles(), "Files has not been deleted.");
    }

    @Test(priority = 21, groups = {
            "StudyNotesTests" }, description = "TC#22 Test to copy multiple folders in study notes")
    public void copyMultipleFolders() {
        startTest("TC#22 Study Notes Tests - copy multiple folders in study notes");
        Assert.assertTrue(page.getStudyNotesPage().copyMultipleFolders("test folder"), "Folders have not been copied.");
    }

    @Test(priority = 22, groups = {
            "StudyNotesTests" }, description = "TC#23 Test to copy multiple folders in study notes")
    public void moveMultipleFilesAndFolders() {
        startTest("TC#23 Study Notes Tests - move multiple files and folders in study notes");
        Assert.assertTrue(page.getStudyNotesPage().moveFilesAndFolders(), "Folders and files have not been moved.");
    }

    @Test(priority = 23, groups = {
            "StudyNotesTests" }, description = "TC#24 Test to copy multiple folders in study notes")
    public void searchInStudyNotes() {
        startTest("TC#24 Study Notes Tests - Search functionality in study notes");
        Assert.assertTrue(page.getStudyNotesPage().searchInNotes("test"), "Search is not working in study notes.");
    }

    @Test(priority = 24, groups = {
            "StudyNotesTests" }, description = "TC#25 Test to copy multiple folders in study notes")
    public void searchInStudyNotes_NoSearchResultsFound() {
        startTest("TC#25 Study Notes Tests - Search functionality in study notes(No Search Results Found)");
        Assert.assertTrue(page.getStudyNotesPage().noSearchResultsInNotes("asdasda"),
                "Search is not working in study notes.(No Search Results Found)");
    }

    @Test(priority = 25, groups = { "StudyNotesTests" }, description = "TC#26 Test to add text in notes in study notes")
    public void addTextInStudyNotes() {
        startTest("TC#26 Study Notes Tests - Search functionality in study notes(No Search Results Found)");
        Assert.assertTrue(page.getStudyNotesPage().addTextInNotes("This is a dummy test notes."),
                "Add text in notes in study notes.");
    }

    @Test(priority = 26, groups = {
            "StudyNotesTests" }, description = "TC#27 Test to verify pdf preview in study notes")
    public void verifyPDFPreview() {
        startTest("TC#27 Study Notes Tests - Search functionality in study notes(No Search Results Found)");
        Assert.assertTrue(page.getStudyNotesPage().verifyPDFPreview("This is a dummy test notes."),
                "Add text in notes in study notes.");
    }

    @Test(priority = 27, groups = { "Chats" }, description = "TC#28 Verify Chats Tab")
    public void verifyChatsTab() {
        startTest("TC#28 Chats Tab - Verify All Chats Tab details.");
        page.getCommonPage().clickChatsTab();
        page.getChatsPage().isChatsPageDisplayed();
    }

    @Test(priority = 28, groups = { "Chats" }, description = "TC#29 Access a Question from Chats")
    public void accessAQuestionInChat() {
        startTest("TC#29 Chats Tab - Verify Question and answer in chats");
        page.getChatsPage().accessAQuestion();
        Assert.assertTrue(page.getChatsPage().typeAnswer("test answer"), "User is unable to answer the question.");
    }

    @Test(priority = 29, groups = { "Chats" }, description = "TC#30 Verify Favourite Chat feature")
    public void verifyFavouriteChat() {
        startTest("TC#30 Chats Tab - Verify favourite chat in my chats tab");
        Assert.assertTrue(page.getChatsPage().markAChatFav(), "Favourite Chat feature is not working.");
    }

    @Test(priority = 30, groups = { "Chats" }, description = "TC#31 Verify New Chat Window details")
    public void verifyNewChatWindow() {
        startTest("TC#31 Chats Tab - Verify new chats window");
        Assert.assertTrue(page.getChatsPage().createANewQuestion("Test Question"),
                "Create a new question feature is not working.");
    }

    @Test(priority = 31, groups = { "Chats" }, description = "TC#32 Verify New Chat Window details")
    public void closeChatCreatedByLoggedInUser() {
        startTest("TC#31 Chats Tab - Close chat created by logged in user");
        Assert.assertTrue(page.getChatsPage().closeChatCreatedByLoggedInUser("imatuat1"),
                "Chat could not be deleted by the user.");
    }

    @Test(priority = 32, groups = { "QnA" }, description = "TC#33 Test QnA page")
    public void verifyQnA() throws InterruptedException {
        startTest("TC#33 QnA Page Test - Verify Topics and Subtopics");
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

    @Test(priority = 33, groups = { "QnA" }, description = "TC#34 Test search feature in QnA page")
    public void verifyQnASearch() {
        startTest("TC#34 QnA Page Test - Verify Search in QnA");
        page.getQnAPage().reachHomeQnAPage();
        Assert.assertTrue(page.getQnAPage().getSearchResults("mit"), "No Search results are displayed...!!!");
    }

    @Test(priority = 34, groups = { "QnA" }, description = "TC#35 Test search feature in QnA page - no results found")
    public void verifyQnASearchWithNoResults() {
        startTest("TC#34 QnA Page Test - Verify Search in QnA - no results found");
        page.getQnAPage().reachHomeQnAPage();
        Assert.assertTrue(page.getQnAPage().noSearchResults("ansjsjs"),
                "No Search results is not working correctly...!!!");
    }

    @Test(priority = 35, groups = { "QnA" }, description = "TC#36 Test formula and image in QnA")
    public void verifyQnAFormula() {
        startTest("TC#35 QnA Page Test - Verify Formulas in QnA");
        page.getQnAPage().fromSearchResultsToHomeQnAPage();
        Assert.assertTrue(page.getQnAPage().verifyFormulaInQnA(4, 2, 5), "Formulas are not displayed.");
    }

    @Test(priority = 36, groups = { "QnA" }, description = "TC#37 Test image in QnA")
    public void verifyQnAImage() {
        startTest("TC#36 QnA Page Test - Verify images in QnA");
        page.getQnAPage().reachHomeQnAPage();
        Assert.assertTrue(page.getQnAPage().verifyImageInQnA(2, 2, 11), "Images are not displayed.");
    }

    @Test(priority = 37, groups = { "News" }, description = "TC#38 Verify News Articles in News Tab")
    public void verifyNewsPage() {
        startTest("TC#37 News Page Test - News Articles");
        page.getCommonPage().clickNewsTab();
        Assert.assertTrue(page.getNewsPage().isNewsArticlesDisplayed(), "News Article is not displayed...!!");
    }

    @Test(priority = 38, groups = { "News" }, description = "TC#39 Access Every News Articles")
    public void verifyNewsArticles() {
        startTest("TC#39 News Page Test - Testing Each News Article");
        Assert.assertTrue(page.getNewsPage().accessANewsArticle(), "News Article details are not displayed.");
    }

    @Test(priority = 39, groups = { "News" }, description = "TC#40 Test search feature in News")
    public void verifyNewsSearch() {
        startTest("TC#40 News Page Test - Verify Search feature in News");
        Assert.assertTrue(page.getNewsPage().getSearchResults("Test"), "Search is not working properly.");
        Assert.assertTrue(page.getNewsPage().isNewsHeadingDisplayed(),
                "News Tab is not displayed after clicking on back button from news article.");
    }

    @Test(priority = 40, groups = {
            "News" }, description = "TC#41 Test search feature(No Search Results Found) in News")
    public void verifyNewsSearch_NoSearchResults() {
        startTest("TC#41 News Page Test - Verify Search feature(No Search Results Found) in News");
        Assert.assertTrue(page.getNewsPage().noSearchResults("bassjs"),
                "Search(No Search Results Found) is not working properly.");
        Assert.assertTrue(page.getNewsPage().isNewsHeadingDisplayed(),
                "News Tab is not displayed after clicking on back button from Search results page.");
    }

    @Test(priority = 41, groups = { "Logout" }, description = "TC#42 Test to Log out functionality")
    public void logoutFromApp() {
        startTest("TC#42 Logout Functionality - User logs out from the app.");
        page.getMainMenuPage().clickMainMenu();
        page.getMainMenuPage().logoutFromApp();
    }

    @Test(priority = 42, groups = {
            "ForgotPassword" }, description = "TC#43 Test to Validate various error messages in forgot password functionality.")
    public void verifyErrMsgForgotPassword() {
        startTest(
                "TC#43 Forgot Password Functionality - Validation of various error messages in forgot password functionality.");
        softAssert.assertEquals(page.getForgotPassPage().getNickNameErrMsg(),
                getForgotPasswordPageData.get("nicknameErrMsg"));
        softAssert.assertEquals(page.getForgotPassPage().getEmailIDErrMsg(),
                getForgotPasswordPageData.get("emailIDErrMsg"));
        softAssert.assertEquals(page.getForgotPassPage().getWrongEmailIDErrMsg(),
                getForgotPasswordPageData.get("wrongEmailIDMsg"));
    }

    @Test(priority = 43, groups = {
            "ForgotPassword" }, description = "TC#44 Test to Validate Invalid user error msg in forgot password.")
    public void verifyInvalidUserErrMsg_ForgotPassword() {
        startTest("TC#44 Forgot Password Functionality - Invalid user error msg in forgot password.");
        Assert.assertEquals(page.getForgotPassPage().getInvalidUserErrMsg(),
                getForgotPasswordPageData.get("invalidUserErrMsg"));
    }

    @Test(priority = 44, groups = {
            "ForgotPassword" }, description = "TC#45 Test to Validate Reset Password functionality at login page")
    public void verifyForgotPassFunctionality() {
        startTest("TC#45 Forgot Password Functionality - Validation of Reset Password Link on Login page");
        String username = getForgotPasswordPageData.get("username");
        String email = getForgotPasswordPageData.get("email");
        Assert.assertEquals(page.getForgotPassPage().resetPassword(username, email),
                getForgotPasswordPageData.get("successMsg"));
    }

    @Test(priority = 45, groups = {
            "UserRegistration" }, description = "TC#46 Test to validate the user registration functionality")
    public void registerAUser() {
        String firstName = faker.name().firstName();
        String nickName = faker.name().lastName();
        String userName = faker.name().name();
        String email = faker.name().firstName() + "." + faker.name().lastName() + "@yopmail.com";
        String dob = "23-01-1990";
        String schoolName = "Arya Model";
        String password = "Password@123";

        startTest("TC#46 Registration Page Test - Register a user");
        Assert.assertTrue(page.getUserRegPage().isRegistrationPageDisplayed(), "Registration page is not displayed.");
        Assert.assertTrue(
                page.getUserRegPage().registerAUser(firstName, nickName, dob, userName, email, schoolName, password),
                "User has not successfully registered.");

    }

    @Test(priority = 46, groups = {
            "MainMenu" }, description = "TC#47 Test to validate the main menu options")
    public void verifyMainMenu() {
        startTest("TC#47 Main menu Page Test - Verify main menu options");
        softAssert.assertTrue(page.getMainMenuPage().isClickThroughDisplayed(), "ClickThrough option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isContactUSDisplayed(), "Contact US option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isAppSettingDisplayed(), "App Setting option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isAboutUsDisplayed(), "About us option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isDSGVOPageDisplayed(), "DSSGVO option is not displayed");
        softAssert.assertTrue(page.getMainMenuPage().isImpressionPageDisplayed(), "Impression option is not displayed");
    }

    @Test(priority = 47, groups = {
            "MyAccount" }, description = "TC#48 Test to validate update profile functionality - update firstname")
    public void updateFirstName() {
        String firstName = faker.name().firstName();
        startTest("TC#48 User Profile Page Test - validate update profile functionality - update firstname");
        Assert.assertTrue(page.getUserProfilePage().updateFirstName(firstName));

    }

    @Test(priority = 48, groups = {
            "MyAccount" }, description = "TC#49 Test to validate update profile functionality - update nickname")
    public void updateNickName() {
        String nickName = faker.name().lastName();
        startTest("TC#49 User Profile Page Test - validate update profile functionality - update nickname");
        Assert.assertTrue(page.getUserProfilePage().updateNickName(nickName));

    }

    @Test(priority = 49, groups = {
            "MyAccount" }, description = "TC#50 Test to validate update profile functionality - update nickname")
    public void updateSchoolName() {
        startTest("TC#50 User Profile Page Test - validate update profile functionality - update School Name");
        Assert.assertTrue(page.getUserProfilePage().updateSchoolName("BCM"));

    }

    @Test(priority = 50, groups = {
            "MyAccount" }, description = "TC#51 Test to validate update profile functionality - reset password feature")
    public void resetPasswordFeature_UserProfile() {
        startTest("TC#51 User Profile Page Test - validate reset password feature");
        Assert.assertTrue(page.getUserProfilePage().resetPasswordFeature());

    }

}
