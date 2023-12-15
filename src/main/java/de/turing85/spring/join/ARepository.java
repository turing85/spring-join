package de.turing85.spring.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARepository extends JpaRepository<A, Integer> {
  @Query("""
      SELECT a FROM A a
      INNER JOIN a.bs b
      WHERE b.status = -1
      """)
  List<A> findByBStatusMinusOne();
}
