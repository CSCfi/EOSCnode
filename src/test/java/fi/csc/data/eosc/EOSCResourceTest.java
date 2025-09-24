package fi.csc.data.eosc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class EOSCResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/v1/service")
          .then()
             .statusCode(200)
             ;
    }

}