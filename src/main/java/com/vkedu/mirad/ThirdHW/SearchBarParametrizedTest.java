package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.ENUMS.StupidStringsEnum;
import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import com.vkedu.mirad.ThirdHW.PageObjects.MainPage;
import com.vkedu.mirad.ThirdHW.PageObjects.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchBarParametrizedTest extends BaseTest {
    @DisplayName("Тест на ввод разных \"глупых\" строк")
    @ParameterizedTest
    @MethodSource("stupidStringsEnumProvider")
    public void checkHeaderIfStupidSearch(StupidStringsEnum stupidString){
        AuthPage authPage = new AuthPage();
        authPage.enterLogin(MY_LOGIN).enterPassword(MY_PASSWORD).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.searchLikeDummy(stupidString.getValue());
        SearchResultPage searchResultPage = new SearchResultPage();
        Assertions.assertEquals("Таких людей не нашлось", searchResultPage.getHeaderAfterDummySearch());
    }

    static Stream<StupidStringsEnum> stupidStringsEnumProvider() {
        return Stream.of(StupidStringsEnum.values());
    }
}
