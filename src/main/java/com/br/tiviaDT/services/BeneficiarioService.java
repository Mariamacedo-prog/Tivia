package com.br.tiviaDT.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.tiviaDT.dtos.BeneficiarioRequestDTO;
import com.br.tiviaDT.dtos.BeneficiarioResponseDTO;
import com.br.tiviaDT.dtos.DocumentoRequestDTO;
import com.br.tiviaDT.enums.TipoDocumento;
import com.br.tiviaDT.models.Beneficiario;
import com.br.tiviaDT.models.Documento;
import com.br.tiviaDT.repositories.BeneficiarioRepository;
import com.br.tiviaDT.repositories.DocumentoRepository;

@Service
public class BeneficiarioService {
	
	private static final Logger logger = Logger.getLogger(BeneficiarioService.class.getName());

    private final BeneficiarioRepository beneficiarioRepository;
    
    private final DocumentoRepository documentoRepository;

    @Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository, DocumentoRepository documentoRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
        this.documentoRepository= documentoRepository;
    }
    
    public ResponseEntity<List<BeneficiarioResponseDTO>> findAll() {
        List<BeneficiarioResponseDTO> beneficiarios = new ArrayList<>();
        List<Beneficiario> beneficiarioEntitys = beneficiarioRepository.findAll();

        for (Beneficiario beneficiario : beneficiarioEntitys) {
            BeneficiarioResponseDTO newBeneficiarioInfo = new BeneficiarioResponseDTO(beneficiario);
            beneficiarios.add(newBeneficiarioInfo);
        }

        return ResponseEntity.ok(beneficiarios);
    }

    public ResponseEntity<?> findById(Long id) {
    	 try {
             Optional<Beneficiario> findBeneficiario = beneficiarioRepository.findById(id);

             if (findBeneficiario.isPresent()) {
                 Beneficiario beneficiario = findBeneficiario.get();
                 BeneficiarioResponseDTO newBeneficiarioInfo = new BeneficiarioResponseDTO(beneficiario);
                 return ResponseEntity.ok(newBeneficiarioInfo);
             } else {
                 return ResponseEntity.notFound().build();
             }
             
         } catch (Exception e) {
        	 logger.info("Um erro ocorreu procurando pelo Beneficiario pelo id: " + id + "   " + e);
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }
   
    public ResponseEntity<?> save(BeneficiarioRequestDTO beneficiario) {
        try {
             List<DocumentoRequestDTO> documentoList = beneficiario.getDocumentos();

            Beneficiario beneficiarioEntity = new Beneficiario(beneficiario.getNome(), beneficiario.getTelefone(),
                    beneficiario.getDataNascimento(), LocalDateTime.now(), LocalDateTime.now());

            Beneficiario newBeneficiario = beneficiarioRepository.save(beneficiarioEntity);


            if (documentoList != null && documentoList.size() >= 1) {
                for (DocumentoRequestDTO documento : documentoList) {
                    Documento newDocumento = new Documento(LocalDateTime.now(), LocalDateTime.now(), documento, newBeneficiario);
                    Documento saveDocumento = documentoRepository.save(newDocumento);
                }
            }
            return ResponseEntity.ok(newBeneficiario);
        } catch (Exception e) {
            logger.info("Um erro ocorreu enquanto estava salvando Beneficiario" + "        " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    public ResponseEntity<?> update(BeneficiarioRequestDTO beneficiarioRequest, Long id) {
        try {
            Beneficiario beneficiarioFound = beneficiarioRepository.findById(id).orElse(null);
            
            if (beneficiarioFound != null) {
            	 List<DocumentoRequestDTO> documentoList = beneficiarioRequest.getDocumentos();
            	
            	if(!beneficiarioRequest.getNome().isEmpty()) {
            		beneficiarioFound.setNome(beneficiarioRequest.getNome());
            	}           	
            	if(!beneficiarioRequest.getTelefone().isEmpty()) {
            		beneficiarioFound.setTelefone(beneficiarioRequest.getTelefone());
            	}           	
            	if(beneficiarioRequest.getDataNascimento() != null) {
            		beneficiarioFound.setDataNascimento(beneficiarioRequest.getDataNascimento());
            	}           	
            	beneficiarioFound.setDataAtualizacao(LocalDateTime.now());              
                Beneficiario newBeneficiario = beneficiarioRepository.save(beneficiarioFound);
                              
                if (documentoList != null && documentoList.size() >= 1) {
                    for (DocumentoRequestDTO documento : documentoList) {
                        Documento newDocumento = new Documento(LocalDateTime.now(), LocalDateTime.now(), documento, newBeneficiario);
                        Documento saveDocumento = documentoRepository.save(newDocumento);
                    }
                }
                
                return ResponseEntity.ok(newBeneficiario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.info("Um erro ocorreu enquanto estava salvando Beneficiario" + "        " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
 
    public ResponseEntity<?> deleteById(Long id) {
        try {
            List<Documento> documentoEntitys = documentoRepository.findAllByBeneficiarioId(id);
            
            for (Documento documento : documentoEntitys) {
                documentoRepository.deleteById(documento.getId());
            }
            
            beneficiarioRepository.deleteById(id);
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.info("Um erro ocorreu ao tentar deletar o Beneficiario" + "    " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
