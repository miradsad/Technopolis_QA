package com.vkedu.mirad.ThirdHW;

import com.codeborne.selenide.Selenide;
import com.vkedu.mirad.ThirdHW.ENUMS.StupidStringsEnum;
import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import com.vkedu.mirad.ThirdHW.PageObjects.NotesPage;
import com.vkedu.mirad.ThirdHW.PageObjects.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

public class PostingTestFactory extends BaseTest {
    @TestFactory
    Stream<DynamicTest> testSearchFunctionality() {
        return Stream.of(
                DynamicTest.dynamicTest("Тест создания тестовой заметки", () -> {
                    AuthPage authPage = new AuthPage();
                    authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
                    MainPage mainPage = new MainPage();
                    mainPage.navigateIntoProfile();
                    UserPage userPage = new UserPage();
                    userPage.navigateIntoNotes();
                    NotesPage notesPage = new NotesPage();
                    notesPage.openPostingMenu().postText(StupidStringsEnum.STRING_1.getValue());
                    Assertions.assertEquals(StupidStringsEnum.STRING_1.getValue(), notesPage.checkPostedText());
                    notesPage.closeNote().clickLogo();
                }),
                DynamicTest.dynamicTest("Тест удаления заметки", () -> {
                    MainPage mainPage = new MainPage();
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
