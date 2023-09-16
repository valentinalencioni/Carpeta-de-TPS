package com.example.TP1ValentinaLencioni.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad {
    //------------ATRIBUTOS------------
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    //------------MOSTRAR DATOS------------

    public void mostrarCliente(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Email: "+email);
        System.out.println("Telefono: "+telefono);
    }

    //------------RELACION CON DOMICILIOS------------
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "cliente-id")
    private List<Domicilio> domicilios = new ArrayList<>();

        //------------AGREGAR DOMICILIO------------
        public void agregarDomicilio(Domicilio domi) {domicilios.add(domi);}

        //------------MOSTRAR DATOS DEL DOMICILIO
        public void mostrarDomicilios() {
            System.out.println("Domicilios de " + nombre + " " + apellido + ":");
            int counter=0;
            for (Domicilio domicilio : domicilios) {
                counter+=1;
                System.out.println("------------Domicilio "+counter+" ------------");
                domicilio.mostrarDomicilio();
            }
        }
    //------------RELACION CON PEDIDOS------------
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "cliente-id")
    private List<Pedido> pedidos = new ArrayList<>();
        //------------AGREGAR PEDIDO------------
        public void agregarPedidos (Pedido ped){pedidos.add(ped);}
        //------------MOSTRAR PEDIDOS------------
        public void mostrarPedidos(){
            System.out.println("------------Pedidos de: "+nombre+" "+apellido+" ------------");
            int counter=0;
            for(Pedido ped:pedidos){
                counter+=1;
                System.out.println("---Pedido numero: "+counter+" ---");
                ped.mostrarPedido();
            }
        }
}
