package com.population.census.data.repository;

import com.population.census.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CensusRepository extends JpaRepository<Person,Long> {
}
