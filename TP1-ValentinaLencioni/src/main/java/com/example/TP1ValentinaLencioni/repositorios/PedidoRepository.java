package com.example.TP1ValentinaLencioni.repositorios;

import com.example.TP1ValentinaLencioni.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
