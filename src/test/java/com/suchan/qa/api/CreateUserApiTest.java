package com.suchan.qa.api;

import com.suchan.qa.base.BaseTest;
import com.suchan.qa.utils.ConfigReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;

public class CreateUserApiTest extends BaseTest {
    @Test
    void createUserTest() {
        Map<String, Object> createUserRequest = new HashMap<>();
        createUserRequest.put("name", "Su");
        createUserRequest.put("job", "QA Engineer");

        given()
                .contentType(ContentType.JSON)
                .header("x-api-key", ConfigReader.getProperty("api.key")) // ConfigReader클래스에 깃에 올라가면 안되는 정보 저장
                //request body
                .body(createUserRequest)

                .when()
                    .post("/api/users")

                .then().statusCode(201)
                    // response body
                    .body("name", equalTo("Su"))
                    .body("job", equalTo("QA Engineer"))
                    .log().all();

    }
}
