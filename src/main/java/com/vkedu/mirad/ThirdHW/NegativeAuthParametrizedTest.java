package com.vkedu.mirad.ThirdHW;

import com.vkedu.mirad.ThirdHW.ENUMS.AuthDataEnum;
import com.vkedu.mirad.ThirdHW.PageObjects.AuthPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class NegativeAuthParametrizedTest extends BaseTest {
    @DisplayName("Параметризированный тест ошибок при входе")
    @ParameterizedTest
    @EnumSource(AuthDataEnum.class)
    public void checkNegativeAuthAnswers(AuthDataEnum authDataEnum){
        AuthPage authPage = new AuthPage();
        authPage.quickLogin(authDataEnum.getLogin(),authDataEnum.getPassword());
        Assertions.assertEquals(authDataEnum.getError(),authPage.getLoginError());
    }
}
