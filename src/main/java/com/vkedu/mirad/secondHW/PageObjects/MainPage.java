package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement userFriends = $x(".//*[@data-l=\"t,userFriend\"]//div");
    private final SelenideElement userProfile = $x(".//*[@data-l=\"t,userPage\"]//div");
    private final SelenideElement userGroups = $x(".//*[@data-l=\"t,userAltGroup\"]//div");
    private final SelenideElement searchBar = $x(".//*[@class=\"search-wrapper__4nym2\"]//label//input");
    public MainPage(){

    }

    public MainPage(String url){
        open(url);
    }
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
