package com.schrack.sfsAutomation.pages;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

@LazyCompMobile
public class StudyPlatformPage extends BasePage {

    @Autowired
    private AppiumDriver<MobileElement> mDriver;

    // Cancel Button on download book pop up
    @AndroidFindBy(xpath = ".//android.widget.Button[contains(@text,'Abbrechen')]")
    @iOSXCUITFindBy(accessibility = "Abbrechen")
    private MobileElement cancelBtn_DownloadBookPopup;

    // OK Button on download book pop up
    @AndroidFindBy(xpath = ".//android.widget.Button[contains(@text,'Ok')]")
    @iOSXCUITFindBy(accessibility = "Ok")
    private MobileElement okBtn_DownloadBookPopup;

    // Book Title on download book pop up
    @AndroidFindBy(id = "com.schrack.schrackforstudents:id/alertTitle")
    @iOSXCUITFindBy(xpath = "(.//*[@type='XCUIElementTypeAlert']//*[@type='XCUIElementTypeStaticText'])[1]")
    private MobileElement bookTitle_DownloadBookPopup;

    @AndroidFindBy(id = "com.schrack.schrackforstudents:id/alertTitle")
    @iOSXCUITFindBy(xpath = "(.//*[@type='XCUIElementTypeAlert']//*[@type='XCUIElementTypeStaticText'])[2]")
    private MobileElement bookSubsTitle_DownloadBookPopup;

    // Study Platform button
    @AndroidFindBy(xpath = ".//*[@content-desc='Studie']/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "uit_tabbedPage_booksNavPage")
    private MobileElement studyPlatformBtn;

    // List of available books
    @AndroidFindBy(xpath = ".//*[@content-desc='uit_study_availablebookstitleLabel']")
    private List<MobileElement> listOfBooks;

    // Study platform heading
    @AndroidFindBy(xpath = ".//android.widget.TextView[contains(@text,'Studie')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Studie'])[2]")
    private MobileElement studyPlatformHeading;

    // Books Tab
    @AndroidFindBy(accessibility = "uit_study_booksheadingLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_booksheadingLabel")
    private MobileElement booksTab;

    // Tutorials Tab
    @AndroidFindBy(accessibility = "uit_study_tutorialsheadingLabel")
    @iOSXCUITFindBy(accessibility = "uit_study_tutorialsheadingLabel")
    private MobileElement tutorialsTab;

    // Search Icon
    @AndroidFindBy(accessibility = "uit_study_searchIcon")
    private MobileElement searchIcon;

    // Search Text Box
    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'search_src_text')]")
    private MobileElement searchTextBox;

    // Clear Text in Search Text Box
    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'search_close_btn')]")
    private MobileElement clearTextInSearchTxtBox;

    // Filter Icon
    @AndroidFindBy(accessibility = "uit_search_filterIcon")
    private MobileElement filterIcon;

    // Checkbox to select a book/tutorial from filter options
    @AndroidFindBy(accessibility = "uit_search_checkBoxIcon")
    private List<MobileElement> checboxFromFilter;

    // List of Book Titles on filter
    @AndroidFindBy(xpath = ".//*[@content-desc='uit_search_checkBoxIcon']/../android.widget.TextView")
    private List<MobileElement> bookTitleList_Filter;

    // OK Button on Filter option
    @AndroidFindBy(accessibility = "uit_search_applyBtn")
    private MobileElement okFromFilterModel;

    // Cancel Button on Filter option
    @AndroidFindBy(accessibility = "uit_search_cancelBtn")
    private MobileElement cancelFromFilterModel;

    // Hamburger Menu
    @AndroidFindBy(accessibility = "OK")
    private MobileElement hamBurgerMenu;

    // Download book button
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='uit_study_availablebooksdownloadImage'])[1]")
    private MobileElement downloadButtonBook;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='uit_study_availablebooksdownloadImage']")
    private List<MobileElement> downloadBookButtonList;

    // Book Installation after download completion
    @AndroidFindBy(accessibility = "uit_study_availableBooksExtractionProgress")
    private MobileElement bookInstallationLoadingIcon;

    // Book Download in progress
    @AndroidFindBy(className = "android.widget.ProgressBar")
    private MobileElement downloadInProgress;

    // Cancel Download button
    @AndroidFindBy(accessibility = "study_availablebooksCancelDownload")
    private MobileElement cancelDownload;

    // Downloaded books
    @AndroidFindBy(xpath = "//*[contains(@text,'Meine Bücher')]")
    private MobileElement downloadedBooks;

    // Non downloaded books heading with count
    @AndroidFindBy(xpath = "//*[contains(@text,'Verfügbare Bücher')]")
    private MobileElement remainingNonDownloadedBooks;

    // Arrow to collapse list of downloaded books
    @AndroidFindBy(xpath = "//*[contains(@text,'Meine Bücher')]/../*[@content-desc='uit_study_mybooksdownarrowImage']")
    private MobileElement collapseBtnDownloadedBooksList;

    // Arrow to collapse non downloaded books
    @AndroidFindBy(xpath = "//*[contains(@text,'Verfügbare Bücher')]/../*[@content-desc='uit_study_mybooksdownarrowImage']")
    private MobileElement collapseNonDownloadedBooksList;

    // List of title of Downloaded books
    @AndroidFindBy(accessibility = "uit_study_mybookstitleLabel")
    private List<MobileElement> bookTitleList_downloaded;

    // List of subtitle of Downloaded books
    @AndroidFindBy(accessibility = "uit_study_mybookssubtitleLabel")
    private List<MobileElement> bookSubTitleList_downloaded;

    // List of author of Downloaded books
    @AndroidFindBy(accessibility = "uit_study_mybooksauthorLabel")
    private List<MobileElement> bookAuthor_downloaded;

    // List of publishing info of all books
    @AndroidFindBy(accessibility = "uit_study_myBooksPublishingInfo")
    private List<MobileElement> bookPublishingInfoList_All;

    // List of version of Downloaded books
    @AndroidFindBy(accessibility = "uit_study_downloadableversionLabel")
    private List<MobileElement> bookVersionList_Downloaded;

    // Access book button
    @AndroidFindBy(accessibility = "uit_study_mybooksmoreImage")
    private List<MobileElement> accessABook_downloaded;

    @AndroidFindBy(xpath = "(//*[@content-desc='uit_study_mybooksmoreImage'])[1]")
    private MobileElement accessFirstDownloadedBook;

    @AndroidFindBy(accessibility = "uit_bookIndex_titleText")
    private MobileElement bookIndexTitleText;

    @AndroidFindBy(accessibility = "uit_bookIndex_chapterArrowImage")
    private List<MobileElement> expandChapterInIndex;

    @AndroidFindBy(xpath = ".//*[contains(@content-desc,'PageNumber')]")
    private List<MobileElement> pageNumberList;

    @AndroidFindBy(xpath = "//*[@content-desc='uit_bookIndex_chapterArrowImage']/../*[@content-desc = 'uit_bookIndex_chapterPageNumber']")
    private List<MobileElement> pageNumber_ChapterWithArrow;

    @AndroidFindBy(xpath = ".//android.widget.Button[contains(@text,'chster')]")
    private MobileElement closeBtnInfoPopUpModal;

    @FindBy(xpath = ".//p/t/t[@id='1007']")
    private MobileElement textForSelection;

    @AndroidFindBy(accessibility = "uit_book_searchBtnImage")
    private MobileElement searchIconInsideBook;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'search_src_text')]")
    private MobileElement searchTextBoxInsideBook;

    @AndroidFindBy(xpath = "(.//*[@content-desc='uit_search_globalSearchResultsList']//android.widget.TextView)[1]")
    private MobileElement firstSearchResult;

    @AndroidFindBy(xpath = ".//*[@content-desc='Clear query']")
    private MobileElement clearSearchStringFromTextBox;

    @AndroidFindBy(accessibility = "uit_bottom_titleText")
    private MobileElement bottomTitleTxt;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_search_noResultLayout']/android.widget.TextView")
    private MobileElement noSearchResultsMsg;

    @AndroidFindBy(accessibility = "uit_search_searchIcon")
    private MobileElement backBtnFromSearchResults;

    @AndroidFindBy(accessibility = "uit_book_backBtnImage")
    private MobileElement backBtnFromBook;

    /*
     * Respective Page Methods
     */
    public boolean isDownloadPopUpDisplayed() {
        waitForElementToBeClickable(cancelBtn_DownloadBookPopup);
        return isElementDisplayed(cancelBtn_DownloadBookPopup);
    }

    // Close all download book pop ups which appears after login
    public String closeDownloadPopUp() {
        String bookTitle = "";
        waitForElementToBeClickable(cancelBtn_DownloadBookPopup);

        while (isElementDisplayed(cancelBtn_DownloadBookPopup)) {
            waitForElementToBeClickable(cancelBtn_DownloadBookPopup);
            bookTitle = bookTitle_DownloadBookPopup.getText();
            cancelBtn_DownloadBookPopup.click();
            Log.info("Pop up is closed for the book : " + bookTitle);

        }
        return bookTitle;
    }

    // Method to check Study Platform Heading
    public boolean isStudyHeadingDisplayed() {
        waitForElementToBeClickable(studyPlatformHeading);
        return isElementDisplayed(studyPlatformHeading);
    }

    // Method to check Books Tab
    public boolean isBooksHeadingDisplayed() {
        waitForElementToBeClickable(booksTab);
        return isElementDisplayed(booksTab);
    }

    // Method to check Tutorial Tab
    public boolean isTutorialHeadingDisplayed() {
        waitForElementToBeClickable(tutorialsTab);
        return isElementDisplayed(tutorialsTab);
    }

    // Method to get all available books
    public int getAllBooks() {
        LinkedHashSet<String> bookNames = new LinkedHashSet<String>();
        waitForElementToBeClickable(listOfBooks.get(0));
        int numOfBooks = listOfBooks.size();
        int i = 1;
        while (i > 0) {
            bookNames.add(listOfBooks.get(i - 1).getText());
            i++;
            if (i == numOfBooks + 1) {
                scrollDown();
                if (!bookNames.add(listOfBooks.get(listOfBooks.size() - 1).getText())) {
                    break;
                } else {
                    numOfBooks = listOfBooks.size();
                    i = 1;
                }

            }
        }
        Log.info("Book Names: " + bookNames);
        return bookNames.size();

    }

    // Method to Download books
    public void downloadAllBooks(int numOfBooks) throws InterruptedException {
        int downloadedBook = 0;
        scrollUp();
        scrollUp();
        scrollUp();

        while (downloadedBook < numOfBooks) {
            if (downloadedBook < numOfBooks && !isElementDisplayed(downloadButtonBook)) {
                scrollDown();
            }
            click(downloadButtonBook);
            click(okBtn_DownloadBookPopup);
            waitForElementToBeVisible(downloadInProgress);
            int time = 0;

            while (isElementDisplayed(downloadInProgress)) {
                Thread.sleep(5000);
                time = time + 1;
                if (time == 100) {
                    break;
                }
            }
            downloadedBook++;
        }
    }

    // Search inside a book
    public boolean searchInsideABook(String str) {
        boolean flag = false;
        click(accessABook_downloaded.get(0));
        waitForElementToBeVisible(bookIndexTitleText);
        click(pageNumber_ChapterWithArrow.get(0));
        try {
            click(closeBtnInfoPopUpModal, "Search Inside a Book - Info pop up modal is clicked.");
        } catch (TimeoutException e) {
            Log.info("Search Inside Book - Info msg pop up is not displayed.");
        } catch (Exception e) {
            Log.info("Search Inside Book - Info msg pop up is not displayed.");
        }
        click(searchIconInsideBook, "Search Inside a Book - search icon is clicked.");
        sendKeys(searchTextBoxInsideBook, str);
        pressEnter();
        waitForElementToBeClickable(firstSearchResult);
        String searchResultTxt = getTextOfElement(firstSearchResult);
        click(firstSearchResult, "Search Inside a Book - first search result is clicked.");
        if (searchResultTxt.toLowerCase().contains(str.toLowerCase()) && isElementDisplayed(bottomTitleTxt)) {
            flag = true;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnFromBook, "Search Inside a Book - back button is clicked to navigate to book content.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnFromBook, "Search Inside a Book - back button is clicked again to navigate to Books Tab.");
        waitForElementToBeClickable(studyPlatformHeading);
        return flag;

    }

    // Search inside a book when no search results are found
    public boolean searchInsideABook_NoSearchResults(String str) {
        boolean flag = false;
        click(accessABook_downloaded.get(0));
        if (isElementDisplayed(bookIndexTitleText)) {
            click(pageNumber_ChapterWithArrow.get(0));
        }

        try {
            click(closeBtnInfoPopUpModal, "Search Inside a Book(no search results) - Info pop up modal is clicked.");
        } catch (TimeoutException e) {
            Log.info("Search Inside Book(no search results) - Info msg pop up is not displayed.");
        } catch (Exception e) {
            Log.info("Search Inside Book(no search results) - Info msg pop up is not displayed.");
        }
        click(searchIconInsideBook);
        sendKeys(searchTextBoxInsideBook, str);
        pressEnter();
        if (isElementDisplayed(noSearchResultsMsg)) {
            flag = true;
        }
        click(backBtnFromSearchResults, "Search Inside Book(no search results) - Back button is clicked from a book.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(backBtnFromBook, "Search Inside a Book - back button is clicked again to navigate to Books Tab.");
        waitForElementToBeClickable(studyPlatformHeading);
        return flag;

    }

    // Method to search outside of a book and in Books Tab(Search in all downloaded
    // books and tutorials)
    public boolean searchInBooksTab(String str) {
        boolean flag = false;
        click(searchIcon);
        sendKeys(searchTextBox, str);
        pressEnter();
        waitForElementToBeClickable(firstSearchResult);
        String searchResultTxt = getTextOfElement(firstSearchResult);
        click(firstSearchResult, "Search In Books Tab - first search result is clicked.");
        try {
            click(closeBtnInfoPopUpModal, "Search In a Books Tab - Info pop up modal is clicked.");
        } catch (TimeoutException e) {
            Log.info("Search In Books Tab  - Info msg pop up is not displayed.");
        } catch (Exception e) {
            Log.info("Search In Books Tab  - Info msg pop up is not displayed.");
        }
        if (isElementDisplayed(bottomTitleTxt) && searchResultTxt.toLowerCase().contains(str.toLowerCase())) {
            flag = true;
        }
        click(backBtnFromBook, "Search In Books Tab - back button is clicked from the book");
        waitForElementToBeClickable(studyPlatformHeading);
        return flag;

    }

    // Method to search using the filter
    public boolean searchWithFilters(String str, String bookName) {
        boolean flag = false;
        click(searchIcon);
        click(filterIcon);
        for (int i = 0; i < bookTitleList_Filter.size(); i++) {
            if (bookTitleList_Filter.get(i).getText().toLowerCase().contains(bookName.toLowerCase())) {
                click(checboxFromFilter.get(i));
            }
        }
        click(okFromFilterModel);
        click(searchTextBox);
        sendKeys(searchTextBox, str);
        pressEnter();
        waitForElementToBeClickable(firstSearchResult);
        String searchResultTxt = getTextOfElement(firstSearchResult);
        click(firstSearchResult);
        if (searchResultTxt.toLowerCase().contains(str.toLowerCase()) && isElementDisplayed(bottomTitleTxt)) {
            flag = true;
        }
        click(backBtnFromBook);
        waitForElementToBeClickable(studyPlatformHeading);
        return flag;
    }

}
