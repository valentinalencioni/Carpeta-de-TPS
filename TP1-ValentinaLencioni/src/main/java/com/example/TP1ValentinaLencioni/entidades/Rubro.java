package com.example.TP1ValentinaLencioni.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad{
    //------------ATRIBUTOS------------
    private String denominacion;

    //-----------RELACION CON PRODUCTO-----------
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER )
    @Builder.Default
    @JoinColumn(name="rubro-id")
    private List<Producto> productos=new ArrayList<>();

    //-----------METODOS DE PRODUCTO-----------
    public void agregarProductos (Producto producto){
       productos.add(producto);
    }
    public void mostrarProductos(){
        System.out.println("-----------Productos del rubro "+denominacion+" -----------");
        int counter=0;
        for (Producto prod:productos){
            counter+=1;
            System.out.println("---Producto numero: "+counter+" ---");
            prod.mostrarProducto();
        }
    }
}
