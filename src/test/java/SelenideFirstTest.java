import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/*
Задание 1
1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
Если может - приведите пример, когда.
Разница есть: $("h1 div") ищет первый элемент h1 с div, $("h1").$("div") ищет первый h1 и первый div в нем.
Поиск может найти разные элементы, так как у элемента h1 может не быть вложенного элемента div.
*/


public class SelenideFirstTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void CodeJUnit5Test() {
        //  Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $(byText("Wiki")).click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //Ввести в поле поиска SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //Проверить что страница найдена
        $("#wiki-pages-box").$("ul").shouldHave(text("SoftAssertions"));
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        //Перейти на страницу oftAssertions
        $("#wiki-pages-box").$("ul").$(byText("SoftAssertions")).click();
        //Проверить наличие кода для JUnit5
        $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }

    @Test
    void DragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test  // вопрос: тест падает, аналог драгэнддропа не отпускает элемент, почему? не пойму
    void AnalogDragAndDropTest() {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенесите прямоугольник А на место В
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(270, 100).release().perform();
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
