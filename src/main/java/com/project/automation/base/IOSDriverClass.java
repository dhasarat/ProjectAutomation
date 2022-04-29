package com.project.automation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.project.automation.annotations.LazyComponent;
import com.project.automation.config.BasicConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

@LazyComponent
@Profile("ios")
public class IOSDriverClass extends BasicConfig{

    @Autowired
    AppiumService appium;
    
    @Autowired
    AppiumDriverLocalService service;
    
    @Value("${platformName}")
    private String platformName;

    @Value("${platformVersion}")
    private String platformVersion;

    @Value("${deviceName}")
    private String deviceName;

    @Value("${udid}")
    private String udid;

    @Value("${xcodeOrgId}")
    private String xcodeOrgId;

    @Value("${bundleID}")
    private String bundleID;

    @Bean
    @Scope("driverScope")
    public AppiumDriver<MobileElement> iOSDriverInit() {
//        service.start();
        System.out.println("--------- Appium Server is started in IOS ---------");
        AppiumDriver<MobileElement> mDriver = null;
        String serverURL = appium.serverURL();

        try {
            mDriver = new IOSDriver<MobileElement>(new URL(serverURL), setCapabilities());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (SessionNotCreatedException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("IOS Driver in initdriver is : " + mDriver);
        return mDriver;
    }

    @Bean
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        cap.setCapability("udid", udid);
        cap.setCapability("xcodeSigningId", "iPhone Developer");
        cap.setCapability("xcodeOrgId", xcodeOrgId);
        cap.setCapability("bundleId", bundleID);
        cap.setCapability("autoAcceptAlerts", true);

        cap.setCapability(MobileCapabilityType.APP, iOSApp());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 4000);
        cap.setCapability("fullReset", true);
        cap.setCapability("autoGrantPermissions", true);

        return cap;
    }

}
