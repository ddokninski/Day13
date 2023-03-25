package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PickRowPage {

    @FindBy(css = "th")
    private WebElement rank;
    @FindBy(xpath = "./td[1]")
    private WebElement peak;
    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;
    @FindBy(xpath = "./td[3]")
    private WebElement state;
    @FindBy(xpath = "./td[4]")
    private WebElement height;

    public PickRowPage(WebElement element) {
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    public void printInfo() {
        System.out.println();
    }

    public String getRank() {
        return rank.getText();
    }

    public String getPeak() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getCountry() {
        return state.getText();
    }

    public String getHeight() {
        return height.getText();
    }

    @Override
    public String toString() {
        return "PickRowPage{" +
                "rank=" + rank.getText() +
                ", peak=" + peak.getText() +
                ", mountainRange=" + mountainRange.getText() +
                ", state=" + state.getText() +
                ", height=" + height.getText() +
                '}';
    }
}


