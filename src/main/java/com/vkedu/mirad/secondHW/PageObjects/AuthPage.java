package com.vkedu.mirad.secondHW.PageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
public class AuthPage {
    private final SelenideElement loginInput = $x(".//*[@id=\"field_email\"]");
    private final SelenideElement pwInput = $x(".//*[@id=\"field_password\"]");
    private final SelenideElement loginError = $x(".//*[contains(@class,\"login_error\")]");
    public AuthPage(String url){
        open(url);
    }
    public AuthPage logIn(String login, String pw){
        loginInput.shouldBe(visible).setValue(login);
        pwInput.shouldBe(visible).setValue(pw).sendKeys(Keys.ENTER);
        System.out.println("Пробуем авторизоваться...");
        return this;
    }
    public String getLoginError(){
        return loginError.should(exist).getText();
    }

}
