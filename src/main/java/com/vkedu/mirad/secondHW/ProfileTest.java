package com.vkedu.mirad.secondHW;

import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import com.vkedu.mirad.secondHW.PageObjects.MainPage;
import com.vkedu.mirad.secondHW.PageObjects.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfileTest extends BaseTest {
    @Test
    public void checkBotsCity(){
        AuthPage authPage = new AuthPage(MY_URL);
        authPage.logIn(MY_LOGIN,MY_PASSWORD);
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoProfile();
        UserPage userPage = new UserPage();
        Assertions.assertEquals("Москва", userPage.navigateIntoAdditionalInfo().getCityString());

    }
}
