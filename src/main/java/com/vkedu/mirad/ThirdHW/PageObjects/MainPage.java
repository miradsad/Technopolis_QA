package com.vkedu.mirad.ThirdHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage implements BasePage {
    private final SelenideElement userFriends = $x(".//*[@data-l=\"t,userFriend\"]//div");
    private final SelenideElement userProfile = $x(".//*[@data-l=\"t,userPage\"]//div");
    private final SelenideElement userGroups = $x(".//*[@data-l=\"t,userAltGroup\"]//div");
    private final SelenideElement searchBar = $x(".//*[@class=\"search-wrapper__4nym2\"]//label//input");
    public MainPage(){
        check();
    }
    @Override
    public void check(){
        Assertions.assertEquals("technopol70 technopol70", $x(".//*[@data-l='t,userPage']").shouldBe(visible).getText());
    }
    public FriendsPage navigateIntoFriends(){
        System.out.println("Переходим во вкалдку friends");
        userFriends.shouldBe(visible).click();
        System.out.println("Перешли");
        return new FriendsPage();
    }
    public UserPage navigateIntoProfile(){
        System.out.println("Переходим во вкалдку профиля");
        userProfile.shouldBe(visible).click();
        System.out.println("Перешли");
        return new UserPage();
    }
    public GroupsPage navigateIntoGroups(){
        System.out.println("Переходим во вкалдку групп");
        userGroups.shouldBe(visible).click();
        System.out.println("Перешли");
        return new GroupsPage();
    }
    public SearchResultPage searchLikeDummy(String s){
        searchBar.shouldBe(visible).click();
        searchBar.setValue(s).sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }

}
