package com.suchan.qa.api;

import com.suchan.qa.base.BaseTest;
import com.suchan.qa.dto.DeleteUserResponse;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteUserApiTest extends BaseTest {
    @Test
    void deleteUserTest () {
        DeleteUserResponse deleteUserResponse = given()
                .pathParam("id", 1)

                .when()
                .delete("/users/{id}")

                .then()
                .statusCode(200)
                .log().ifValidationFails()
                .extract()
                .as(DeleteUserResponse.class);

        assertEquals(1, deleteUserResponse.getId());
        assertTrue(deleteUserResponse.getIsDeleted());
        assertNotNull(deleteUserResponse.getFirstName());
        assertNotNull(deleteUserResponse.getDeletedOn());
    }
}
