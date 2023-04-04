package com.firmaCertificados.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firmaCertificados.demo.service.FirmaService;

@RestController
@RequestMapping("/api")
public class FirmaController {
    @Autowired
    private FirmaService firmaService;

    @PostMapping("/firma")
    public ResponseEntity<byte[]> firma(@RequestBody byte[] fileContent) {
        byte[] modifiedFile = firmaService.firma(fileContent);
        return ResponseEntity.ok(modifiedFile);
    }
}
