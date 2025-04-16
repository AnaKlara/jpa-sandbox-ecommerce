package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria extends EntidadeBaseInteger {

    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai") //nome da propriedade na classe
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias") //nome da propriedade na classe
    private List<Produto> produtos;
}
