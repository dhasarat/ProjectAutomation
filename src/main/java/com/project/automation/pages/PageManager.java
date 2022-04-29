package com.project.automation.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.automation.annotations.LazyCompMobile;

@LazyCompMobile
public class PageManager {

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private MainMenuPage mainMenuPage;

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public MainMenuPage getMainMenuPage() {
		return mainMenuPage;
	}
}