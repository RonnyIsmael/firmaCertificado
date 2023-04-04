package com.firmaCertificados.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmaCertificados.demo.model.entity.Usuario;
import com.firmaCertificados.demo.service.UsuarioServiceAux;

@RestController
@RequestMapping("/api/usuario/")
public class usuarioREST {
	@Autowired
	UsuarioServiceAux usuarioService;
	
	@PostMapping
	private ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		Usuario usuarioTemp = usuarioService.create(usuario);
		
		try {
			return ResponseEntity.created(new URI("/api/usuario" + usuarioTemp.getId())).body(usuarioTemp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	private ResponseEntity<List<Usuario>> listUsuarios() {
		return ResponseEntity.ok(usuarioService.getAllUsuarios());
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Usuario>> findUsuarioById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(usuarioService.findUsuario(id));
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deleteUsuario(@RequestBody Usuario usuario){
		usuarioService.delete(usuario);
		return ResponseEntity.ok().build();
	}
	
}
