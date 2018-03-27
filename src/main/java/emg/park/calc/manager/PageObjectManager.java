package emg.park.calc.manager;

import emg.park.calc.ParkCalcPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private ParkCalcPage parkCalcPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public ParkCalcPage getParkCalcPage() {
        return (parkCalcPage == null) ? parkCalcPage = new ParkCalcPage(driver) : parkCalcPage;
    }
}
