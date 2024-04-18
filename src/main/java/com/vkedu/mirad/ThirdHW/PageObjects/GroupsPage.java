package com.vkedu.mirad.ThirdHW.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage implements BasePage {
    private final ElementsCollection groupsCollection = $$x(".//*[@data-l=\"groupCard,POPULAR_GROUPS.popularTop\"]");
    public GroupsPage(){
        check();
        sleep(5000);
    }
    @Override
    public void check(){
        Assertions.assertEquals("Рекомендуем", $x(".//*[contains(text(), \"Рекомендуем\")]").shouldBe(visible).getText());
    }
    public int countNumberOfElements(){
        //с коллекцией элементов shouldBe(visible) не работает, поэтому пришлось прибегнуть к sleep ->
        // groupsCollection.shouldBe(visible).size()
        // если просто применять метод сайз то группы не успевают прогрузиться в нужном кол-ве
        // я кинул этот слип в конструктор, так более логично, хотя всё равно не знаю как лучше реализовать этот тест
        System.out.println("Количество наших рекомендованных групп: " + groupsCollection.size());
        return groupsCollection.size();
    }

}
