package com.br.tiviaDT.controllers;

import java.util.List;

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

import com.br.tiviaDT.dtos.BeneficiarioRequestDTO;
import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.models.Beneficiario;
import com.br.tiviaDT.services.BeneficiarioService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @Operation(summary = "Lista Beneficiarios", description = "Lista todos os Beneficiarios")
    @GetMapping
    public ResponseEntity<?> getAllBeneficiarios() {
        return beneficiarioService.findAll();
    }

    @Operation(summary = "Lista Beneficiario", description = "Lista todos os Beneficiario pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getBeneficiarioById(@PathVariable Long id) {
        return beneficiarioService.findById(id);
    }

    @Operation(summary = "Cria Beneficiario", description = "Criação de beneficiario e de seus documentos  (OBS: o campo TipoDocumento só aceita os dados do ENUM TipoDocumento)")
    @PostMapping
    public ResponseEntity<?> createBeneficiario(@RequestBody BeneficiarioRequestDTO beneficiario) {
          return beneficiarioService.save(beneficiario);
    }
    
    @Operation(summary = "Atualiza Beneficiario", description = "Permite atualizar o beneficiario pelo ID e adicionar NOVOS documentos    (OBS: o campo TipoDocumento só aceita os dados do ENUM TipoDocumento)")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBeneficiario(@PathVariable Long id, @RequestBody BeneficiarioRequestDTO beneficiario) {
        return beneficiarioService.update(beneficiario,id);
    }

    @Operation(summary = "Deleta Beneficiario", description = "Deleta o Beneficiario pelo Id, e todos os seus documentos")
    @DeleteMapping("/{id}")
    public void deleteBeneficiario(@PathVariable Long id) {
        beneficiarioService.deleteById(id);
    }
}