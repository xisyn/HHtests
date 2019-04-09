import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
        $(By.xpath("//div[@class='login-submit-form']/input")).shouldHave(value("Войти"));
    }

    @Test
    public void login() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        fileInputStream = new FileInputStream("src/main/resources/config.propeties");
        properties.load(fileInputStream);

        open("https://hh.ru");
        $(By.xpath("//span[contains(@class,'dropdown-closer')]")).click();

        $(By.xpath("(//*[@class='login-input']/input)[1]")).setValue(properties.getProperty("login"));
        $(By.xpath("(//*[@class='login-input']/input)[2]")).setValue(properties.getProperty("password"));
        $(By.xpath("//div[@class='login-submit-form']/input")).pressEnter();

        $(By.xpath("//span[@class='navi-item__employer-info']")).shouldHave(text("Дмитрий Хицунов"));
    }
}
