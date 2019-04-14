import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests {
    @Test
    public void checkMainPage() {
        MainPage page = open("https://hh.ru", MainPage.class);
        page.getMenuItem(0).shouldHave(text("Ищу работу"));
        page.getLoginButton().shouldHave(value("Войти"));
    }

    @Test
    public void login() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        fileInputStream = new FileInputStream("src/test/resources/config.propeties");
        properties.load(fileInputStream);

        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        MainPage page = open("https://hh.ru", MainPage.class);
        page.closeRegionWindow();
        page.login(login, password);
        page.getProfileMenu().shouldHave(text("Дмитрий Хицунов"));
    }
}
