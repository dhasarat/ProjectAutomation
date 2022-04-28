package com.schrack.sfsAutomation.base;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.schrack.sfsAutomation.annotations.LazyComponent;
import com.schrack.sfsAutomation.config.BasicConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

@LazyComponent
@Profile("setup")
public class WebDriverClass extends BasicConfig{

    @Bean
    @Scope("driverScope")
    public WebDriver webDriverInit() {
        WebDriver wDriver = null;
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePref = new HashMap<String, Object>();

        chromePref.put("profile.default_content_settings.popups", 0);
        chromePref.put("download.default_directory", filePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePref);
        wDriver = new ChromeDriver(options);
        System.out.println("************** IN Webdriver class *******" + wDriver);
        return wDriver;
    }

}
