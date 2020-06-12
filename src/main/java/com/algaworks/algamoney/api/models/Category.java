package com.algaworks.algamoney.api.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //specify that our table is gonna input values for it
    private Long codigo;

    private String nome;

    public Long getCategoryCode() {
        return codigo;
    }

    public void setCategoryCode(Long categoryCode) {
        this.codigo = categoryCode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(codigo, category.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
