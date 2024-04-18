package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.FriendsPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class FriendsTest extends BaseTest {
    @DisplayName("Тест раздела друзей(если нет друзей)")
    @Test
    public void checkFriendsWelcomingTextIfBotHasNoFriends(){
        AuthPage authPage = new AuthPage();
        authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoFriends();
        FriendsPage friendsPage = new FriendsPage();
        Assertions.assertEquals("Пока нет друзей", friendsPage.checkWelcomingString());
    }
}
