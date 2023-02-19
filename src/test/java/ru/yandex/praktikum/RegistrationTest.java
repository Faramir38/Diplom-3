package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.POM.LoginPageBurger;
import ru.yandex.praktikum.POM.MainPageBurger;
import ru.yandex.praktikum.POM.RegistrationPageBurger;



public class RegistrationTest extends BaseWebTest{

//    Успешную регистрацию.

    @Test
    @DisplayName("Тестируем успешную регистрацию")
    public void shouldRegisterNewUser() {

        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        RegistrationPageBurger registerPageObj  = new RegistrationPageBurger(driver);
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
        String password= DataGenerator.randomPassword();
        registerPageObj.fillRegistrationForm(name, email, password);
        emailToDelete = email;
        passwordToDelete = password;
        //клик на кнопку Зарегистрироваться
        registerPageObj.clickRegister();
        //ждем загрузки страницы логина
        loginPageObj.waitForLoad();
        //заполняем форму логина
        loginPageObj.fillLoginForm(email, password);
        loginPageObj.clickLogin();
        //ждем загрузки главной страницы
        mainPageObj.waitForLoad();
        //проверяем что появилась кнопка заказа
        Assert.assertTrue("Регистрация не произошла", mainPageObj.isOrderButtonVisible());
    }
//    Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void DisplayErrorForWrongPassword() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        RegistrationPageBurger registerPageObj  = new RegistrationPageBurger(driver);
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
        String password= DataGenerator.randomWrongPassword();
        registerPageObj.fillRegistrationForm(name, email, password);
        registerPageObj.clickRegister();
        //проверяем что появилась надпись о некорректном пароле
        Assert.assertTrue("Ошибка о некорректном пароле не появилась",
                registerPageObj.isIncorrectPasswordLabelVisible());

    }
}
