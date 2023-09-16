package com.example.TP1ValentinaLencioni.repositorios;

import com.example.TP1ValentinaLencioni.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
