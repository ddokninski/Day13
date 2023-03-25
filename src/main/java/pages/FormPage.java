package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    String expectedMsg = "Form send with success";

    @FindBy (css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy (css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy (css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy (css = "input[name='gridRadiosSex']")
    private List<WebElement> genderRadioButton;

    @FindBy (css = "#inputAge3")
    private WebElement ageInput;

    @FindBy (css = "input[name='gridRadiosExperience']")
    private List<WebElement> experienceCheckBox;

    @FindBy (css = "#gridCheckAutomationTester")
    private WebElement automationTesterCheckBox;

    @FindBy (css = "#selectContinents > option")
    private List<WebElement> continrntsDropDownList;

    @FindBy (css = "#selectSeleniumCommands")
    private WebElement commandsSelect;

    @FindBy (css = "#chooseFile")
    private WebElement fileInput;

    @FindBy (css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy (css = "div[class='col-sm-12 success']")
    private WebElement validationMsgLabel;

    public FormPage setFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.emailInput.sendKeys(email);
        return this;
    }

    public FormPage setRandomGender() {
        genderRadioButton.get(random.nextInt(genderRadioButton.size() - 1)).click();
        return this;
    }

    public FormPage setAge(String age) {
        this.ageInput.sendKeys(age);
        return this;
    }

    public FormPage setRandomExperience() {
        experienceCheckBox.get(random.nextInt(experienceCheckBox.size() - 1)).click();
        return this;
    }

    public FormPage setAutomationTesterProfession() {
        automationTesterCheckBox.click();
        return this;
    }

    public FormPage setRandomContinent() {
        continrntsDropDownList.get(random.nextInt(continrntsDropDownList.size() - 1)).click();
        return this;
    }

    public FormPage setSeleniumCommands() {
        Select commands = new Select(commandsSelect);
        commands.selectByValue("switch-commands");
        commands.selectByValue("wait-commands");
        return this;
    }

    public FormPage uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage sendForm() {
        submitButton.click();
        return this;
    }

    public String getValidationMsgLabel() {
        return validationMsgLabel.getText();

    }
}
