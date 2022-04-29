package com.project.automation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.google.common.collect.ImmutableMap;
import com.project.automation.annotations.LazyComponent;
import com.project.automation.config.BasicConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

@LazyComponent
@Profile("android")
public class AndroidDriverClass extends BasicConfig {

    @Autowired
    AppiumService appium;

    @Autowired
    AppiumDriverLocalService service;

    @Value("${android.platformName}")
    private String platformName_Android;

    @Value("${android.platformVersion}")
    private String platformVersion_Android;

    @Value("${android.deviceName}")
    private String deviceName_Android;

    @Value("${android.appPackage}")
    private String appPackage_Android;

    @Value("${android.appActivity}")
    private String appActivity_Android;

    @Value("${android.deviceID}")
    private String deviceID_Android;

    @Bean
    public AppiumDriver<MobileElement> androidDriverInit() {
        // service.start();
        System.out.println("--------- Appium Server is started in AndroidDriverClass---------");
        AppiumDriver<MobileElement> mDriver = null;
        String serverURL = appium.serverURL();
        try {
            mDriver = new AndroidDriver<MobileElement>(new URL(serverURL), setCapabilities());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (SessionNotCreatedException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Driver in initdriver is : " + mDriver);
        return mDriver;
    }

    @Bean
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName_Android);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName_Android);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion_Android);
        cap.setCapability("appPackage", appPackage_Android);
        cap.setCapability("appActivity", appActivity_Android);
        cap.setCapability("deviceID", deviceID_Android);

        cap.setCapability(MobileCapabilityType.APP, androidApp());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 4000);
        cap.setCapability("fullReset", true);
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
       // cap.setCapability("setWebContentsDebuggingEnabled", true);
        //cap.setCapability("ensureWebviewsHavePages", true);
      //  cap.setCapability("webviewDevtoolsPort", 9543);
        
       

        return cap;
    }

}
