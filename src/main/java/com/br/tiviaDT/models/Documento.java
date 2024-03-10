package com.br.tiviaDT.models;

import java.time.LocalDateTime;

import com.br.tiviaDT.dtos.BeneficiarioRequestDTO;
import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.dtos.DocumentoRequestDTO;
import com.br.tiviaDT.dtos.DocumentoResponseDTO;
import com.br.tiviaDT.enums.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Table(name = "DOCUMENTO")
@Data
public class Documento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_documento", nullable = false, columnDefinition = "SMALLINT CHECK (tipo_documento BETWEEN 0 AND 10)")
    private TipoDocumento tipoDocumento;

	@Column(name = "descricao")
    private String descricao;

	@Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

	@Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "beneficiario_id")
    private Long beneficiarioId;
    
    public Documento (){
    	
    }
    
	public Documento(LocalDateTime dataInclusao,LocalDateTime dataAtualizacao, DocumentoRequestDTO documentoModel, Beneficiario beneficiarioModel) {
		setDataAtualizacao(dataAtualizacao);
		setDataInclusao(dataInclusao);
	    setTipoDocumento(documentoModel.getTipoDocumento());
	    setDescricao(documentoModel.getDescricao());
	    setBeneficiarioId(beneficiarioModel.getId());
	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(Long beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }
}
