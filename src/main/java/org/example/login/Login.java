package org.example.login;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

    public void logIn (String username, String password) {
        LoginRequest loginBody = LoginRequest.builder()
                .username(username)
                .password(password)
                .build();

        RestAssured.baseURI = "https://www.demoblaze.com/index.html";
        RequestSpecification request = RestAssured.given().config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)))
                .contentType(ContentType.JSON)
                .body(loginBody);

        Response response =request.post();
        System.out.println("to jest response: " + response.getBody());
    }
}
