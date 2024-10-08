package com.ProjetoTestHospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoTestHospede.entity.Hospede;

public interface HospedeRepository extends JpaRepository <Hospede, Long> {

}
