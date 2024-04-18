package com.vkedu.mirad.ThirdHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage implements BasePage {
    private final SelenideElement dummyResultHeader = $x(".//*[@id=\"tabpanel-users\"]//h2");

    public SearchResultPage(){
        check();
    }

    @Override
    public void check() {
        Assertions.assertEquals("Найти", $x(".//*[text() = \"Найти\"]").shouldBe(visible).getText());
    }

    public String getHeaderAfterDummySearch(){
        System.out.println("Получаем наш хэдэр");
        String s = dummyResultHeader.shouldBe(visible).getText();
        System.out.println("Наш хедер если написать глупость в поиск выглядит так: " + s);
        return s;
    }
}
