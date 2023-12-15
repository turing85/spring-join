package de.turing85.spring.join;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Contoller Tests")
@Sql({ "/data.sql" })
class ControllerTest {

  @LocalServerPort
  private Integer port;

  @Container
  @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.1-alpine3.19");

  @Test
  @DisplayName("Get All A's")
  void getAll() {
    // @formatter: off
    RestAssured
        .when().get("http://localhost:%d/%s".formatted(port, Controller.PATH))
        .then().assertThat()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(3))
            .body("find { it.id == 0 }", is(notNullValue()))
            .body("find { it.id == 1 }", is(notNullValue()))
            .body("find { it.id == 2 }", is(notNullValue()));
    // @formatter: on
  }

  @Test
  @DisplayName("Get All A's with at least one B in status -1")
  void getBMinusOne() {
    // @formatter: off
    RestAssured
        .when().get("http://localhost:%d/%s/bMinusOne".formatted(port, Controller.PATH))
        .then().assertThat()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(2))
            .body("find { it.id == 0 }", is(notNullValue()))
            .body("find { it.id == 1 }", is(notNullValue()));
    // @formatter: on
  }
}