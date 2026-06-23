package com.mycompany.mavenproject1;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class RestAssured1Test {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dotesthere.com/api";
    }

    @Test
    public void getUsers_returnsExpectedResponse() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users")
            //.prettyPeek()
        .then()
            .log().body()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("page", equalTo(1))
            .body("per_page", equalTo(10))
            .body("total", equalTo(2))
            .body("total_pages", equalTo(1))
            .body("data.size()", equalTo(2))
            .body("data[0].id", equalTo(1))
            .body("data[0].email", equalTo("ankur.automation@dotesthere.com"))
            .body("data[0].first_name", equalTo("Ankur"))
            .body("data[0].last_name", equalTo("Autoamtion"))
            .body("data[0].avatar", equalTo("https://dotesthere.com/img/faces/1-image.jpg"))
            .body("data[1].id", equalTo(2))
            .body("data[1].email", equalTo("janet.weaver@dotesthere.com"))
            .body("data[1].first_name", equalTo("Janet"))
            .body("data[1].last_name", equalTo("Weaver"))
            .body("data[1].avatar", equalTo("https://dotesthere.com/img/faces/2-image.jpg"));
    }

    @Test
    public void getUser1_returnsExpectedResponse() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users/1")
            //.prettyPeek()
        .then()
            .log().body()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("data.id", equalTo(1))
            .body("data.email", equalTo("ankur.automation@dotesthere.com"))
            .body("data.first_name", equalTo("Ankur"))
            .body("data.last_name", equalTo("Autoamtion"))
            .body("data.avatar", equalTo("https://dotesthere.com/img/faces/1-image.jpg"));
    }

    @Test
    public void putUser1_returnsExpectedResponse() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"name\": \"John Updated\", \"job\": \"Senior Developer\"}")
        .when()
            .put("/users/1")
        .then()
            .log().body()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("data.id", equalTo(1))
            .body("data.email", equalTo("ankur.automation@dotesthere.com"))
            .body("data.first_name", equalTo("Ankur"))
            .body("data.last_name", equalTo("Autoamtion"))
            .body("data.avatar", equalTo("https://dotesthere.com/img/faces/1-image.jpg"))
            .body("data.name", equalTo("John Updated"))
            .body("data.job", equalTo("Senior Developer"));
    }

    @Test
    public void post1_returnsExpectedResponse() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"name\": \"Ankur Malviya\", \"job\": \"Developer\"}")
        .when()
            .post("/users")
        .then()
            .log().body()
            .statusCode(201)
            .contentType(ContentType.JSON)
            .body("name", equalTo("Ankur Malviya"))
            .body("job", equalTo("Test Engineer"))
            .body("id", equalTo("123"))
            .body("createdAt", equalTo("2023-01-01T12:00:00.000Z"));
    }

    @Test
    public void delete_returnsExpectedResponse() {
         given()
            .contentType(ContentType.JSON)
        .when()
            .delete("/users/1")
        .then()
            .log().body()
            .statusCode(204);
    }
}
