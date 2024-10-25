package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.model.SmartPhone;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}