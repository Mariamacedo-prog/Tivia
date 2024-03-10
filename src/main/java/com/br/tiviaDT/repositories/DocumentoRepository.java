package com.br.tiviaDT.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.tiviaDT.models.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	List<Documento> findAllByBeneficiarioId(Long id);

	void deleteByBeneficiarioId(Long id);
}