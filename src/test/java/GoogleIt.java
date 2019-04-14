import org.junit.Test;
import org.openqa.selenium.By;
import pages.GooglePage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleIt {
    @Test
    public void searchHH() {
        GooglePage page = open("https://google.com", GooglePage.class);
        SearchResultsPage results = page.searchFor("HH");
        results.getResults().shouldHave(size(6));
        results.getResult(0).shouldHave(text("HeadHunter"));
        System.out.println(results.getResult(0).getText());
    }
}
