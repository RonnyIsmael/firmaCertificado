package com.firmaCertificados.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.firmaCertificados.demo.model.entity.Certificate;
import com.firmaCertificados.demo.service.CertificateService;
import com.firmaCertificados.demo.service.UploadService;

@Controller
public class homeController {
	@Autowired
	private CertificateService certificateService;
	@Autowired
	private UploadService uploadService;
	
	@GetMapping("/")
	public String index(Model modelo) {
		if(certificateService.getCertificateByUser().getId() != null) {
			modelo.addAttribute("certificado", certificateService.getCertificateByUser());
		}
		return "index";
	}
	
	@GetMapping("/index")
	public String home(Model modelo) {
		if(certificateService.getCertificateByUser().getId()  != null) {
			modelo.addAttribute("certificado", certificateService.getCertificateByUser());
		}
		return "index";
	}
	
	@PostMapping("/cargar")
	public String carga(@RequestParam("archivos") MultipartFile file, RedirectAttributes ms, Model modelo) {
		if(certificateService.getCertificateByUser().getId()  != null) {
			modelo.addAttribute("certificado", certificateService.getCertificateByUser());
		}
		uploadService.save(file);
		ms.addFlashAttribute("mensaje","Archivo guardado correctamente");
		return "redirect:/?exito";
	}
}
