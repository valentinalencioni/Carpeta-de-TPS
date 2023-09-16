package com.example.TP1ValentinaLencioni.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="DetallePedido")
public class DetallePedido extends BaseEntidad{

    //-------------ATRIBUTOS-------------
    private  int cantidad;
    private  double subtotal;

    //-------------RELACIONES-------------
    @ManyToOne()
    @JoinColumn(name = "producto-id")
    private Producto producto;

    //-------------MOSTRAR DATOS-------------
    public void mostrarDetallePedido(){
        System.out.println("-------------DETALLE DE PEDIDO-------------");
        System.out.println("Numero de detalle de pedido: "+this.getId());
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Producto: "+producto.getDenominacion());
        System.out.println("Subtotal: "+subtotal);
    }

}
