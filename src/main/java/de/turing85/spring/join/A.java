package de.turing85.spring.join;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "table_a")
@Data
public class A {
  @Id
  @Column(name = "id")
  private Integer id;

  @OneToMany(mappedBy = "a", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<B> bs;
}
