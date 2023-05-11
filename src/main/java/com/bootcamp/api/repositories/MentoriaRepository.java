package com.bootcamp.api.repositories;

import com.bootcamp.api.domain.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MentoriaRepository extends JpaRepository<Mentoria, Integer> {


}