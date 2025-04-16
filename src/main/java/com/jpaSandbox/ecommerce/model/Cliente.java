package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Transient // campo ignorado pelo JPA
    private String primeiroNome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

    // não é obrigatório explicitar a classe not-owner do relacionamento
    @OneToMany(mappedBy = "cliente") // no atributo cliente da classe Pedido está os meta dados do relacionamento
    private List<Pedido> pedidos;

    @PostLoad // toda vez que carregar da base de dados
    public void configurarPrimeiroNome(){
        if(nome != null && !nome.isBlank()) {
            int index = nome.indexOf(" ");
            primeiroNome = nome.substring(0,index);
        }
    }
}
