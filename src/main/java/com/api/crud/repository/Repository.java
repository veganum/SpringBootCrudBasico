package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.models.Persona;

public interface Repository extends JpaRepository<Persona, Long> {

}
