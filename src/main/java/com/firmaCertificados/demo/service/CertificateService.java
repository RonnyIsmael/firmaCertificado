package com.firmaCertificados.demo.service;

import com.firmaCertificados.demo.model.entity.Certificate;
import com.firmaCertificados.demo.model.entity.dto.CertificateDTO;

public interface CertificateService {
	public Certificate getCertificateByUser();
	public void guardarCert(CertificateDTO cert);
}
