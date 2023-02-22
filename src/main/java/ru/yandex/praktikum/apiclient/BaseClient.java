package ru.yandex.praktikum.apiclient;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import ru.yandex.praktikum.BurgerConst;

public class BaseClient {

    protected static RequestSpecification requestSpecification = RestAssured.given()
            .baseUri(BurgerConst.BURGER_URL);
}
