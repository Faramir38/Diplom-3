package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.pom.MainPageBurger;

@RunWith(Parameterized.class)
@AllArgsConstructor
public class ConstructorParamTest extends BaseWebTest {
 //    Проверь, что работают переходы к разделам:
//            «Булки»,
//            «Соусы»,
//            «Начинки».
    private final String item;

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getListItem() {
        return new Object[][]{
                {"Соусы"},
                {"Начинки"},
                {"Булки"}
        };
    }

    @Before
    public void setUp() {
        initWebDriver();
    }

    @Test
    @DisplayName("Проверка переходов по разделам конструктора")
    public void shouldConstructorItemActive() {
        MainPageBurger mainPageObj = new MainPageBurger(driver);

        switch (item) {
            case "Соусы":
                mainPageObj.clickSauce();
                Assert.assertTrue("Соусы не активны", mainPageObj.isSauceActive());
                break;
            case "Начинки":
                mainPageObj.clickFilling();
                Assert.assertTrue("Начинки не активны", mainPageObj.isFillingActive());
                break;
            case "Булки":
                mainPageObj.clickFilling();
                mainPageObj.clickBun();
                Assert.assertTrue("Булки не активны", mainPageObj.isBunActive());
        }
    }
}
