import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.FormPage;

import java.io.File;
import java.util.stream.Stream;

public class FormPopTest extends BaseTest {

    FormPage formPage;

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("Form send with success", "Jan", "Kowalski", "jan@wp.pl", "30", "src/main/resources/file.txt")
        );
    }

    @BeforeEach
    public void testSetUp() {
        formPage = new FormPage(driver);
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void shouldFillFormWithSuccess(String expectedMsg, String firstName, String lastName, String email, String age, String pathName) {

        formPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setRandomGender()
                .setAge(age)
                .setRandomExperience()
                .setAutomationTesterProfession()
                .setRandomContinent()
                .setSeleniumCommands()
                .uploadFile(new File(pathName))
                .sendForm();

        Assertions.assertThat(formPage.getValidationMsgLabel()).isEqualTo(expectedMsg);
    }
}
