package de.turing85.spring.join;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("as")
@RequiredArgsConstructor
public class Controller {
  private final ARepository repository;

  @GetMapping
  List<A> getAllAs() {
    return repository.findAll();
  }

  @GetMapping(path = "bMinusOne")
  List<A> getAllAsWithBMinusOne() {
    return repository.findByBStatusMinusOne();
  }
}
