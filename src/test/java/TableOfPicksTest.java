import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PickRowPage;
import pages.TableOfPicksPage;

import java.util.List;
import java.util.stream.Stream;

public class TableOfPicksTest extends BaseTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("Switzerland", "4000")
        );
    }

    @BeforeEach
    public void testSetUp() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void getInfoFromTableOfPicks(String countryName, String height) {
        TableOfPicksPage tableOfPicksPage = new TableOfPicksPage(driver);
        List<PickRowPage> picksInSwitzerlandHigherThan4000 = tableOfPicksPage.getMountainsFromCurrentCountryAndHigherThan(tableOfPicksPage.getMountains(), countryName, height);

        for (PickRowPage pickRowPage : picksInSwitzerlandHigherThan4000) {
            System.out.print(pickRowPage.getRank() + " ");
            System.out.print(pickRowPage.getPeak() + " ");
            System.out.println(pickRowPage.getMountainRange());
        }
    }
}
