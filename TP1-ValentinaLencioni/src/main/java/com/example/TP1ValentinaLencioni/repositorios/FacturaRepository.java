package com.example.TP1ValentinaLencioni.repositorios;

import com.example.TP1ValentinaLencioni.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
