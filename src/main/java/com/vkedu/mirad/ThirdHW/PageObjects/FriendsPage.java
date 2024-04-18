package com.vkedu.mirad.ThirdHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage implements BasePage {
    private final SelenideElement welcomingDiv = $x(".//*[@id=\"hook_Block_MyFriendsSquareCardsPagingB\"]//*[@class=\"stub-empty_t\"]");
    public FriendsPage(){
        check();
    }
    public void check(){
        Assertions.assertEquals("Возможные друзья", $x(".//*[contains(text(), \"Возможные друзья\")]").shouldBe(visible).getText());
    }
    public String checkWelcomingString(){
        System.out.println("Ищем нашу строку");
        String s = welcomingDiv.shouldBe(visible).getText();
        System.out.println("Нашли нашу строку: "+ s);
        return s;
    }
}
