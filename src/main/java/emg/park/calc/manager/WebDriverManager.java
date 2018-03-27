package emg.park.calc.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    //private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    //private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.firefox.driver";
    private final int defaultTimeout;
    private final int environmetType;
    private final String defaultDriver;
    private final boolean headless;

    /**
     * Carga configuraciones por defecto.
     */
    public WebDriverManager() {
        //TODO: esto podria leerse de un archivo de configuracion
        defaultTimeout = 10;
        environmetType = 0;
        defaultDriver = System.getProperty("driver", "chrome");
        headless = false;
    }

    /**
     * Obtiene el WebDriver.
     *
     * @return default web driver instance
     */
    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmetType) {
            case 1: { //remote Driver
                driver = createRemoteDriver();
                break;
            }
            default: { //LOCAL DRIVER
                driver = createLocalDriver();
                break;

            }
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (defaultDriver) {
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(headless);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "iexplorer": {
                InternetExplorerOptions iexplorerOptions = new InternetExplorerOptions();
                driver = new InternetExplorerDriver(iexplorerOptions);
                break;
            }
            default: { //default to chrome
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(headless);
                driver = new ChromeDriver(chromeOptions);
            }

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * cierra el driver.
     */
    public void closeDriver() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception ex) {
            System.err.print("Error closing driver: " + ex.getMessage());
        }
    }
}
