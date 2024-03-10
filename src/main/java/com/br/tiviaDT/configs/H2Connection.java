package com.br.tiviaDT.configs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.dtos.DocumentoResponseDTO;
import com.br.tiviaDT.models.Beneficiario;
import com.br.tiviaDT.models.Documento;
import com.br.tiviaDT.services.BeneficiarioService;
import com.br.tiviaDT.services.DocumentoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Connection implements CommandLineRunner{
	
    private final BeneficiarioService beneficiarioService;
    private final DocumentoService documentoService;
	
	public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:C:/git/db", "SA", "12345");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sua_tabela");
            
            while (resultSet.next()) {
                // Manipule os resultados aqui
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	
	   @Autowired
	    public H2Connection(BeneficiarioService beneficiarioService, DocumentoService documentoService) {
	        this.beneficiarioService = beneficiarioService;
	        this.documentoService = documentoService;
	    }

	    @Override
	    public void run(String... args) throws Exception {
	        ResponseEntity<?> beneficiarios = beneficiarioService.findAll();
	        ResponseEntity<List<DocumentoResponseDTO>> documentos = documentoService.findAll();
	    }
}
