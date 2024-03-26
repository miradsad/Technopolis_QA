package com.vkedu.mirad.secondHW;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    protected static String MY_LOGIN;
    protected static String MY_PASSWORD;
    protected final String MY_URL = "https://ok.ru/";

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
            MY_LOGIN = properties.getProperty("login");
            MY_PASSWORD = properties.getProperty("password");
        } catch(IOException e) {
            System.out.println("Не получилось считать properties (логин и пароль)");
        }
    }

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 2000;
        Configuration.headless = false;

    }
    @Before
    public void init(){
        setUp();
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}