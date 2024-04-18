package com.vkedu.mirad.ThirdHW;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.open;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@Slf4j
abstract public class BaseTest {
    protected static String MY_LOGIN;
    protected static String MY_PASSWORD;
    protected final String MY_URL = "https://ok.ru/";

    static {
        Properties properties = new Properties();
        try {
            log.info("Попытаемся найти наши пропертис(логин и пароль)");
            properties.load(new FileInputStream("config.properties"));
            MY_LOGIN = properties.getProperty("login");
            MY_PASSWORD = properties.getProperty("password");
        } catch (IOException e) {
            log.info("Exception: исключение с пропертис(логин и пароль)", e);
            System.out.println("Не получилось считать properties (логин и пароль)");
        }
    }

    public void setUp(){
        log.info("Инициализация веб-дайвера...");
        ChromeOptions options = new ChromeOptions();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 2000;
        Configuration.headless = false;
        open(MY_URL);

    }
    @BeforeEach
    public void init(){
        setUp();
    }
    @AfterEach
    public void tearDown(){
        log.info("Закрываем веб-драйвер...");
        Selenide.closeWebDriver();
    }
}