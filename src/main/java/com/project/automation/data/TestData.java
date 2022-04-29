package com.project.automation.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.project.automation.annotations.LazyCompMobile;
import com.project.automation.config.FetchData;
import com.project.automation.pojo.Books;
import com.project.automation.pojo.LoginData;

@LazyCompMobile
public class TestData {

    @Value("${env}")
    public String env;

    @Bean
    public List<Books> getBooksData() {
        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("title", "Title");
        mapping.put("subTitle", "Subtitle");
        mapping.put("publisher", "Publisher");
        mapping.put("version", "Version");

        List<Books> list = FetchData.getData(mapping, Books.class, "books", env);
        return list;
    }

    @Bean
    public LinkedHashMap<String, String> getLoginUsers() {

        LinkedHashMap<String, String> map = FetchData.csvToMap("loginUsers", env);
        return map;

    }

    @Bean
    public LinkedHashMap<String, String> getLoginPageData() {
        LinkedHashMap<String, String> map = FetchData.csvToMap("LoginPageData", env);
        return map;
    }
    
    @Bean
    public LinkedHashMap<String, String> getForgotPasswordPageData() {
        LinkedHashMap<String, String> map = FetchData.csvToMap("forgotPasswordData", env);
        return map;
    }

}
