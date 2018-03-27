package emg.park.calc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Sample test using Selenium Webelements
 */
public class ParkCalcSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        var options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
    }

    @Test
    public void testParkCalcSelenium() {
        final var parkCalcUrl = "http://www.shino.de/parkcalc/";
        driver.get(parkCalcUrl);

        //set enconomy parking
        var parkingLot = new Select(driver.findElement(By.id("ParkingLot")));
        parkingLot.selectByIndex(2);

        //set entryDate
        var entryDate = driver.findElement(By.id("StartingDate"));
        entryDate.clear();
        entryDate.sendKeys("03/26/2018");
        var entryTime = driver.findElement(By.id("StartingTime"));
        entryTime.clear();
        entryTime.sendKeys("09:00");
        var entryAM = driver.findElement(By.name("StartingTimeAMPM"));
        entryAM.click();

        //set exitDate
        var exitDate = driver.findElement(By.id("LeavingDate"));
        exitDate.clear();
        exitDate.sendKeys("03/26/2018");
        var exitTime = driver.findElement(By.id("LeavingTime"));
        exitTime.clear();
        exitTime.sendKeys("12:00");
        var exitPM = driver.findElement(By.xpath("(//input[@name='LeavingTimeAMPM'])[2]"));
        exitPM.click();

        //calculate
        var calculate = driver.findElement(By.name("Submit"));
        calculate.click();

        //get result
        var result = driver.findElement(By.xpath("//tr[4]/td[2]"));
        var resultMessage = result.getText();

        assertTrue(resultMessage.contains("6.00"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
