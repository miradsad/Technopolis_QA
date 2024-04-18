package com.vkedu.mirad.ThirdHW.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class NotesPage implements BasePage {
    private final SelenideElement postMenu = $x(".//*[@class=\"pf-head_itx_a\"]");
    private final SelenideElement postInput = $x(".//*[@role=\"textbox\"]//div");
    private final SelenideElement submitButton = $x(".//*[@data-l=\"t,button.submit\"]");
    private final SelenideElement ourPost = $x(".//*[@class=\"media-text_a\"]");
    private final SelenideElement ourPostText = $x(".//*[@link-class=\"media-text_lnk\"]");
    private final SelenideElement postActions = $x(".//*[@class=\"new_topic_icodown\"]");
    private final SelenideElement deleteButton = $x(".//*[@id=\"hook_Block_ShortcutMenu\"]//ul//li[3]"); //не понял как обратиться иначе, слишкм много хидден элементов странных иначе
    private final SelenideElement emptyPostListString = $x(".//div[contains(@class,\"stub-empty \") and contains(@class,\"__v2\")]/div");
    private final SelenideElement closeButton = $x(".//*[@data-l=\"t,mtLayerClose\"]");
    private final SelenideElement logo = $x(".//*[@data-l=\"t,logo\"]");

    public NotesPage(){
        check();
    }

    @Override
    public void check() {
        Assertions.assertEquals("Напишите заметку", $x(".//*[@class=\"pf-head_itx\"]").shouldBe(visible).getText());
    }

    public NotesPage openPostingMenu(){
        System.out.println("Нажимаем на меню создания поста...");
        postMenu.click();
        System.out.println("Нажали.");
        return this;
    }

    public NotesPage postText(String string){
        System.out.println("Вводим текст...");
        postInput.shouldBe(visible).shouldBe(enabled).setValue(string);
        System.out.println("Ввели.");
        submitButton.shouldBe(enabled).click();
        System.out.println("Запостили.");
        return this;
    }

    public String checkPostedText(){
        System.out.println("Проверяем запостился ли наш текст и возвращем его");
        ourPost.shouldBe(visible).click();
        ourPostText.shouldBe(visible);
        System.out.println("Done: " + ourPostText.getText());
        return ourPostText.getText();
    }
    public NotesPage deletePostedText(){
        System.out.println("Удаляем пост...");
        postActions.should(exist).hover();
        deleteButton.should(exist).click();
        System.out.println("Удалили.");
        return this;
    }
    public  String checkEmptyPostList(){
        String s = emptyPostListString.shouldBe(visible).getText();
        System.out.println("Наша строка: " + s);
        return s;
    }
    public NotesPage closeNote(){
        closeButton.should(exist).click();
        return this;
    }
    public MainPage clickLogo(){
        logo.shouldBe(visible).click();
        return new MainPage();
    }

}
