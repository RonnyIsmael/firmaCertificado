package com.firmaCertificados.demo.model.entity.dto;

import com.firmaCertificados.demo.model.entity.Usuario;

public class CertificateDTO {
	private Long id;
    private String certificado;
    private String subido;
    private Usuario usuario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public String getSubido() {
		return subido;
	}
	public void setSubido(String subido) {
		this.subido = subido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public CertificateDTO(String certificado, String subido, Usuario usuario) {
		super();
		this.certificado = certificado;
		this.subido = subido;
		this.usuario = usuario;
	}
    
}
