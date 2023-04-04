package com.firmaCertificados.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.firmaCertificados.demo.model.entity.Usuario;
import com.firmaCertificados.demo.model.entity.dto.UsuarioRegistroDTO;


public interface UsuarioService extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
	public String getCurrentUserPassword();
	
	public String getUsuarioSession();
	
	public Usuario findUsuarioByEmail(String username);
	
}
