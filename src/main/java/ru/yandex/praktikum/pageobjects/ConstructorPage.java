package ru.yandex.praktikum.pageobjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.PathConst.MAIN_PAGE;

// Класс страницы "Конструктор" сайта "Звездные бургеры"
public class ConstructorPage {
    private final WebDriver driver;
    //-------- Локаторы ----------------------------------------
    //Надпись Соберите бургер
    //$x(".//h1[text()='Соберите бургер']")
    private final By buildBurgerText = By.xpath(".//h1[text()='Соберите бургер']");

    //Кнопка Личный кабинет
    //$x(".//p[text()='Личный Кабинет']")
    private final By profileButton = By.xpath(".//p[text()='Личный Кабинет']");

    //Кнопка "Войти в аккаунт"
    //$x(".//button[text()='Войти в аккаунт']")
    private final By siginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //Кнопка Оформить заказ
    //$x(".//button[text()='Оформить заказ']")
    private final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    //Нижний элемент прокручиваемой панели "Булки - Соусы - Начинки"
    // $x(".//p[text()='Сыр с астероидной плесенью']")
    private final By downTabElement = By.xpath(".//p[text()='Сыр с астероидной плесенью']");

    //Текст "Булки" на прокручиваемой панели "Булки - Соусы - Начинки"
    //$x(".//h2[text()='Булки']")
    private final By bunsText = By.xpath(".//h2[text()='Булки']");

    //Текст "Соусы" на прокручиваемой панели "Булки - Соусы - Начинки"
    //$x(".//h2[text()='Соусы']")
    private final By saucesText = By.xpath(".//h2[text()='Соусы']");

    //Текст "Начинки" на прокручиваемой панели "Булки - Соусы - Начинки"
    //$x(".//h2[text()='Начинки']")
    private final By fillingsText = By.xpath(".//h2[text()='Начинки']");

    //Выбор вкладки "Булки"
    //$x(".//span[text()='Булки']")
    private final By bunsTab = By.xpath(".//span[text()='Булки']");

    //Выбор вкладки "Соусы"
    //$x(".//span[text()='Соусы']")
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");

    //Выбор вкладки "Начинки"
    //$x(".//span[text()='Начинки']")
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");

    //---------------методы-----------------------------------------------
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы <Конструктор>")
    public void open() {
        driver.get(MAIN_PAGE);
    }

    @Step("Прокрутка панели <Булки - Соусы - Начинки> до нижнего элемента Начинок")
    public void scrollingTabDown() {
        WebElement element = driver.findElement(downTabElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Выбор вкладки <Булки>")
    public void clickBuns() {
        scrollingTabDown();
        driver.findElement(bunsTab).click();
    }

    @Step("Проверка видимости надписи <Булки>")
    public void checkBunsVisible() {
        Assert.assertTrue(driver.findElement(bunsText).isDisplayed());
    }

    @Step("Выбор вкладки <Соусы>")
    public void clickSauces() {
        scrollingTabDown();
        driver.findElement(saucesTab).click();
    }

    @Step("Проверка видимости надписи <Соусы>")
    public void checkSaucesVisible() {
        Assert.assertTrue(driver.findElement(saucesText).isDisplayed());
    }

    @Step("Выбор вкладки <Начинки>")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверка видимости надписи <Начинки>")
    public void checkFillingsVisible() {
        Assert.assertTrue(driver.findElement(fillingsText).isDisplayed());
    }

    @Step("Нажатие кнопки <Войти в аккаунт> на странице <Конструктор>")
    public LoginPage pressSiginButton() {
        driver.findElement(siginButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка видимости текста <Соберите бургер> на странице <Конструктор>")
    public void checkVisibleBuildBurgerText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(buildBurgerText));
        Assert.assertTrue(driver.findElement(buildBurgerText).isDisplayed());
    }

    @Step("Проверка доступности кнопки <Оформить заказ>")
    public void checkClickableMakeOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(makeOrderButton));
        Assert.assertTrue(driver.findElement(makeOrderButton).isDisplayed());
    }

    @Step("Нажатие кнопки <Личный кабинет>  на странице <Конструктор>")
    public LoginPage pressProfileButton() {
        driver.findElement(profileButton).click();
        return new LoginPage(driver);
    }

}
