package com.example.TP1ValentinaLencioni.entidades;

import com.example.TP1ValentinaLencioni.enums.TiposProducto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad{
    //------------ATRIBUTOS------------
    private TiposProducto tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;
    //------------MOSTRAR PRODUCTO------------
    public void mostrarProducto(){
        System.out.println("------------ "+denominacion+ " ------------");
        System.out.println("Precio compra: "+precioCompra);
        System.out.println("Precio venta: "+precioVenta);
        System.out.println("Tipo de producto: "+tipo);
        System.out.println("Receta: "+receta);
        System.out.println("Stock actual: "+stockActual);
        System.out.println("Stock minimo: "+stockMinimo);
        System.out.println("Unidad de medida: "+unidadMedida);
        System.out.println("Tiempo estimado de cocina: "+tiempoEstimadoCocina);

    }
}
