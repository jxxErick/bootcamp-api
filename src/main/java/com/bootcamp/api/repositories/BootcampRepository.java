package com.bootcamp.api.repositories;

import com.bootcamp.api.domain.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BootcampRepository extends JpaRepository<Bootcamp, Integer> {


        }