package com.vkedu.mirad.secondHW;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.vkedu.mirad.secondHW.ENUMS.StupidStringsEnum;
import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import com.vkedu.mirad.secondHW.PageObjects.MainPage;
import com.vkedu.mirad.secondHW.PageObjects.NotesPage;
import com.vkedu.mirad.secondHW.PageObjects.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class PostingTestFactory extends BaseTest {
    @TestFactory
    Stream<DynamicTest> testSearchFunctionality() {
        return Stream.of(
                DynamicTest.dynamicTest("Тест текстовых заметок", () -> {
                    AuthPage authPage = new AuthPage(MY_URL);
                    authPage.logIn(MY_LOGIN,MY_PASSWORD);
                    MainPage mainPage = new MainPage();
                    mainPage.navigateIntoProfile();
                    UserPage userPage = new UserPage();
                    userPage.navigateIntoNotes();
                    NotesPage notesPage = new NotesPage();
                    notesPage.openPostingMenu().postText(StupidStringsEnum.STRING_1.getValue());
                    Assertions.assertEquals(StupidStringsEnum.STRING_1.getValue(), notesPage.checkPostedText());
                }),
                DynamicTest.dynamicTest("Test post delete", () -> {
                    MainPage mainPage = new MainPage(MY_URL);
                    mainPage.navigateIntoProfile();
                    UserPage userPage = new UserPage();
                    userPage.navigateIntoNotes();
                    NotesPage notesPage = new NotesPage();
                    notesPage.deletePostedText();
                    Selenide.refresh();
                    Assertions.assertEquals("Поделитесь с друзьями чем-нибудь интересным!",notesPage.checkEmptyPostList());
                })
        );
    }
}
