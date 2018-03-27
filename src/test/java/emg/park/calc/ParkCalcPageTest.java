package emg.park.calc;

import emg.park.calc.context.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Sample test using Selenium Pagemodel
 */
public class ParkCalcPageTest {
    private TestContext testContext;
    private ParkCalcPage parkCalcPage;

    @BeforeEach
    public void setUp() {
        //TODO: this should be injected (picocontainer + constructor?)
        this.testContext = new TestContext();

        this.parkCalcPage = this.testContext.getPageObjectManager().getParkCalcPage();
    }

    @Test
    public void testSameDay() {
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
        assertThat(ammount, containsString("6.00"));
    }

    @AfterEach
    public void tearDown() {
        this.testContext.getWebDriverManager().closeDriver();
    }

}
