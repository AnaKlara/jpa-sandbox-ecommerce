package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categoria",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" }) })
public class Categoria extends EntidadeBaseInteger {

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id",
            foreignKey = @ForeignKey(name = "fk_categoria_categoriapai"))
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai") //nome da propriedade na classe
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias") //nome da propriedade na classe
    private List<Produto> produtos;
}
