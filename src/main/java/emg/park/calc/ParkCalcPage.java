package emg.park.calc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ParkCalcPage {

    private static final String DEFAULT_URL = "http://www.shino.de/parkcalc/";
    private WebDriver driver;

    @FindBy(how = How.ID, using = "ParkingLot")
    private WebElement parkingLot;

    @FindBy(how = How.ID, using = "StartingDate")
    private WebElement entryDate;
    @FindBy(how = How.ID, using = "StartingTime")
    private WebElement entryTime;
    @FindBy(how = How.NAME, using = "StartingTimeAMPM")
    private WebElement entryAM;
    @FindBy(how = How.XPATH, using = "(//input[@name='StartingTimeAMPM'])[2]")
    private WebElement entryPM;

    @FindBy(how = How.ID, using = "LeavingDate")
    private WebElement leavingDate;
    @FindBy(how = How.ID, using = "LeavingTime")
    private WebElement leavingTime;
    @FindBy(how = How.NAME, using = "LeavingTimeAMPM")
    private WebElement leavingAM;
    @FindBy(how = How.XPATH, using = "(//input[@name='LeavingTimeAMPM'])[2]")
    private WebElement leavingPM;

    @FindBy(how = How.XPATH, using = "//tr[4]/td[2]")
    private WebElement calculatedCost;
    @FindBy(how = How.NAME, using = "Submit")
    private WebElement calculate;

    public ParkCalcPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void navigate() {
        driver.get(DEFAULT_URL);
    }

    public void setEntryDate(String date) {
        entryDate.clear();
        entryDate.sendKeys(date);
    }

    public void setEntryTime(String time) {
        entryTime.clear();
        entryTime.sendKeys(time);
    }

    public void setLeavingDate(String date) {
        leavingDate.clear();
        leavingDate.sendKeys(date);
    }

    public void setLeavingTime(String time) {
        leavingTime.clear();
        leavingTime.sendKeys(time);
    }

    public void selectEntryTimePMOption() {
        entryPM.click();
    }

    public void selectEntryTimeAMOption() {
        entryAM.click();
    }

    public void selectLeavingTimePMOption() {
        leavingPM.click();
    }

    public void selectLeavingTimeAMOption() {
        leavingAM.click();
    }

    public void userValetParking() {
        var lot = new Select(parkingLot);
        lot.selectByIndex(0);
    }

    public void userShortTermParking() {
        var lot = new Select(parkingLot);
        lot.selectByIndex(1);
    }

    public void userEconomyParking() {
        var lot = new Select(parkingLot);
        lot.selectByIndex(2);
    }

    public void userLongTermGarageParking() {
        var lot = new Select(parkingLot);
        lot.selectByIndex(3);
    }

    public void userLongTermSurfaceParking() {
        var lot = new Select(parkingLot);
        lot.selectByIndex(4);
    }

    public WebElement getCalculatedCost() {
        return this.calculatedCost;
    }

    public void calculate() {
        calculate.click();
    }

}
