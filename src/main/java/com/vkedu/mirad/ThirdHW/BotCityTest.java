package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import com.vkedu.mirad.ThirdHW.PageObjects.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BotCityTest extends BaseTest {
    @DisplayName("Проверка города бота")
    @Test
    public void checkBotsCity(){
        AuthPage authPage = new AuthPage();
        authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoProfile();
        UserPage userPage = new UserPage();
        Assertions.assertEquals("Москва", userPage.openAdditionalInfo().getCityString());

    }
}
