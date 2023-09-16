package com.example.TP1ValentinaLencioni.entidades;

import com.example.TP1ValentinaLencioni.enums.FormasPago;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{
    //-------------ATRIBUTOS-------------
    private int numero;
    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private FormasPago formaPago;
    private double descuento;
    private int total;

    //-------------MOSTRAR DATOS-------------
    public void mostrarFactura(){
        System.out.println("Factura numero: "+numero);
        System.out.println("Fecha: "+fecha);
        System.out.println("Descuento: "+descuento);
        System.out.println("Forma de pago: "+formaPago);
        System.out.println("Total: "+total);

    }
}
