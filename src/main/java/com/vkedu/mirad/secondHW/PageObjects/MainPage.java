package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    private final SelenideElement userFriends = $x("//a[@data-l=\"t,userFriend\"]//div");
    private final SelenideElement userProfile = $x("//a[@data-l=\"t,userPage\"]//div");
    private final SelenideElement userGroups = $x("//a[@data-l=\"t,userAltGroup\"]//div");
    private final SelenideElement searchBar = $x("//div[@class=\"search-wrapper__4nym2\"]//label//input");

    public MainPage navigateIntoFriends(){
        System.out.println("Переходим во вкалдку friends");
        userFriends.shouldBe(visible).click();
        System.out.println("Перешли");
        return this;
    }
    public MainPage navigateIntoProfile(){
        System.out.println("Переходим во вкалдку профиля");
        userProfile.shouldBe(visible).click();
        System.out.println("Перешли");
        return this;
    }
    public MainPage navigateIntoGroups(){
        System.out.println("Переходим во вкалдку групп");
        userGroups.shouldBe(visible).click();
        System.out.println("Перешли");
        return this;
    }
    public MainPage searchLikeDummy(String s){
        searchBar.shouldBe(visible).click();
        searchBar.setValue(s).sendKeys(Keys.ENTER);
        return this;
    }

}
