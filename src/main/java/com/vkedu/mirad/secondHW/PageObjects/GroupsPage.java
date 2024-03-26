package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage {
    private final ElementsCollection groupsCollection = $$x("//div[@data-l=\"groupCard,POPULAR_GROUPS.popularTop\"]");
    public int countNumberOfElements(){
        sleep(5000);
        //с коллекцией элементов shouldBe(visible) не работает, поэтому пришлось прибегнуть к sleep
        System.out.println("Количество наших рекомендованных групп: " + groupsCollection.size());
        return groupsCollection.size();
    }

}
