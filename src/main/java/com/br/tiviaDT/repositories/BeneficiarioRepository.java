package com.br.tiviaDT.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tiviaDT.models.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
	
}