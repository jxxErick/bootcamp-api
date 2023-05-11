package com.bootcamp.api.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
public class Dev implements Serializable {
    private static final long serialVersionUID = 1L;

    public Dev(Integer id, String nome, Set<Bootcamp> bootcampInscritos) {
        this.id = id;
        this.nome = nome;
        this.bootcampInscritos = bootcampInscritos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy="conteudo", cascade=CascadeType.ALL)
    private Set<Bootcamp> bootcampInscritos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Bootcamp> getBootcampInscritos() {
        return bootcampInscritos;
    }

    public void setBootcampInscritos(Set<Bootcamp> bootcampInscritos) {
        this.bootcampInscritos = bootcampInscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }


}