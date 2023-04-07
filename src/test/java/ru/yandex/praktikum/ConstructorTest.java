package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.ConstructorPage;

//Тесты страницы "Конструктор" сайта "Звездные бургеры"
public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    @Description("Проверка надписи Булки при выборе вкладки Булки")
    public void checkGoToBunsTab() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        constructorPage.clickBuns();
        constructorPage.checkBunsVisible();
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    @Description("Проверка надписи Соусы при выборе вкладки Соусы")
    public void checkGoToSaucesTab() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        constructorPage.clickSauces();
        constructorPage.checkSaucesVisible();
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    @Description("Проверка надписи Начинки при выборе вкладки Начинки")
    public void checkGoToFillingsTab() {
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        constructorPage.clickFillings();
        constructorPage.checkFillingsVisible();
    }

}