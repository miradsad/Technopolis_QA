package com.vkedu.mirad.secondHW;

import com.vkedu.mirad.secondHW.ENUMS.AuthDataEnum;
import com.vkedu.mirad.secondHW.PageObjects.AuthPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeAuthParametrizedTest extends BaseTest {
    @DisplayName("Параметризированный тест ошибок при входе")
    @ParameterizedTest
    @EnumSource(AuthDataEnum.class)
    public void checkNegativeAuthAnswers(AuthDataEnum authDataEnum){
        AuthPage authPage = new AuthPage(MY_URL);
        authPage.logIn(authDataEnum.getLogin(), authDataEnum.getPassword());
        switch (authDataEnum){
            case EMPTY_LOGIN -> assertEquals("Введите логин", authPage.getLoginError());
            case EMPTY_PASSWORD -> assertEquals("Введите пароль", authPage.getLoginError());
            default -> assertEquals("Неправильно указан логин и/или пароль", authPage.getLoginError());
        }
    }
}
