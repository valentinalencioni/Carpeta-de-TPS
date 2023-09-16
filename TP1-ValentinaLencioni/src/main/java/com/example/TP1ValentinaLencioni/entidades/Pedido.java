package com.example.TP1ValentinaLencioni.entidades;

import com.example.TP1ValentinaLencioni.enums.EstadosPedido;
import com.example.TP1ValentinaLencioni.enums.TiposEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{
    //-------------ATRIBUTOS-------------
    private EstadosPedido estadosPedido;
    private TiposEnvio tipoEnvio;
    private double total;
    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    //-------------RELACION CON DETALLE PEDIDO-------------
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "pedido-id")
    private List<DetallePedido> detallesPedido = new ArrayList<>();
        //------------AGREGAR PEDIDO------------
        public void agregarDetallesPedido (DetallePedido detPedido){detallesPedido.add(detPedido);}
        //------------MOSTRAR PEDIDO------------
        public void mostrarPedido(){
            System.out.println("-------------PEDIDO-------------");
            System.out.println("Pedido numero:"+this.getId());
            System.out.println("Fecha: "+fecha);
            System.out.println("Estado: "+estadosPedido);
            System.out.println("Tipo de entrega: "+tipoEnvio);
            System.out.println("Total: ");
            int counter=0;
            for (DetallePedido detallesPedido:this.getDetallesPedido()){
                counter+=1;
                System.out.println("Linea de detalle de pedido numero: "+counter);
                detallesPedido.mostrarDetallePedido();
            }
            System.out.println("El pedido fue ejecutado con la factura numero: "+factura.getNumero());
        }
    //-------------RELACION CON FACTURA-------------

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

}
