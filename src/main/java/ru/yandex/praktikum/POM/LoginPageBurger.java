package ru.yandex.praktikum.POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageBurger extends BasePageBurger {

    public LoginPageBurger(WebDriver driver) {
        super(driver);
    }

    //Надпись Вход
    By enterLabel = By.xpath("//h2[text()='Вход']");
    //Поле Email
    By emailField = By.xpath("//input[@name='name']");
    //Поле Пароль
    By passwordField = By.xpath("//input[@name='Пароль']");
    //Кнопка Войти
    By loginButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");
    //Кнопка Зарегистироваться
    By registerButton = By.xpath("//a[@href='/register']");
    //Кнопка Восстановить пароль
    By restorePasswordButton = By.xpath("//a[@href='/forgot-password']");
    //Логотип
    By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    @Step("Ожидание загрузки страницы Логина")
    public void waitForLoad() {
        waitForVisibility(enterLabel);
    }

    @Step("Клик на кнопку Зарегистрироваться")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Заполнение формы логина")
    public void fillLoginForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик на кнопку Войти")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на Восстановить пароль")
    public void clickRestore() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step("Проверка видимости надписи Войти")
    public boolean isEnterLabelVisible() {
        return driver.findElement(enterLabel).isDisplayed();
    }

}
