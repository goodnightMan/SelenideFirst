

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }



    @Test
            void CodeJUnit5Test ()

    {
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

}
