package de.turing85.spring.join;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "table_b")
@Data
public class B {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "status")
  Integer status;

  @ManyToOne
  @JoinColumn(name = "a_id", insertable = false, updatable = false)
  A a;
}