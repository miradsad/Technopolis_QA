package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage {
    private final SelenideElement welcomingDiv = $x(".//*[@id=\"hook_Block_MyFriendsSquareCardsPagingB\"]//*[@class=\"stub-empty_t\"]");
    public String checkWelcomingString(){
        System.out.println("Ищем нашу строку");
        String s = welcomingDiv.shouldBe(visible).getText();
        System.out.println("Нашли нашу строку: "+ s);
        return s;
    }
}
