package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.PathConst.REGISTER_PAGE;

// Класс страницы "Регистрация" сайта "Звездные бургеры"
public class RegisterPage {
    private final WebDriver driver;
    //-------- Локаторы ----------------------------------------
    //Поле ввода "Name"
    //$x(".//fieldset[1]//input")
    private final By inputName = By.xpath(".//fieldset[1]//input");

    //Поле ввода "Email"
    //$x(".//fieldset[2]//input")
    private final By inputEmail = By.xpath(".//fieldset[2]//input");

    //Поле ввода "Пароль"
    //$x(".//fieldset[3]//input")
    private final By inputPassword = By.xpath(".//fieldset[3]//input");

    //Кнопка "Зарегистрироваться"
    //$x(".//button[text()='Зарегистрироваться']")
    private final By sigupButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Кнопка "Войти"
    //$x(".//a[text()='Войти']")
    private final By siginButton = By.xpath(".//a[text()='Войти']");

    //Текст "Некорректный пароль"
    //$x(".//p[text()='Некорректный пароль']")
    private final By errorPasswordText = By.xpath(".//p[text()='Некорректный пароль']");

    //--------------методы------------------------------------------------
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы <Регистрация>")
    public void open() {
        driver.get(REGISTER_PAGE);
    }

    @Step("Нажатие кнопки <Войти> на странице <Регистрации>")
    public LoginPage pressSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }

    @Step("Ввод данных в поле <Имя>")
    public void inputName(String name) {
        driver.findElement(inputName).clear();
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Ввод данных в поле <Email>")
    public void inputEmail(String email) {
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Ввод данных в поле <Пароль>")
    public void inputPassword(String password) {
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Нажатие кнопки <Зарегистрироваться>")
    public LoginPage pressButtonRegistration() {
        driver.findElement(sigupButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка видимости текста ошибки о вводе неправильного пароля")
    public void checkErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorPasswordText));
        Assert.assertTrue(driver.findElement(errorPasswordText).isDisplayed());
    }

}
