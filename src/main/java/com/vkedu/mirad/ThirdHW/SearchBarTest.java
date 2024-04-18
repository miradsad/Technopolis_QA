package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import com.vkedu.mirad.ThirdHW.PageObjects.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchBarTest extends BaseTest {
    private static final String somethingStudid = "ashjdfbahjsfbajsdhfbaksdjhfbaksjhdfbajshdfbajkshdfbjashdfbkajhefbahsdhvbncvbnafb";
    @Test
    public void checkHeaderIfStupidSearch(){
        AuthPage authPage = new AuthPage();
        authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.searchLikeDummy(somethingStudid);
        SearchResultPage searchResultPage = new SearchResultPage();
        Assertions.assertEquals("Таких людей не нашлось", searchResultPage.getHeaderAfterDummySearch());
    }
}