package com.schrack.sfsAutomation.config;

public class BasicConfig {
    public static String slash = System.getProperty("file.separator");
    public static String filePath = System.getProperty("user.dir") + slash + "src" + slash + "main" + slash + "resources"
            + slash;

    public static String androidApp() {
        String file = "";
        file = filePath + "com.schrack.schrackforstudents.apk";
        return file;
    }

    public String iOSApp() {
        String file = "";
        file = filePath + "SchrackForStudents.iOS.ipa";
        return file;
    }

    public String getFilePath(String appName) {
        String file = "";

        if (appName.equalsIgnoreCase("android")) {
            file = filePath + "com.schrack.schrackforstudents.apk";
        } else if (appName.equalsIgnoreCase("ios")) {
            file = filePath + "SchrackForStudents.iOS.ipa";
        } else {
            System.out.println("Please provide correct appName to find the existing file..!!!");
        }
        return file;
    }

    public String releaseDetailsURI(String appName, String environment) {
        String baseURI = "https://api.appcenter.ms/v0.1/apps/NagarroAT/" + appName + "/distribution_groups/"
                + environment + "/releases";
        return baseURI;
    }

    public String downloadReleaseURI(String appName) {
        String baseURI = "https://api.appcenter.ms/v0.1/apps/NagarroAT/" + appName + "/releases/";
        return baseURI;
    }
}
