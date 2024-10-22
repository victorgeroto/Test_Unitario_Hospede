package com.ProjetoTestHospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoTestHospede.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}

