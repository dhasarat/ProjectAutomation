package com.schrack.sfsAutomation.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.schrack.sfsAutomation.annotations.LazyCompMobile;

@LazyCompMobile
public class PageManager {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private StudyPlatformPage studyPlatformPage;

    @Autowired
    private NewsPage newsPage;

    @Autowired
    private QnAPage qnaPage;

    @Autowired
    private TutorialsPage tutorialsPage;

    @Autowired
    private ChatsPage chatsPage;

    @Autowired
    private Common commonPage;

    @Autowired
    private UserRegistrationPage userRegPage;

    @Autowired
    private MainMenuPage mainMenuPage;

    @Autowired
    private UserProfilePage userProfilePage;

    @Autowired
    private ForgotPasswordPage forgotPassPage;

    @Autowired
    private StudyNotesPage studyNotesPage;

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public StudyPlatformPage getStudyPlatformPage() {
        return studyPlatformPage;
    }

    public Common getCommonPage() {
        return commonPage;
    }

    public NewsPage getNewsPage() {
        return newsPage;
    }

    public QnAPage getQnAPage() {
        return qnaPage;
    }

    public TutorialsPage getTutorialsPage() {
        return tutorialsPage;
    }

    public ChatsPage getChatsPage() {
        return chatsPage;
    }

    public UserRegistrationPage getUserRegPage() {
        return userRegPage;
    }

    public MainMenuPage getMainMenuPage() {
        return mainMenuPage;
    }

    public UserProfilePage getUserProfilePage() {
        return userProfilePage;
    }

    public ForgotPasswordPage getForgotPassPage() {
        return forgotPassPage;
    }

    public StudyNotesPage getStudyNotesPage() {
        return studyNotesPage;
    }

}
