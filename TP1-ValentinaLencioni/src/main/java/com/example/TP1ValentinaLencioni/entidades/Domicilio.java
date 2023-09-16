package com.example.TP1ValentinaLencioni.entidades;

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
public class Domicilio extends BaseEntidad {
    //------------ATRIBUTOS------------
    private String localidad;
    private String numero;
    private String calle;
    //------------MOSTRAR DATOS DEL DOMICILIO------------
    public void mostrarDomicilio(){
        System.out.println("ID domicilio: "+this.getId());
        System.out.println("Calle: " +calle + ", Número: " +numero);
        System.out.println("Localidad: "+localidad);
    }
}
