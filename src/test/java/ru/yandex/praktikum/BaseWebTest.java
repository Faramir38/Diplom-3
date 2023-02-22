package ru.yandex.praktikum;

import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.apiclient.UserClient;
import ru.yandex.praktikum.apiclient.UserLoginBean;


public class BaseWebTest {
    protected WebDriver driver;
    protected String emailToDelete = null;
    protected String passwordToDelete = null;

    public void initWebDriver() {
        BrowserConfig cfg = ConfigFactory.create(BrowserConfig.class, System.getProperties());
        switch (cfg.browser()) {
            case "YandexBrowser":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\user\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                driver = new ChromeDriver(options);
                break;
            default:                          //задел на всякий, пока считаем, что это Хром ("Chrome")
                driver = new ChromeDriver();
        }
        driver.get(BurgerConst.BURGER_URL);
    }

    @After
    public void tearDown() {
        if (passwordToDelete != null) {
            Response response = UserClient.loginUser(new UserLoginBean(emailToDelete, passwordToDelete));
            UserClient.deleteUser(UserClient.getAccessToken(response));
        }
        driver.quit();
    }
}
