package emg.park.calc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParkCalcPageTest {
    private WebDriver driver;
    private ParkCalcPage parkCalcPage;

    @BeforeEach
    public void setUp() throws Exception {
        var options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);

        parkCalcPage = new ParkCalcPage(driver);
    }

    @Test
    public void testSameDay() throws Exception {
        parkCalcPage.navigate();
        parkCalcPage.userEconomyParking();
        parkCalcPage.setEntryDate("03/19/2018");
        parkCalcPage.setEntryTime("09:00");
        parkCalcPage.selectEntryTimeAMOption();
        parkCalcPage.setLeavingDate("03/19/2018");
        parkCalcPage.setLeavingTime("12:00");
        parkCalcPage.selectLeavingTimePMOption();

        parkCalcPage.calculate();
        var ammount = parkCalcPage.getCalculatedCost().getText();
        assertTrue(ammount.contains("6.00"));
//        assertEquals("Should be equals", "$ 6.00        (0 Days, 3 Hours, 0 Minutes)", ammount);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.close();
    }

}
