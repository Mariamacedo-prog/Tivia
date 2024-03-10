package com.br.tiviaDT.dtos;


import org.springframework.beans.factory.annotation.Autowired;

import com.br.tiviaDT.enums.TipoDocumento;
import com.br.tiviaDT.models.Documento;

public class DocumentoRequestDTO {
	private TipoDocumento tipoDocumento;
	private String descricao;
	
	public DocumentoRequestDTO() {}
	
	@Autowired
	public DocumentoRequestDTO(Documento documentoModel) {
	    setTipoDocumento(documentoModel.getTipoDocumento());
	    setDescricao(documentoModel.getDescricao());
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
}
