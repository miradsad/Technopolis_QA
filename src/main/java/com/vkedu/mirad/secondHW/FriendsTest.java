package com.vkedu.mirad.secondHW;

import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import com.vkedu.mirad.secondHW.PageObjects.FriendsPage;
import com.vkedu.mirad.secondHW.PageObjects.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FriendsTest extends BaseTest {
    @Test
    public void checkFriendsWelcomingTextIfBotHasNoFriends(){
        AuthPage authPage = new AuthPage(MY_URL);
        authPage.logIn(MY_LOGIN,MY_PASSWORD);
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoFriends();
        FriendsPage friendsPage = new FriendsPage();
        Assertions.assertEquals("Пока нет друзей", friendsPage.checkWelcomingString());
    }
}
