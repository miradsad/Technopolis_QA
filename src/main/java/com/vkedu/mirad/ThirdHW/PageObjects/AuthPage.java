package com.vkedu.mirad.ThirdHW.PageObjects;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
public class AuthPage implements BasePage{
    private final SelenideElement loginInput = $x(".//*[@id=\"field_email\"]");
    private final SelenideElement pwInput = $x(".//*[@id=\"field_password\"]");
    private final SelenideElement loginError = $x(".//*[contains(@class,\"login_error\")]");
    private final SelenideElement submitAuth = $x(".//*[@data-l=\"t,sign_in\"]");
    public AuthPage(){
        check();
    }

    @Override
    public void check() {
        Assertions.assertEquals("Вход", $x(".//*[contains(text(), \"Вход\")]").shouldBe(visible).getText());
    }

    public AuthPage quickLogin(String login, String pw){
        loginInput.shouldBe(visible).setValue(login);
        pwInput.shouldBe(visible).setValue(pw).sendKeys(Keys.ENTER);
        System.out.println("Пробуем авторизоваться...");
        return this;
    }
    public AuthPage enterLogin(String login){
        loginInput.shouldBe(visible).setValue(login);
        return this;
    }
    public AuthPage enterPassword(String pw){
        pwInput.shouldBe(visible).setValue(pw);
        return this;
    }
    public MainPage clickAuthButton(){
            submitAuth.shouldBe(visible).click();
        return new MainPage();
    }
    public String getLoginError(){
        return loginError.should(exist).getText();
    }

}
