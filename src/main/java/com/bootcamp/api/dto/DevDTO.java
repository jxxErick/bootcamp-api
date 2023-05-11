package com.bootcamp.api.dto;

import com.bootcamp.api.domain.Bootcamp;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class DevDTO implements Serializable {
    public DevDTO(Integer id, String nome, Set<Bootcamp> bootcampInscritos) {
        this.id = id;
        this.nome = nome;
        this.bootcampInscritos = bootcampInscritos;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy="conteudo", cascade= CascadeType.ALL)
    private Set<Bootcamp> bootcampInscritos = new LinkedHashSet<>();

    public devDTO(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
