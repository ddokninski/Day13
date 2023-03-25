package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TableOfPicksPage {

    public TableOfPicksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public List<PickRowPage> getMountains() {
        List<PickRowPage> mountains = new ArrayList<>();

        for (WebElement row : rows) {
            mountains.add(new PickRowPage(row));
        }
        return mountains;
    }

    public List<PickRowPage> getMountainsFromCurrentCountryAndHigherThan(List<PickRowPage> pickRowList, String countryName, String high) {
        return pickRowList.stream()
                .filter(webElement -> webElement.getCountry().contains("Switzerland"))
                .filter(webElement -> Integer.parseInt(webElement.getHeight()) > 4000)
                .toList();
    }
}
