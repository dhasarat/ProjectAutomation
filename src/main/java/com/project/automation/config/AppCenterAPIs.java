package com.project.automation.config;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import com.project.automation.annotations.LazyComponent;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@LazyComponent
@Profile("setup")
public class AppCenterAPIs extends BasicConfig {

	@Autowired
	private WebDriver wDriver;

	@Value("${apiKey}")
	public String apiKey;

	@Value("${buildNumber}")
	public String buildNumber;

	@Value("${buildVersion}")
	public String buildVersion;

	@Value("${env}")
	public String env;

	@Value("${appName}")
	public String appName;

	public String getAppName() {
		String app = "";
		if (appName.equalsIgnoreCase("android")) {
			app = "//ANDROID_APP";
		} else if (appName.equalsIgnoreCase("ios")) {
			app = "//IOS_APP";
		} else {
			System.out.println("Please provide correct app name....!!!!!!!");
		}
		return app;
	}

	public void downloadBuildFromAppCenter() throws Exception {

		String app = getAppName();
		int releaseID = 0;
		String downloadURL = "";

		Response response = given().when().header("X-Api-Token", apiKey).get(releaseDetailsURI(app, env)).then()
				.extract().response();
		JsonPath js = response.jsonPath();
		Thread.sleep(1000);
		List<Map<String, Object>> ls = js.getList("$");
		int n = ls.size();
		for (int i = 0; i < n; i++) {
			if (ls.get(i).get("version").equals(buildNumber) && ls.get(i).get("short_version").equals(buildVersion)) {
				releaseID = (Integer) ls.get(i).get("id");
				System.out.println(releaseID);
				break;
			} else if (i == n - 1) {
				throw new Exception("No build found..!!! Please check if provided build details are correct.");
			}
		}
		Response apiResponse = given().when().header("X-Api-Token", apiKey).get(downloadReleaseURI(app) + releaseID)
				.then().extract().response();
		JsonPath jsonPath = apiResponse.jsonPath();
		downloadURL = jsonPath.get("download_url");
		File file = new File(getFilePath(appName));

		if (file.exists()) {
			file.delete();
			System.out.println("Deleted older version");
		}
		wDriver.get(downloadURL);

		while (!file.exists()) {
			Thread.sleep(1000);
		}

	}

	public void quitDriver() {
		if (wDriver != null) {
			wDriver.quit();
		}
	}

}
