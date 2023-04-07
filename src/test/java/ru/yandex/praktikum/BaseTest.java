package ru.yandex.praktikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.pageobjects.*;

import java.util.concurrent.TimeUnit;

import static ru.yandex.praktikum.PathConst.DRIVER_CHROME;
import static ru.yandex.praktikum.PathConst.MAIN_PAGE;

public class BaseTest {
    private final UserClient userClient = new UserClient();
    private final UserAccountData userAccountData = new UserAccountData();
    private final String userLogin = userAccountData.getLoginJson();
    private final String userPassword = userAccountData.getPasswordJson();
    private final String userName = userAccountData.getNameJson();
    protected LoginPage loginPage;
    protected ConstructorPage constructorPage;
    protected ProfilePage profilePage;
    protected RegisterPage registerPage;
    protected RecoveryPage recoveryPage;
    protected WebDriver driver;
    private String token;

    @Before
    public void setUp() {
        if (DRIVER_CHROME) {
            driver = new ChromeDriver();
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(System.getProperty("user.home") + "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        RestAssured.baseURI = MAIN_PAGE;
        token = null;
    }

    @After
    public void teardown() {
        timesleep(10);
        driver.quit();
        //Удаляем созданного пользователя
        if (token != null) userClient.deleteUser(token.substring(7));
    }

    protected void creatingTestUser() {
        //Создаем пользователя
        String json = "{" + userLogin + "\"," + userName + "\"," + userPassword + "\"}";
        token = userClient.createUser(json);
    }

    protected void loginTestUser(String json) {
        //Получаем token зарегистрированного пользователя
        token = userClient.loginExistingUser(json);
    }

    //Задержка для визуализации работы тестов
    public void timesleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
