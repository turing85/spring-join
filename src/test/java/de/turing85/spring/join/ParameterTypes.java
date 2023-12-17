package de.turing85.spring.join;

import io.cucumber.java.ParameterType;

import java.util.Arrays;

public class ParameterTypes {
  @ParameterType(value = "((?:[0-9,\\s]|and)*)")
  public Integer[] integers(String integers) {
    return Arrays.stream(integers.split("(,|and)\\s*"))
        .map(String::trim)
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
  }
}
