package com.schrack.sfsAutomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

@LazyCompMobile
public class StudyNotesPage extends BasePage {

    @Autowired
    private AppiumDriver<MobileElement> mDriver;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Notizen']/android.widget.ImageView")
    private MobileElement studyNotesButton;

    @AndroidFindBy(xpath = ".//*[@text='Notizen']")
    private MobileElement studyNotesPageHeading;

    @AndroidFindBy(accessibility = "uit_notespage_add_folder_button")
    private MobileElement addNewFolderButton;

    @AndroidFindBy(accessibility = "uit_notespage_add_note_button")
    private MobileElement addNewFileButton;

    @AndroidFindBy(accessibility = "uit_notespage_folder_path_label")
    private MobileElement rootFolder;

    @AndroidFindBy(accessibility = "OK")
    private MobileElement hamBurgerMenuIcon;

    @AndroidFindBy(accessibility = "uit_notespage_item_name")
    private List<MobileElement> folderOrFileName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='uit_notespage_item_lastmodified']")
    private MobileElement lastModifiedDate;

    @AndroidFindBy(xpath = ".//*[contains(@text,'Ordner erstellen')]")
    private MobileElement addFolderPopUpHeading;

    @AndroidFindBy(xpath = ".//android.widget.EditText[contains(@text,'Ordner')]")
    private MobileElement addNewFoldertextBoxPopUp;

    @AndroidFindBy(xpath = ".//android.widget.Button[1]")
    private MobileElement closeAddFolderButton;

    @AndroidFindBy(xpath = ".//android.widget.Button[2]")
    private MobileElement AddFolderButton;

    @AndroidFindBy(xpath = ".//*[contains(@text,'Neue Notiz')]")
    private MobileElement addNewNotesPopUpHeading;

    @AndroidFindBy(xpath = ".//android.widget.EditText[contains(@text,'Notiz')]")
    private MobileElement addNewNotesTxtBox_PopUp;

    @AndroidFindBy(xpath = ".//*[contains(@text,'chster')]")
    private MobileElement closeOnInfoMsgPopUp;

    @AndroidFindBy(accessibility = "uit_notesdescription_text_checkbox")
    private MobileElement addTextBoxInStudyNotes;

    @AndroidFindBy(accessibility = "uit_notesdescription_photo_checkbox")
    private MobileElement addImageInStudyNotes;

    @AndroidFindBy(accessibility = "uit_notesdescription_PreviewIcon")
    private MobileElement pdfPreviewButton;

    @AndroidFindBy(id = "up_down_arrow")
    private MobileElement clipBoardUp_DownArrow;

    @AndroidFindBy(id = "textview_selected_book")
    private MobileElement bookNameInClipboard;

    @AndroidFindBy(id = "next_book_button")
    private MobileElement nextBookButton_Clipboard;

    @AndroidFindBy(id = "prev_book_button")
    private MobileElement prevBookButton_Clipboard;

    @AndroidFindBy(accessibility = "uit_notespage_searchIcon")
    private MobileElement searchIcon;

    @AndroidFindBy(xpath = ".//*[contains(@text,'in Notizen')]")
    private MobileElement searchTxtBox;

    @AndroidFindBy(xpath = "(.//*[@content-desc='uit_search_note_result_list']//android.widget.TextView)[1]")
    private MobileElement firstSearchResult;

    @AndroidFindBy(accessibility = "uit_search_noResultLayout")
    private MobileElement noSearchResultsMsg;

    @AndroidFindBy(accessibility = "uit_search_searchIcon")
    private MobileElement backBtn_SearchResultsPage;

    @AndroidFindBy(xpath = ".//*[@id='MathJax_Message']")
    private MobileElement textInClipboard;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'bottom_left_drop_image_view')]")
    private MobileElement leftTextBoxPosition;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'left_transparent_view')]")
    private MobileElement leftTextBox_blank;

    @AndroidFindBy(xpath = ".//*[@resource-id='menuBarDiv_txtEditor']/../android.widget.EditText")
    private MobileElement editTextBox_studyNotes;

    @AndroidFindBy(xpath = ".//android.widget.Button[contains(@text,'Hinzu')]")
    private MobileElement saveBtn_EditTextBox;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'frame')]//android.webkit.WebView/android.view.View")
    private List<MobileElement> textInsideTextBox;

    @AndroidFindBy(accessibility = "uit_notesdetailweb_downloadIcon")
    private MobileElement downloadBtn_PDFPreview;

    @AndroidFindBy(accessibility = "uit_notesdetailweb_shareIcon")
    private MobileElement shareBtn_PDFPreview;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton")
    private MobileElement backBtnFromNotesAndPDFPreview;

    @AndroidFindBy(accessibility = "uit_notespage_copy_button")
    private MobileElement copyBtn;

    @AndroidFindBy(accessibility = "uit_notespage_move_button")
    private MobileElement moveBtn;

    @AndroidFindBy(accessibility = "uit_notespage_delete_button")
    private MobileElement deleteBtn;

    @AndroidFindBy(accessibility = "uit_notespage_rename_button")
    private MobileElement renameBtn;

    @AndroidFindBy(accessibility = "uit_notespage_cross_icon")
    private MobileElement closeMenuOptionStudyNotes;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@text='Umbenennen']/../android.widget.FrameLayout//android.widget.EditText")
    private MobileElement editTextBox_RenamePopup;

    @AndroidFindBy(xpath = ".//android.widget.Button[2]")
    private MobileElement saveBtn_RenamePopup;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_notespage_folder_collectionView']//*[@content-desc='uit_notespage_item_name']")
    private List<MobileElement> folderListForCopyOrMove;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_notespage_folder_collectionView']/../android.view.ViewGroup/android.widget.ImageButton[1]")
    private MobileElement backBtn_CopyOverlay;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_notespage_folder_collectionView']/../android.view.ViewGroup/android.widget.ImageButton[2]")
    private MobileElement okBtn_CopyOverlay;

    @AndroidFindBy(xpath = ".//*[@content-desc='uit_notespage_folder_collectionView']/../android.view.ViewGroup/android.widget.ImageButton[1]")
    private MobileElement cancelBtn_CopyOverlay;

    @AndroidFindBy(accessibility = "uit_notes_item_selected_checkbox")
    private List<MobileElement> selectionCheckBox;

    @AndroidFindBy(xpath = ".//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton")
    private MobileElement backBtnFromFolder;

    @AndroidFindBy(xpath = ".//*[@resource-id='viewerContainer']")
    private MobileElement textInPDF;

    /*
     * Page Methods
     */

    public boolean verifyRootFolder() {
        boolean flag = false;
        if (rootFolder.getText().equalsIgnoreCase("Zuhause")) {
            flag = true;
            Log.info("Study Notes Page | Root folder is Displayed.");
        }
        return flag;
    }

    // Method to add a new Folder
    public boolean addANewFolder(String folderName) {
        boolean flag = false;

        click(addNewFolderButton, "Study Notes Page | Add a new folder button is clicked.");
        sendKeys(addNewFoldertextBoxPopUp, folderName);
        click(AddFolderButton);
        for (MobileElement name : folderOrFileName) {
            if (name.getText().equalsIgnoreCase(folderName)) {
                flag = true;
                Log.info("New folder has been created successfully.");
            }
        }
        return flag;

    }

    // Method to open a file or folder
    public void openAFolderOrFile(String fname) {
        try {
            waitForElementToBeClickable(mDriver.findElement(
                    By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'" + fname + "')]")));

            MobileElement folderOrFileName = mDriver.findElement(
                    By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'" + fname + "')]"));
            folderOrFileName.click();
        } catch (Exception e) {
            Log.info("Study Notes Page | file/folder is not present to open.");
        }
    }

    // Method to add a new notes
    public boolean addANewNotes(String fileName) {
        boolean flag = false;
        click(addNewFileButton);
        sendKeys(addNewNotesTxtBox_PopUp, fileName);
        click(AddFolderButton);
        for (MobileElement name : folderOrFileName) {
            if (name.getText().equalsIgnoreCase(fileName)) {
                flag = true;
                Log.info("New Notes has been created successfully.");
            }
        }
        return flag;

    }

    // Select a file or folder to perform rename/copy/move/delete operation
    public void selectAfileOrFolder(String fileName) {
        for (int i = 0; i < folderOrFileName.size(); i++) {
            if (folderOrFileName.get(i).getText().equalsIgnoreCase(fileName)) {
                longPress(selectionCheckBox.get(i));
                Log.info(fileName + " File is selected");
                break;
            }
        }
    }

    // Select a Destination Folder to copy or move a file.
    public boolean selectDestinationFolder(String folderName) {
        boolean flag = false;
        for (int i = 0; i < folderListForCopyOrMove.size(); i++) {
            if (folderListForCopyOrMove.get(i).getText().equalsIgnoreCase(folderName)) {
                click(folderListForCopyOrMove.get(i));
                flag = true;
                Log.info(folderName + " Folder is selected to copy or move a file.");
                break;
            }
        }
        return flag;
    }

    // Delete test files and folders
    public void deleteTestFiles() {
        try {
            while (!mDriver
                    .findElements(By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'test')]"))
                    .isEmpty()) {
                selectAfileOrFolder(mDriver
                        .findElement(By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'test')]"))
                        .getText());
                click(deleteBtn);
                click(saveBtn_RenamePopup);
            }
        } catch (Exception e) {

        }
    }

    // is File or folder present
    public boolean isFilePresent(String fileName) {
        boolean flag = false;
        try {
            waitForElementToBeClickable(mDriver.findElement(
                    By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'" + fileName + "')]")));

            MobileElement folderOrFileName = mDriver.findElement(
                    By.xpath(".//*[@content-desc='uit_notespage_item_name'][contains(@text,'" + fileName + "')]"));
            if (folderOrFileName.getText().equalsIgnoreCase(fileName)) {
                flag = true;
            }

        } catch (Exception e) {
            Log.info("file/folder is not present.");
        }
        return flag;
    }

//    public boolean isFilePresentInRootFolder(String fileName) {
//        boolean flag = false;
//        for (MobileElement elm : folderOrFileName) {
//            if (elm.getText().equalsIgnoreCase(fileName)) {
//                flag = true;
//                break;
//            }
//        }
//
//        return flag;
//    }

    // Rename a file
    public boolean verifyRenameFeature(String fileName) {
        boolean flag = false;
        selectAfileOrFolder(fileName);
        click(renameBtn);
        sendKeys(editTextBox_RenamePopup, fileName + " 123");
        click(saveBtn_RenamePopup);

        flag = isFilePresent(fileName + " 123");
        return flag;
    }

    // Copy a File to a destination folder
    public boolean copyAfile(String fileName, String destinationFolder) {
        boolean flag = false;
        selectAfileOrFolder(fileName);
        selectAfileOrFolder(fileName + "(1)");
        click(copyBtn, "Copy button is clicked.");
        if (selectDestinationFolder(destinationFolder)) {
            click(okBtn_CopyOverlay);
            waitForElementToBeClickable(studyNotesPageHeading);
            openAFolderOrFile(destinationFolder);
            if (isFilePresent(fileName) && isFilePresent(fileName + "(1)")) {
                flag = true;
            }
            click(backBtnFromFolder);
            waitForElementToBeClickable(studyNotesPageHeading);
        } else {
            click(backBtn_CopyOverlay,
                    "Back button is clicked from copy/move overlay since destination folder is not present.");
        }
        return flag;
    }

    // Copy a file in root folder
    public boolean copyAfileInRootFolder(String fileName) {
        boolean flag = false;
        waitForElementToBeClickable(studyNotesPageHeading);
        selectAfileOrFolder(fileName);
        click(copyBtn, "Copy button is clicked.");
        click(okBtn_CopyOverlay);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        flag = isFilePresent(fileName + "(1)");
        return flag;
    }

    // Copy multiple folders
    public boolean copyMultipleFolders(String destinationFolder) {
        boolean flag = false;
        addANewFolder("folder1");
        addANewFolder("folder2");
        selectAfileOrFolder("folder1");
        selectAfileOrFolder("folder2");
        click(copyBtn, "Copy button is clicked.");
        if (selectDestinationFolder(destinationFolder)) {
            click(okBtn_CopyOverlay);
            waitForElementToBeClickable(studyNotesPageHeading);
            openAFolderOrFile(destinationFolder);
            if (isFilePresent("folder1") && isFilePresent("folder2")) {
                flag = true;
            }
            click(backBtnFromFolder);
            waitForElementToBeClickable(studyNotesPageHeading);
        } else {
            click(backBtn_CopyOverlay,
                    "Back button is clicked from copy/move overlay since destination folder is not present(Copying multiple folders).");
        }

        return flag;
    }

    // Move files and folders
    public boolean moveFilesAndFolders() {
        boolean flag = false;
        boolean fileMovedFromRootFolder = false;
        boolean fileMovedToDestFolder = false;
        addANewFolder("folder_test");
        selectAfileOrFolder("folder1");
        selectAfileOrFolder("folder2");
        selectAfileOrFolder("test notes 123");
        selectAfileOrFolder("test notes 123(1)");
        click(moveBtn, "Move button is clicked.");
        selectDestinationFolder("folder_test");
        click(okBtn_CopyOverlay);
        waitForElementToBeClickable(studyNotesPageHeading);
        if (!isFilePresent("folder1") && !isFilePresent("folder2") && !isFilePresent("test notes 123")
                && !isFilePresent("test notes 123(1)")) {
            fileMovedFromRootFolder = true;
        }
        openAFolderOrFile("folder_test");
        if (isFilePresent("folder1") && isFilePresent("folder2") && isFilePresent("test notes 123")
                && isFilePresent("test notes 123(1)")) {
            fileMovedToDestFolder = true;
        }
        if (fileMovedFromRootFolder == true && fileMovedToDestFolder == true) {
            flag = true;
        }
        click(backBtnFromFolder, "Move multiple files and folders - Back button is clicked from the folder");
        return flag;

    }

    // Delete a file/folder
    public boolean deleteAfileOrFolder(String name) {
        boolean flag = false;
        selectAfileOrFolder(name);
        click(deleteBtn);
        click(saveBtn_RenamePopup);
        flag = isFilePresent(name);
        return flag;
    }

    // Add multiple files and folders
    public ArrayList<String> addMultipleFilesAndFolders() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("testFolder1");
        list.add("testFolder2");
        list.add("testFile1");
        list.add("testFile2");

        for (int i = 0; i < list.size(); i++) {
            if (i < 2) {
                addANewFolder(list.get(i));
                waitForElementToBeClickable(studyNotesPageHeading);
            } else {
                addANewNotes(list.get(i));
                waitForElementToBeClickable(studyNotesPageHeading);
            }
        }
        return list;
    }

    // Delete multiple files/folders
    public boolean deleteMultipleFiles() {
        boolean flag = false;
        ArrayList<String> list = addMultipleFilesAndFolders();

        for (String elm : list) {
            selectAfileOrFolder(elm);
        }

        click(deleteBtn);
        click(saveBtn_RenamePopup);

        for (String elm : list) {
            if (!isFilePresent(elm)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        return flag;

    }

    // Search in Study Notes page
    public boolean searchInNotes(String searchString) {
        boolean flag = false;
        click(searchIcon);
        sendKeys(searchTxtBox, searchString);
        pressEnter();
        waitForElementToBeClickable(firstSearchResult);
        String text = firstSearchResult.getText();
        if (text.contains(searchString)) {
            flag = true;
        }
        click(backBtn_SearchResultsPage);
        return flag;
    }

    // Search in study notes page - no search results found
    public boolean noSearchResultsInNotes(String searchString) {
        boolean flag = false;
        click(searchIcon);
        sendKeys(searchTxtBox, searchString);
        pressEnter();
        if (isElementDisplayed(noSearchResultsMsg)) {
            flag = true;
        }
        click(backBtn_SearchResultsPage);
        return flag;
    }

    public boolean addTextInNotes(String text) {
        boolean flag = false;
        addANewNotes("test notes1");
        openAFolderOrFile("test notes1");
        click(closeOnInfoMsgPopUp);
        click(closeOnInfoMsgPopUp);

        click(addTextBoxInStudyNotes);
        click(leftTextBoxPosition);
        click(leftTextBox_blank);
        sendKeys(editTextBox_studyNotes, text);
        click(saveBtn_EditTextBox);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (MobileElement elm : textInsideTextBox) {
            System.out.println(elm.getText());
            if (elm.getText().contains(text)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean verifyPDFPreview(String text) {
        boolean flag = true;
        click(pdfPreviewButton);
        waitForElementToBeClickable(textInPDF);
        String txt = textInPDF.getText();
        if (isElementDisplayed(downloadBtn_PDFPreview) && isElementDisplayed(shareBtn_PDFPreview)
                && txt.equalsIgnoreCase(text)) {
            flag = true;
        }
        return flag;
    }

}
