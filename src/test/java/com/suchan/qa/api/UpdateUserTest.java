package com.suchan.qa.api;

import com.suchan.qa.base.BaseTest;
import com.suchan.qa.dto.CurrentUserResponse;
import com.suchan.qa.dto.UpdateUserRequest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UpdateUserTest extends BaseTest {
    @Test
    void updateUser () {
        UpdateUserRequest updateUserRequest = UpdateUserRequest.builder()
                .lastName("channie")
                .build();

        CurrentUserResponse updateUserResponse = given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", 2)
                .body(updateUserRequest)

                .when()
                .put("/users/{id}")

                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .as(CurrentUserResponse.class);

            assertEquals(2, updateUserResponse.getId());
            assertEquals("channie", updateUserResponse.getLastName());
            assertNotNull(updateUserResponse.getEmail());
    }
}
