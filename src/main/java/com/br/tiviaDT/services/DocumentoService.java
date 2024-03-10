package com.br.tiviaDT.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.dtos.DocumentoRequestDTO;
import com.br.tiviaDT.dtos.DocumentoResponseDTO;
import com.br.tiviaDT.models.Beneficiario;
import com.br.tiviaDT.models.Documento;
import com.br.tiviaDT.repositories.DocumentoRepository;

import java.util.logging.Logger;

@Service
public class DocumentoService {
    	private static final Logger logger = Logger.getLogger(DocumentoService.class.getName());

	   private final DocumentoRepository documentoRepository;

	    @Autowired
	    public DocumentoService (DocumentoRepository documentoRepository) {
	        this.documentoRepository = documentoRepository;
	    }
	    
	    public ResponseEntity<List<DocumentoResponseDTO>> findAll() {
	        List<DocumentoResponseDTO> documentos = new ArrayList<>();
	        List<Documento> documentoEntitys = documentoRepository.findAll();

	        for (Documento documento : documentoEntitys) {
	        	DocumentoResponseDTO newDocumentoInfo = new DocumentoResponseDTO(documento);
	        	documentos.add(newDocumentoInfo);
	        }

	        return ResponseEntity.ok(documentos);
	    }

	    public ResponseEntity<?> save(Documento documento) {
	   	 	try {
	   	 		documentoRepository.save(documento);
	 	    	return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            logger.info("Um erro ocorreu enquanto estava salvando o Documento " + "        " + e);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    public ResponseEntity<?> deleteById(Long id) {
	    	 try {
	 	    	documentoRepository.deleteById(id);
	 	    	return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            logger.info("Um erro ocorreu enquanto estava deletando o Documento " + "        " + e);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

		public ResponseEntity<List<DocumentoResponseDTO>> findAllByBeneficiarioId(Long beneficiarioId) {
	        try {
	        	List<DocumentoResponseDTO> documentosResponseList = new ArrayList<DocumentoResponseDTO>();
				List<Documento> documentos = documentoRepository.findAllByBeneficiarioId(beneficiarioId);
				
			    for (Documento documento : documentos) {
			    	DocumentoResponseDTO documentoResponse = new DocumentoResponseDTO(documento); 	
			    	documentosResponseList.add(documentoResponse);
                }
				
	            return ResponseEntity.ok(documentosResponseList);
	        } catch (Exception e) {
	            logger.info("Um erro ocorreu enquanto estava buscando o  Documento " + "        " + e);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
		}
}
