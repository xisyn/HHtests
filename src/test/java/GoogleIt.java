import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleIt {
    @Test
    public void searchSelenide() {
        open("https://google.com");
        $(By.name("q")).setValue("HH").pressEnter();
        $$(By.xpath("//div[@class='rc']")).shouldHave(size(6));
        $(By.xpath("//div[@class='rc']")).shouldHave(text("HeadHunter"));
        System.out.println($(By.xpath("//div[@class='rc']")).getText());
    }
}
