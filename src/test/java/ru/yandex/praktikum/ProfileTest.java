package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.ConstructorPage;
import ru.yandex.praktikum.pageobjects.ProfilePage;

//Тесты страницы "Личный кабинет" сайта "Звездные бургеры"
public class ProfileTest extends BaseTest {
    private final UserAccountData user = new UserAccountData();

    @Test
    @DisplayName("Переход в <Личный кабинет> со страницы <Конструктор>")
    @Description("Проверка перехода в <Личный кабинет> со страницы <Конструктор> по кнопке <Личный кабинет>")
    public void checkTransitFromConstructotToProfileTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.pressProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.checkProfileText();
    }

    @Test
    @DisplayName("Выход из аккаунта на странице <Личный кабинет> по кнопке <Выход>")
    @Description("Проверка перехода на страницу <Авторизация> из <Личного кабинета> по кнопке <Выход>")
    public void checkExitLoginTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.pressProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.pressExitButton();
        loginPage.checkClickableSiginButton();

    }

    @Test
    @DisplayName("Переход на страницу <Конструктор> из <Личного кабинета> по кнопке <Конструктор>")
    @Description("Проверка перехода на страницу <Конструктор> из <Личного кабинета> по кнопке <Конструктор>")
    public void checkTransitFromProfileToConstructorWhithConstButtonTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.pressProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.pressConstructorTextButton();
        constructorPage.checkVisibleBuildBurgerText();
    }

    @Test
    @DisplayName("Переход на страницу <Конструктор> из <Личного кабинета> по клику на логотипе <stellar Burgers>")
    @Description("Проверка перехода на страницу <Конструктор> из <Личного кабинета> по клику на логотипе")
    public void checkTransitFromProfileToConstructorWhithLogoTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.pressProfileButton();
        profilePage = new ProfilePage(driver);
        profilePage.pressLogo();
        constructorPage.checkVisibleBuildBurgerText();
    }

}
