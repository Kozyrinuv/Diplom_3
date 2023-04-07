package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.ConstructorPage;
import ru.yandex.praktikum.pageobjects.RecoveryPage;
import ru.yandex.praktikum.pageobjects.RegisterPage;

//Тесты страницы "Авторизация" сайта "Звездные бургеры"
public class LoginTest extends BaseTest {
    private final UserAccountData user = new UserAccountData();

    @Test
    @DisplayName("Авторизация через кнопку <Войти в аккаунт> на странице <Конструктор>")
    @Description("Авторизация через кнопку <Войти в аккаунт> на странице <Конструктор>")
    public void loginWithButtonSiginConstructorPageOKTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.checkClickableMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизация через кнопку <Личный кабинет> на странице <Конструктор>")
    @Description("Авторизация через кнопку <Личный кабинет> на странице <Конструктор>")
    public void loginWithButtonProfileConstructorPageOKTest() {
        creatingTestUser();
        constructorPage = new ConstructorPage(driver);
        constructorPage.open();
        loginPage = constructorPage.pressProfileButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.pressSiginButton();
        constructorPage.checkClickableMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизация через кнопку <Войти> на странице <Регистрации>")
    @Description("Авторизация на странице <Регистрации> через кнопку <Войти>")
    public void loginWithButtonSiginRegistrationPageOKTest() {
        creatingTestUser();
        registerPage = new RegisterPage(driver);
        registerPage.open();
        loginPage = registerPage.pressSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        constructorPage = loginPage.pressSiginButton();
        constructorPage.checkClickableMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизация через кнопку <Войти> на странице <Восстановление пароля>")
    @Description("Авторизация на странице <Восстановление пароля> через кнопку <Войти>")
    public void loginWithButtonSiginRecoveryPageOKTest() {
        creatingTestUser();
        recoveryPage = new RecoveryPage(driver);
        recoveryPage.open();
        loginPage = recoveryPage.pressSiginButton();
        loginPage.waitClicableSiginButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        constructorPage = loginPage.pressSiginButton();
        constructorPage.checkClickableMakeOrderButton();
    }

}
