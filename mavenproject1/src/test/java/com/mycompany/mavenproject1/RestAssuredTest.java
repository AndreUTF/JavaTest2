package com.mycompany.mavenproject1;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class RestAssuredTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getUsers_returns200AndNonEmptyList() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void getUserById_returnsCorrectUser() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("email", containsString("@"));
    }

    @Test
    public void createPost_returns201AndEchoesTitle() {
        String body = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("foo"));
    }
}
