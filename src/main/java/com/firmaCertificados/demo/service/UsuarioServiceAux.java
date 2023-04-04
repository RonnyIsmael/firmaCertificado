package com.firmaCertificados.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firmaCertificados.demo.model.entity.Usuario;
import com.firmaCertificados.demo.model.repository.UsuarioRepository;
@Service
public class UsuarioServiceAux {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findUsuario(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
