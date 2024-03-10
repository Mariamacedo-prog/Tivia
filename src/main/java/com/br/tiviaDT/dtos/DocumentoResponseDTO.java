package com.br.tiviaDT.dtos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.tiviaDT.enums.TipoDocumento;
import com.br.tiviaDT.models.Documento;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DocumentoResponseDTO {

	private Long id;
	
	private TipoDocumento tipoDocumento;
	
	private String descricao;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
	
	public DocumentoResponseDTO() {}
	
	@Autowired
	public DocumentoResponseDTO(Documento documentoModel) {
		setDataAtualizacao(documentoModel.getDataAtualizacao());
		setDataInclusao(documentoModel.getDataInclusao());
	    setTipoDocumento(documentoModel.getTipoDocumento());
	    setId(documentoModel.getId());
	    setDescricao(documentoModel.getDescricao());
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
}
