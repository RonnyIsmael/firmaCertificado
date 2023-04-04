package com.firmaCertificados.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.firmaCertificados.demo.model.entity.Certificate;
import com.firmaCertificados.demo.model.entity.Usuario;
import com.firmaCertificados.demo.model.entity.dto.CertificateDTO;
import com.firmaCertificados.demo.model.repository.CertificateRepository;
import com.firmaCertificados.demo.model.repository.UsuarioRepository;
import com.firmaCertificados.demo.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	CertificateRepository certificateRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Certificate getCertificateByUser() {
		Long userId = null;
		Certificate cert = new Certificate();
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) authentication.getPrincipal();

				Usuario usuario = usuarioRepository.findByEmail(userDetails.getUsername());
				userId = usuario.getId();
			}

			if (certificateRepository.getById(userId).getUser() != null) {
				cert = certificateRepository.getById(userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cert;
	}

	@Override
	public void guardarCert(CertificateDTO certDto) {
		Certificate cert = new Certificate(certDto.getCertificado(), certDto.getSubido(), certDto.getUsuario());
		certificateRepository.save(cert);
	}

}
