package com.firmaCertificados.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firmaCertificados.demo.service.FirmaService;
import com.firmaCertificados.demo.service.UsuarioService;

@Service
public class FirmaServiceImpl implements FirmaService{
	@Autowired
	UsuarioService usuarioService;
	@Override
	public byte[] firma(byte[] file) {
		try {
			String password = usuarioService.getCurrentUserPassword();
			String sfirma = "#firma#" + password;
	        byte[] resultado = new byte[file.length + sfirma.length()];
	        System.arraycopy(file, 0, resultado, 0, file.length);
	        System.arraycopy(sfirma.getBytes(), 0, resultado, file.length, sfirma.length());

	        return resultado;
		}catch (Exception e) {
			e.printStackTrace();
			return file;
		}
		
	}

}
