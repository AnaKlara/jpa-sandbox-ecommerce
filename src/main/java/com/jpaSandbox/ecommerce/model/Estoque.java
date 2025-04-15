package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidade;

    private Long versao;
}
