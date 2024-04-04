package com.vkedu.mirad.secondHW;

import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import com.vkedu.mirad.secondHW.PageObjects.MainPage;
import com.vkedu.mirad.secondHW.PageObjects.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchBarTest extends BaseTest {
    private final String somethingStudid = "ashjdfbahjsfbajsdhfbaksdjhfbaksjhdfbajshdfbajkshdfbjashdfbkajhefbahsdhvbncvbnafb";
    @Test
    public void checkHeaderIfStupidSearch(){
        AuthPage authPage = new AuthPage(MY_URL);
        authPage.logIn(MY_LOGIN,MY_PASSWORD);
        MainPage mainPage = new MainPage();
        mainPage.searchLikeDummy(somethingStudid);
        SearchResultPage searchResultPage = new SearchResultPage();
        Assertions.assertEquals("Таких людей не нашлось", searchResultPage.getHeaderAfterDummySearch());
    }
}