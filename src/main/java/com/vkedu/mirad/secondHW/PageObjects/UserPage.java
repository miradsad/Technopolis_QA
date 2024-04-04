package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class UserPage {
    private final SelenideElement additionalInfo = $x(".//*[contains(@class,\"user-profile_lk-o\")]//div");
    private final SelenideElement cityInfo = $x(".//*[@data-type=\"TEXT\"]");
    public UserPage navigateIntoAdditionalInfo(){
        System.out.println("Перейдём к доп. информации о юзере");
        additionalInfo.shouldBe(visible).click();
        System.out.println("Перешли");
        return this;
    }
    public String getCityString(){
        String s = cityInfo.shouldBe(visible).getText();
        System.out.println("Проверяем город юзера: "+s);
        return s;
    }

}
