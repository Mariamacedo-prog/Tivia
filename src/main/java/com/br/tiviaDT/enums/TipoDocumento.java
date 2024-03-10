package com.br.tiviaDT.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "TipoDocumento", description = "Tipos de Documentos")
public enum TipoDocumento {
	 	@Schema(description = "Carteira de Identidade (RG)")
	    RG("Carteira de Identidade (RG)"),

	    @Schema(description = "Cadastro de Pessoa Física (CPF)")
	    CPF("Cadastro de Pessoa Física (CPF)"),

	    @Schema(description = "Passaporte")
	    PASSAPORTE("Passaporte"),

	    @Schema(description = "Carteira Nacional de Habilitação (CNH)")
	    CNH("Carteira Nacional de Habilitação (CNH)"),

	    @Schema(description = "Conta de Luz")
	    CONTA_DE_LUZ("Conta de Luz"),

	    @Schema(description = "Contrato de Aluguel")
	    CONTRATO_DE_ALUGUEL("Contrato de Aluguel"),

	    @Schema(description = "Declaração de Residência")
	    DECLARACAO_DE_RESIDENCIA("Declaração de Residência"),

	    @Schema(description = "Extrato Bancário")
	    EXTRATO_BANCARIO("Extrato Bancário"),

	    @Schema(description = "Comprovante de Renda")
	    COMPROVANTE_DE_RENDA("Comprovante de Renda"),

	    @Schema(description = "Carteira de Trabalho e Previdência Social (CTPS)")
	    CARTEIRA_DE_TRABALHO("Carteira de Trabalho e Previdência Social (CTPS)"),

	    @Schema(description = "Contrato de Trabalho")
	    CONTRATO_DE_TRABALHO("Contrato de Trabalho");

    private String value;

    TipoDocumento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static TipoDocumento getEnumByString(String str) {
        for (TipoDocumento e : TipoDocumento.values()) {
            if (str.equalsIgnoreCase(e.getValue()) || str.equalsIgnoreCase(e.name()))
                return e;
        }
        return null;
    }
}
