package com.vkedu.mirad.secondHW.PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    private final SelenideElement dummyResultHeader = $x(".//*[@class=\"island_cnt__pyx2y\"]//h2");
    public String getHeaderAfterDummySearch(){
        System.out.println("Получаем наш хэдэр");
        String s = dummyResultHeader.shouldBe(visible).getText();
        System.out.println("Наш хедер если написать глупость в поиск выглядит так: " + s);
        return s;
    }
}
