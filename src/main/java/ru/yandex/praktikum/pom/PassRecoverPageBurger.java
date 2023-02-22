package ru.yandex.praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassRecoverPageBurger extends BasePageBurger {

    //Надпись Восстановление пароля
    private By restorePasswordLabel = By.xpath("//h2[text()='Восстановление пароля']");
    //Кнопка Войти
    private By loginButton = By.xpath("//a[@href='/login']");
    public PassRecoverPageBurger(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на Войти")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoad() {
        waitForVisibility(restorePasswordLabel);
    }
}
