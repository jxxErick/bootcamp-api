package com.bootcamp.api.repositories;

import com.bootcamp.api.domain.Dev;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DevRepository extends JpaRepository<Dev, Integer> {


}