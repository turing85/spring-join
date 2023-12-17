package de.turing85.spring.join.actors;

import io.cucumber.spring.ScenarioScope;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

@Component
@ScenarioScope
public class ControllerActor {
  private final int port;

  public ControllerActor(
      @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
      @LocalServerPort
      int port) {
    this.port = port;
  }

  private Response response;

  public void get(String path) {
    response = RestAssured.when().get("http://localhost:%d/%s".formatted(port, path));
  }

  public void responseHasIds(Integer... ids) {
    Optional.ofNullable(response)
            .orElseThrow(() -> new IllegalStateException("response is not set"));
    response.then().assertThat()
        .statusCode(HttpStatus.OK.value())
        .body("size()", is(ids.length))
        .body("collect { it.id }", hasItems(ids));
  }

}
