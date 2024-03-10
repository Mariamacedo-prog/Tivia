package com.br.tiviaDT.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.tiviaDT.models.Beneficiario;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BeneficiarioResponseDTO {
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private LocalDate dataNascimento;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
	
	public BeneficiarioResponseDTO() {}
	
	@Autowired
	public BeneficiarioResponseDTO(Beneficiario beneficiarioModel) {
		setDataNascimento(beneficiarioModel.getDataNascimento());
		setDataAtualizacao(beneficiarioModel.getDataAtualizacao());
		setDataInclusao(beneficiarioModel.getDataInclusao());
	    setNome(beneficiarioModel.getNome());
	    setId(beneficiarioModel.getId());
	    setTelefone(beneficiarioModel.getTelefone()); 
	}
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
