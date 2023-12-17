package de.turing85.spring.join.controller;

import de.turing85.spring.join.actors.ControllerActor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Steps {
  private final ControllerActor controllerActor;

  @When("^I get /(.*)$")
  public void whenIGet(String path) {
    controllerActor.get(path);
  }

  @Then("I expect As with Ids {integers}")
  public void thenExpectAsWithIds(Integer... ids) {
    controllerActor.responseHasIds(ids);
  }
}
