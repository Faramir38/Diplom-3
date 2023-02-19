package ru.yandex.praktikum.POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPageBurger extends BasePageBurger {

    public PersonalPageBurger(WebDriver driver) {
        super(driver);
    }

    //Кнопка Конструктор
    By constructorButton = By.xpath("//p[text()='Конструктор']");
    //Логотип
    By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    //Кнопка Профиль
    By profileButton = By.xpath("//a[@href='/account/profile']");
    //Кнопка Выход
    By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']/button");

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoad() {
        waitForVisibility(profileButton);
    }

    @Step("Проверка видимости кнопки Профиль")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Клик на кнопку Конструктор")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на Выйти")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

}
