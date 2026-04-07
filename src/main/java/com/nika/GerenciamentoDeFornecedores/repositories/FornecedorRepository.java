package com.nika.GerenciamentoDeFornecedores.repositories;

import com.nika.GerenciamentoDeFornecedores.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
