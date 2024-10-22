package com.ProjetoTestHospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoTestHospede.entity.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
