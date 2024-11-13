package org.example.login;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

    public String logIn() {
        LoginRequest loginBody = LoginRequest.builder()
                .username("admin")
                .password("YWRtaW4=")
                .build();

        RestAssured.baseURI = "https://api.demoblaze.com/login";

        RequestSpecification request = RestAssured.given()
                .config(RestAssured.config()
                        .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)))
                .contentType(ContentType.JSON)
                .body(loginBody);

        Response response = request.post();
        String responseBody = response.getBody().asString();
        if (response.getStatusCode() == 200) {
            try {
            LoginResponse loginResponse = new Gson().fromJson(responseBody, LoginResponse.class);
            System.out.println("Zalogowano pomyślnie. Token: " + loginResponse.getAuth_token());
            return loginResponse.getAuth_token();}
            catch (JsonSyntaxException e){
                if (responseBody.contains("Auth_token:")){
                    String token = responseBody.split("Auth_token")[1].trim();
                    System.out.println("token: " + token);
                    return token;
                }
            }
        } else {
            System.out.println("logowanie nie jest poprawne");
            return null;
        }
        return responseBody;
    }
}
