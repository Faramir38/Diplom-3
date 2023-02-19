package ru.yandex.praktikum.POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassRecoverPageBurger extends BasePageBurger {

    public PassRecoverPageBurger(WebDriver driver) {
        super(driver);
    }

    //Надпись Восстановление пароля
    By restorePasswordLabel = By.xpath("//h2[text()='Восстановление пароля']");
    //Кнопка Войти
    By loginButton = By.xpath("//a[@href='/login']");

    @Step("Клик на Войти")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoad() {
        waitForVisibility(restorePasswordLabel);
    }


}
