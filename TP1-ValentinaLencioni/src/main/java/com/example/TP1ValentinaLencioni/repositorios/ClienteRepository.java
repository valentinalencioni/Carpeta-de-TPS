package com.example.TP1ValentinaLencioni.repositorios;

import com.example.TP1ValentinaLencioni.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
