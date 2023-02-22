package ru.yandex.praktikum.apiclient;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.BurgerConst;

import static io.restassured.RestAssured.given;

//реализация взаимодействия с User (авторизация, регистрация и пр)
public class UserClient extends BaseClient {


    @Step("Извлечение accessToken")
    public static String getAccessToken(Response response) {

        return response.body().as(AuthAnswerBean.class).getAccessToken().replace("Bearer ", "");
    }

    @Step("Удаление пользователя (DELETE /api/auth/user)")
    public static Response deleteUser(String accessToken) {
        return given(requestSpecification)
                .auth().oauth2(accessToken)
                .delete(BurgerConst.BURGER_API_USER_DELETE);
    }

    @Step("Авторизация пользователя (POST /api/auth/login)")
    public static Response loginUser(UserLoginBean userLogin) {
        return given(requestSpecification)
                .header("Content-type", "application/json")
                .and()
                .body(userLogin).when()
                .post(BurgerConst.BURGER_API_USER_AUTH);
    }
}
