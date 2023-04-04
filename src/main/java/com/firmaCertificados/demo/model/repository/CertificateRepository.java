package com.firmaCertificados.demo.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmaCertificados.demo.model.entity.Certificate;
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long>{
}
