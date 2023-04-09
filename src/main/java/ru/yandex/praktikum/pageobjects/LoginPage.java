package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс страницы "Авторизация" сайта "Звездные бургеры"
public class LoginPage {
    private final WebDriver driver;
    //-------- Локаторы ----------------------------------------
    //Кнопка "Войти"
    //$x(".//button[text()='Войти']")
    private final By siginButton = By.xpath(".//button[text()='Войти']");

    //Поле ввода "Email"
    //$x(".//input[@name = 'name']")
    private final By inputEmail = By.xpath(".//input[@name = 'name']");

    //Поле ввода "Пароль"
    //$x(".//input[@name = 'Пароль']")
    private final By inputPassword = By.xpath(".//input[@name = 'Пароль']");

    //------------методы ----------------------------------------
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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

    @Step("Ожидание доступности кнопки <Войти> на форме <Авторизация>")
    public void waitClicableSiginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(siginButton));
    }

    @Step("Проверка доступности кнопки <Войти> на форме <Авторизация>")
    public void checkClickableSiginButton() {
        waitClicableSiginButton();
        Assert.assertTrue(driver.findElement(siginButton).isDisplayed());
    }

    @Step("Нажатие кнопки <Войти> на странице <Авторизации>")
    public ConstructorPage pressSiginButton() {
        driver.findElement(siginButton).click();
        return new ConstructorPage(driver);
    }

}
