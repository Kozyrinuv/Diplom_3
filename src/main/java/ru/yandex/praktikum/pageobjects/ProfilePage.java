package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс страницы "Личный кабинет" сайта "Звездные бургеры"
public class ProfilePage {
    private final WebDriver driver;
    //-------- Локаторы ----------------------------------------
    //Кнопка "Конструктор" на панели логотипа сайта
    //$x(".//p[text()='Конструктор']")
    private final By ConstructorTextButton = By.xpath(".//p[text()='Конструктор']");

    //Текст "Профиль" на странице PROFILE_PAGE
    //$x(".//a[text()='Профиль']")
    private final By profileText = By.xpath(".//a[text()='Профиль']");

    //Кнопка <Выход>
    //$x(".//button[text()='Выход']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    //Логотип сайта
    private final By logotip = By.tagName("svg");

    //---------------методы------------------------------------------------------
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие кнопки <Выход> на странице <Личный кабинет>")
    public void pressExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    @Step("Нажатие кнопки <Конструктор> на панели логотипа сайта")
    public void pressConstructorTextButton() {
        driver.findElement(ConstructorTextButton).click();
    }

    @Step("Нажатие кнопки <Logotip> на панели логотипа сайта")
    public void pressLogo() {
        driver.findElement(logotip).click();
    }

    @Step("Проверка видимости текста <Профиль> на странице <Личный кабинет>")
    public void checkProfileText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
        Assert.assertTrue(driver.findElement(profileText).isDisplayed());
    }

}
