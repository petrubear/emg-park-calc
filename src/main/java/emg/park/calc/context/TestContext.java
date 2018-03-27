package emg.park.calc.context;

import emg.park.calc.manager.PageObjectManager;
import emg.park.calc.manager.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
