
package com.firmaCertificados.demo.service;

import org.springframework.web.multipart.MultipartFile;


public interface UploadService {

	public String save(MultipartFile file);
}
