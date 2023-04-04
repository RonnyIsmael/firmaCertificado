package com.firmaCertificados.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Certificate implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String certificado;
    private String subido;
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "Id")
    private Usuario usuario;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return certificado;
	}

	public void setFileName(String fileName) {
		this.certificado = fileName;
	}
	
	public String getSubido() {
		return subido;
	}

	public void setSubido(String subido) {
		this.subido = subido;
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
		this.usuario = user;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", certificado=" + certificado + ", subido=" + subido + ", usuario=" + usuario
				+ "]";
	}

	public Certificate(String certificado, String subido, Usuario usuario) {
		super();
		this.certificado = certificado;
		this.subido = subido;
		this.usuario = usuario;
	}

    public Certificate() {
    }
}
