package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.LoginPageBurger;
import ru.yandex.praktikum.pom.MainPageBurger;
import ru.yandex.praktikum.pom.PassRecoverPageBurger;
import ru.yandex.praktikum.pom.RegistrationPageBurger;

public class LoginTest extends BaseWebTest {

    @Before
    public void setUp() {
        initWebDriver();
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        RegistrationPageBurger registerPageObj = new RegistrationPageBurger(driver);

        //кликаем "Войти в аккаунт"
        mainPageObj.clickLogin();
        //ждем загрузки страницы логина
        loginPageObj.waitForLoad();
        //кликаем на Зарегистроваться
        loginPageObj.clickRegister();
        //ждем загрузки страницы регистрации
        registerPageObj.waitForLoad();
        //заполняем форму регистрации
        String name = DataGenerator.randomName();
        String email = DataGenerator.randomEmail();
        String password = DataGenerator.randomPassword();
        registerPageObj.fillRegistrationForm(name, email, password);
        emailToDelete = email;
        passwordToDelete = password;
        //клик на кнопку Зарегистрироваться
        registerPageObj.clickRegister();
        //ждем загрузки страницы логина
        loginPageObj.waitForLoad();
        //клик на логотип
        loginPageObj.clickLogo();
        //Ждем загрузки главной
        mainPageObj.waitForLoad();
    }

    //    вход по кнопке «Войти в аккаунт» на главной,
    @Test
    @DisplayName("Проверка логина по кнопке Войти в аккаунт на главной странице")
    public void shouldLoginOnMainPage() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);

        //клик на кнопку войти
        mainPageObj.clickLogin();
        //заполняем форму логина
        loginPageObj.waitForLoad();
        loginPageObj.fillLoginForm(emailToDelete, passwordToDelete);
        loginPageObj.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("кнопка оформить заказ не появилась", mainPageObj.isOrderButtonVisible());
    }

    //    вход через кнопку «Личный кабинет»,
    @Test
    @DisplayName("Проверка логина по кнопке Личный кабинет")
    public void shouldLoginByPersonalButton() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);

        //клик на кнопку личный кабинет
        mainPageObj.clickPersonal();
        //заполняем форму логина
        loginPageObj.waitForLoad();
        loginPageObj.fillLoginForm(emailToDelete, passwordToDelete);
        loginPageObj.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("кнопка оформить заказ не появилась", mainPageObj.isOrderButtonVisible());
    }

    //    вход через кнопку в форме регистрации,
    @Test
    @DisplayName("Проверка логина по кнопке Войти в форме регистрации")
    public void shouldLoginOnRegistrationPage() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        RegistrationPageBurger registerPageObj = new RegistrationPageBurger(driver);

        mainPageObj.clickLogin();
        //ждем загрузки страницы логина
        loginPageObj.waitForLoad();
        //кликаем на Зарегистроваться
        loginPageObj.clickRegister();
        //ждем загрузки страницы регистрации
        registerPageObj.waitForLoad();
        //клик на кнопку Войти
        registerPageObj.clickLogin();
        //заполняем форму логина
        loginPageObj.waitForLoad();
        loginPageObj.fillLoginForm(emailToDelete, passwordToDelete);
        loginPageObj.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("кнопка оформить заказ не появилась", mainPageObj.isOrderButtonVisible());
    }

    //    вход через кнопку в форме восстановления пароля.
    @Test
    @DisplayName("Проверка логина по кнопке Войти в форме регистрации")
    public void shouldLoginOnPassRecoveryPage() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        PassRecoverPageBurger passRecoverPageObj = new PassRecoverPageBurger(driver);

        mainPageObj.clickLogin();
        loginPageObj.waitForLoad();
        loginPageObj.clickRestore();
        //Кликаем на Войти
        passRecoverPageObj.waitForLoad();
        passRecoverPageObj.clickLogin();
        //ждем загрузки страницы регистрации
        loginPageObj.waitForLoad();
        loginPageObj.fillLoginForm(emailToDelete, passwordToDelete);
        loginPageObj.clickLogin();
        //Проверяем что появилась кнопка оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("кнопка оформить заказ не появилась", mainPageObj.isOrderButtonVisible());
    }
}
