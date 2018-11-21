package test.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ViewTestBase {

    static WebDriver driver;
    String path = "http://localhost:8080/Controller";

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:/School/2018-2019-Sem1/web3/libraries/geckodriver.exe");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);

        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://nl.wikipedia.org/wiki/Hoofdpagina");
    }

    @AfterClass
    public static void clean() {
        driver.quit();
    }


}
