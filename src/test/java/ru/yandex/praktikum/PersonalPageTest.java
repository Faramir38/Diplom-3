package ru.yandex.praktikum;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pom.LoginPageBurger;
import ru.yandex.praktikum.pom.MainPageBurger;
import ru.yandex.praktikum.pom.PersonalPageBurger;
import ru.yandex.praktikum.pom.RegistrationPageBurger;

public class PersonalPageTest extends BaseWebTest {
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
        loginPageObj.fillLoginForm(email, password);
        loginPageObj.clickLogin();
        mainPageObj.waitForLoad();
    }

    //    Проверь переход по клику на «Личный кабинет».
    @Test
    @DisplayName("Проверка входа в личный кабинет")
    public void shouldEnterPersonalAccount() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        PersonalPageBurger personalPageObj = new PersonalPageBurger(driver);

        //клик на личный кабинет
        mainPageObj.clickPersonal();
        //проверяем видимость кнопки профиль
        personalPageObj.waitForLoad();
        Assert.assertTrue("Вход в личный кабинет не выполнен", personalPageObj.isProfileButtonVisible());
    }

    //    Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
    @Test
    @DisplayName("Проверка перехода в конструктор через клик на Конструктор")
    public void shouldEnterConstructorByConstructorButton() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        PersonalPageBurger personalPageObj = new PersonalPageBurger(driver);

        //клик на личный кабинет
        mainPageObj.clickPersonal();
        personalPageObj.waitForLoad();
        //кликаем на Конструктор
        personalPageObj.clickConstructor();
        //Проверяем видимость кнопки оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPageObj.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на лого")
    public void shouldEnterConstructorByLogo() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        PersonalPageBurger personalPageObj = new PersonalPageBurger(driver);

        //клик на личный кабинет
        mainPageObj.clickPersonal();
        personalPageObj.waitForLoad();
        //кликаем на лого
        personalPageObj.clickLogo();
        //Проверяем видимость кнопки оформить заказ
        mainPageObj.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPageObj.isOrderButtonVisible());
    }

    //    Проверь выход по кнопке «Выйти» в личном кабинете.
    @Test
    @DisplayName("Проверка выхода по кнопке Выйти")
    public void shouldLogoutByLogoutButton() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);
        LoginPageBurger loginPageObj = new LoginPageBurger(driver);
        PersonalPageBurger personalPageObj = new PersonalPageBurger(driver);

        //клик на личный кабинет
        mainPageObj.clickPersonal();
        personalPageObj.waitForLoad();
        //клик на Выйти
        personalPageObj.clickLogout();
        //проверяем что перешли на страницу Логина
        loginPageObj.waitForLoad();
        Assert.assertTrue("Выход не произошел", loginPageObj.isEnterLabelVisible());
    }
}
