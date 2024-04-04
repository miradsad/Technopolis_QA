package com.vkedu.mirad.secondHW;

import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import com.vkedu.mirad.secondHW.PageObjects.GroupsPage;
import com.vkedu.mirad.secondHW.PageObjects.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GroupTest extends BaseTest {
    @DisplayName("Тест количества прогружаемых групп(за 5 сек бездейсвтия)")
    @Test
    public void checkNumberOfRecomendedGroups(){
        AuthPage authPage = new AuthPage(MY_URL);
        authPage.logIn(MY_LOGIN,MY_PASSWORD);
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoGroups();
        GroupsPage groupsPage = new GroupsPage();
        //проверяем, что при переходе в раздел группы изначально у нас отображается 32 группы
        Assertions.assertEquals(32, groupsPage.countNumberOfElements());
    }
}
