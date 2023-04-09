package ru.yandex.praktikum;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;
import static ru.yandex.praktikum.UrlEndpointsConst.*;

public class UserClient {

    @Step("запрос на авторизацию существующего пользователя")
    public String loginExistingUser(String json) {
        String token = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body("success", equalTo(true))
                .extract().path("accessToken");
        return token;
    }

    @Step("Запрос на создание нового пользователя")
    public String createUser(String json) {
        String token = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(REGISTER)
                .then()//.log().all()
                .assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body("success", equalTo(true))
                .extract().path("accessToken");
        return token;
    }

    @Step("Запрос на удаление существующего пользователя")
    public void deleteUser(String token) {
        given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when()
                .delete(USER);
    }
}
