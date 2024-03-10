package com.br.tiviaDT.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.br.tiviaDT.models.Beneficiario;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class BeneficiarioRequestDTO {
	private String nome;
	private String telefone;
	private LocalDate dataNascimento;
	private List<DocumentoRequestDTO> documentos;
	
	public BeneficiarioRequestDTO() {}
	
	@Autowired
	public BeneficiarioRequestDTO(Beneficiario beneficiarioModel) {
		setDataNascimento(beneficiarioModel.getDataNascimento());
	    setNome(beneficiarioModel.getNome());
	    setTelefone(beneficiarioModel.getTelefone());
	    setDocumentos(new ArrayList<>()); 
	}
	
	@Autowired
	public BeneficiarioRequestDTO(Beneficiario beneficiarioModel, List<DocumentoRequestDTO> documentos) {
		setDataNascimento(beneficiarioModel.getDataNascimento());
	    setNome(beneficiarioModel.getNome());
	    setTelefone(beneficiarioModel.getTelefone());
	    setDocumentos(documentos);
	}
	
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public List<DocumentoRequestDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoRequestDTO> documentos) {
        this.documentos = documentos;
    }
}
