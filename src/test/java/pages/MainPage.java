package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public ElementsCollection getMenu() {
        return $$(By.xpath("//li/div[contains(@class,\"MenuItem\")]"));
    }

    public SelenideElement getMenuItem (int index) {
        return $(By.xpath("//li/div[contains(@class,\"MenuItem\")]"), index);
    }

    public SelenideElement getLoginButton () {
        return $(By.xpath("//div[@class='login-submit-form']/input"));
    }

    public void closeRegionWindow () {
        $(By.xpath("//span[contains(@class,'dropdown-closer')]")).click();
    }

    public void login (String login, String password) {
        $(By.xpath("(//*[@class='login-input']/input)[1]")).setValue(login);
        $(By.xpath("(//*[@class='login-input']/input)[2]")).setValue(password);
        $(By.xpath("//div[@class='login-submit-form']/input")).pressEnter();
    }

    public SelenideElement getProfileMenu () {
        return $(By.xpath("//span[@class='navi-item__employer-info']"));
    }

}
