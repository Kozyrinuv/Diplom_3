package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.PathConst.RECOVERY_PAGE;

// Класс страницы "Восстановления пароля" сайта "Звездные бургеры"
public class RecoveryPage {
    private final WebDriver driver;
    //-------- Локаторы ----------------------------------------
    //Кнопка "Войти"
    //$x(".//href[text()='Войти']")
    private final By siginButton = By.linkText("Войти");

    //---------------методы------------------------------------------
    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы <Восстановление пароля>")
    public void open() {
        driver.get(RECOVERY_PAGE);
    }

    @Step("Нажатие кнопки <Войти> на странице <Восстановление пароля>")
    public LoginPage pressSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }

}
