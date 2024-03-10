package com.br.tiviaDT.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tiviaDT.enums.TipoDocumento;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/enum")
public class EnumController {

    @Operation(summary = "Valores do Enum TipoDocumento", description = "Retorna todos os valores aceitos no Enum TipoDocumento")
    @GetMapping("/tipoDocumento")
    public ResponseEntity<List<String>> getTipoDocumentoEnumValues() {
        List<String> tipoDocumentoValues = Arrays.stream(TipoDocumento.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tipoDocumentoValues);
    }
}