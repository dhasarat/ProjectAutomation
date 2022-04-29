package com.project.automation.config;

public class BasicConfig {
    public static String slash = System.getProperty("file.separator");
    public static String filePath = System.getProperty("user.dir") + slash + "src" + slash + "main" + slash + "resources"
            + slash;

    public static String androidApp() {
        String file = "";
        file = filePath + "//ANDROID_APP.apk";
        return file;
    }

    public String iOSApp() {
        String file = "";
        file = filePath + "//IOS_APP_APK.ipa";
        return file;
    }

    public String getFilePath(String appName) {
        String file = "";

        if (appName.equalsIgnoreCase("android")) {
            file = filePath + "//ANDROID_APP.apk";
        } else if (appName.equalsIgnoreCase("ios")) {
            file = filePath + "//IOS_APP.apk";
        } else {
            System.out.println("Please provide correct appName to find the existing file..!!!");
        }
        return file;
    }

    public String releaseDetailsURI(String appName, String environment) {
        String baseURI = "https://api.appcenter.ms/v0.1/apps/orgNAME/" + appName + "/distribution_groups/"
                + environment + "/releases";
        return baseURI;
    }

    public String downloadReleaseURI(String appName) {
        String baseURI = "https://api.appcenter.ms/v0.1/apps/orgNAME/" + appName + "/releases/";
        return baseURI;
    }
}
