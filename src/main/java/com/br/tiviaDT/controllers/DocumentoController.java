package com.br.tiviaDT.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tiviaDT.dtos.DocumentoRequestDTO;
import com.br.tiviaDT.dtos.DocumentoResponseDTO;
import com.br.tiviaDT.models.Documento;
import com.br.tiviaDT.services.DocumentoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {
	 private final DocumentoService documentoService;

	    @Autowired
	    public DocumentoController(DocumentoService documentoService) {
	        this.documentoService = documentoService;
	    }

	    @Operation(summary = "Documentos por Beneficiario", description = "Lista todos os documentos encontrados pelo BeneficiarioId")
	    @GetMapping("/{beneficiarioId}")
	    public ResponseEntity<List<DocumentoResponseDTO>> getBeneficiarioById(@PathVariable Long beneficiarioId) {
	        return documentoService.findAllByBeneficiarioId(beneficiarioId);
	    }	    
}
