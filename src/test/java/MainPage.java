import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Test
    public void checkMainPage() {
        //Configuration.holdBrowserOpen = true;
        open("https://hh.ru");
        $(By.xpath("//li/div[contains(@class,\"MenuItem\")]")).shouldHave(text("Ищу работу"));
        //WebElement element = $(By.xpath("//li/div[contains(@class,\"MenuItem\")]"));
        $(By.xpath("//div[@class = 'login-submit-form']/input")).shouldHave(value("Войти"));
    }
}
