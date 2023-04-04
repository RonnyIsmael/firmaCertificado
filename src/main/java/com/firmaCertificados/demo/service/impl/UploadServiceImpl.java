package com.firmaCertificados.demo.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.firmaCertificados.demo.model.entity.Usuario;
import com.firmaCertificados.demo.model.entity.dto.CertificateDTO;
import com.firmaCertificados.demo.service.CertificateService;
import com.firmaCertificados.demo.service.FirmaService;
import com.firmaCertificados.demo.service.UploadService;
import com.firmaCertificados.demo.service.UsuarioService;
@Service
public class UploadServiceImpl implements UploadService{
	private String folder="cargas//";
	private final Logger log = LoggerFactory.getLogger(UploadService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	FirmaService firmaService;
	@Autowired
	CertificateService certificateService;
	@Autowired
	UsuarioService usuarioService;
	@Override
	public String save(MultipartFile file){
		if(!file.isEmpty()) {
			try {
				byte [] bytes = file.getBytes();
				// bytes = restTemplate.postForObject("http://localhost:8080/api/firma", file.getBytes(), byte[].class);
				bytes = firmaService.firma(bytes);
				Path path = Paths.get(folder + file.getOriginalFilename());
				Files.write(path, bytes);
				certificateService.guardarCert(new CertificateDTO(file.getOriginalFilename(), "SI",  usuarioService.findUsuarioByEmail(usuarioService.getUsuarioSession())));
				log.info("File saved");
			} catch (IOException e) {
				log.info("Error: " + e.getMessage());
			}
		}
		return "Certificado guardado correctamente";
	}
}
