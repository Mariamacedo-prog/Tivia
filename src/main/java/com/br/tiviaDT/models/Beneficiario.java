package com.br.tiviaDT.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
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
@Table(name = "BENEFICIARIO")
@AllArgsConstructor
@Data
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "data_nascimento")
    private LocalDate dataNascimento;
	
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;
	
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	public Beneficiario() {}
	
	public Beneficiario(String nome, String telefone, LocalDate dataNascimento, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
		setDataNascimento(dataNascimento);
		setDataAtualizacao(dataInclusao);
		setDataInclusao(dataAtualizacao);
	    setNome(nome);
	    setTelefone(telefone);
	}
	
	public Beneficiario(BeneficiarioResponseDTO beneficiarioDto) {
		setDataNascimento(beneficiarioDto.getDataNascimento());
		setDataAtualizacao(beneficiarioDto.getDataAtualizacao());
		setDataInclusao(beneficiarioDto.getDataInclusao());
	    setNome(beneficiarioDto.getNome());
	    setTelefone(beneficiarioDto.getTelefone());
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
