package com.bootcamp.api.repositories;

import com.bootcamp.api.domain.Conteudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConteudoRepository extends JpaRepository<Conteudo, Integer> {


}