package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.GroupsPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GroupTest extends BaseTest {
    @DisplayName("Тест количества прогружаемых групп(за 5 сек бездейсвтия)")
    @Test
    public void checkNumberOfRecomendedGroups(){
        AuthPage authPage = new AuthPage();
        authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoGroups();
        GroupsPage groupsPage = new GroupsPage();
        //проверяем, что при переходе в раздел группы изначально у нас отображается 32 группы
        Assertions.assertEquals(32, groupsPage.countNumberOfElements());
    }
}
