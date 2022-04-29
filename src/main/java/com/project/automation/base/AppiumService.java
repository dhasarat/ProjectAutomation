package com.project.automation.base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.project.automation.annotations.LazyComponent;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

@LazyComponent
@PropertySource("appiumConfig.properties")
@Profile({ "android | ios" })
public class AppiumService {

    @Autowired
    DesiredCapabilities cap;

    @Value("${serverIp}")
    private String serverIp;

    @Value("${appiumPort}")
    private int appiumPort;

    @Value("${COMMAND_TIMEOUT}")
    private String command_TIMEOUT;

    public String serverURL() {
        String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";
        return serverUrl;
    }

    @Lazy
    @Bean
    public AppiumDriverLocalService startAppiumServer() {
        AppiumDriverLocalService service;
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress(serverIp);
        builder.usingPort(appiumPort);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        // builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        service = AppiumDriverLocalService.buildService(builder);
        return service;
    }

}
