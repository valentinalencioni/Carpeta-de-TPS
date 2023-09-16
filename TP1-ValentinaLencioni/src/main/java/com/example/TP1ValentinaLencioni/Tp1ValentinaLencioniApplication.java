package com.example.TP1ValentinaLencioni;

import com.example.TP1ValentinaLencioni.entidades.*;
import com.example.TP1ValentinaLencioni.enums.EstadosPedido;
import com.example.TP1ValentinaLencioni.enums.FormasPago;
import com.example.TP1ValentinaLencioni.enums.TiposEnvio;
import com.example.TP1ValentinaLencioni.enums.TiposProducto;
import com.example.TP1ValentinaLencioni.repositorios.ClienteRepository;
import com.example.TP1ValentinaLencioni.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp1ValentinaLencioniApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;
	public static void main(String[] args) {

		SpringApplication.run(Tp1ValentinaLencioniApplication.class, args);
		System.out.println("-----------FIN-----------");
	}


	@Bean
		CommandLineRunner init(ClienteRepository clienteRepo,RubroRepository rubroRepo) {
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			//-----------1-CREAR RUBRO-----------
			Rubro rubro1= Rubro.builder()
					.denominacion("hamburguesas")
					.build();

			//-----------2-CREAR PRODUCTO-----------
			Producto producto1= Producto.builder()
					.precioCompra(4000)
					.denominacion("hamburguesa americana")
					.tipo(TiposProducto.Manufacturado)
					.receta("")
					.stockActual(200)
					.stockMinimo(20)
					.precioVenta(8000)
					.unidadMedida("kg")
					.tiempoEstimadoCocina(60)
					.build();

			//-----------2-CREAR PRODUCTO-----------
			Producto producto2= Producto.builder()
					.precioCompra(2000)
					.denominacion("cheese burguer simple")
					.tipo(TiposProducto.Manufacturado)
					.receta("Smashear hamburguesa, tostar panes, agregar cheddar y ketchup")
					.stockActual(500)
					.stockMinimo(100)
					.precioVenta(2500)
					.unidadMedida("kg")
					.tiempoEstimadoCocina(15)
					.build();

			//-----------3-AGREGAR PRODUCTOS AL RUBRO-----------
			rubro1.agregarProductos(producto1);
			rubro1.agregarProductos(producto2);

			//-----------4-GUARDAR RUBRO-----------
			rubroRepository.save(rubro1);

			//-----------5-CREAR CLIENTE-----------
			Cliente cliente1= Cliente.builder()
					.nombre("Valentina")
					.apellido("Lencioni")
					.email("hola@ejemplo.com")
					.telefono("4856")
					.build();

			//-----------6-CREAR DOMICILIO-----------
			Domicilio domicilio1= Domicilio.builder()
					.numero("833")
					.calle("Malar")
					.localidad("Hola")
					.build();

			//-----------7-CREAR DOMICILIO-----------
			Domicilio domicilio2=Domicilio.builder()
					.calle("Donde topa")
					.numero("123")
					.localidad("Las Heras")
					.build();

			//-----------8-ASOCIAR DOMICILIO A CLIENTE-----------
				//-----------DOMICILIO 1-----------
				cliente1.agregarDomicilio(domicilio1);
				//-----------DOMICILIO 2-----------
				cliente1.agregarDomicilio(domicilio2);

			//-----------9-CREAR DETALLE DE PEDIDO-----------
			DetallePedido detallePedido1=DetallePedido.builder()
					.cantidad(2)
					.subtotal(16000)
					.build();

			//-----------9-CREAR DETALLE DE PEDIDO-----------
			DetallePedido detallePedido2=DetallePedido.builder()
					.cantidad(1)
					.subtotal(5000)
					.build();

			//-----------10-CREAR PEDIDO-----------
			Pedido pedido1= Pedido.builder()
					.fecha(new java.sql.Date(2022,10,14))
					.tipoEnvio(TiposEnvio.retira)
					.estadosPedido(EstadosPedido.iniciado)
					.total(21000)
					.build();

			//-----------11-CREAR FACTURA-----------
			Factura factura1= Factura.builder()
					.numero(485)
					.fecha(new java.sql.Date(2022,10,14))
					.descuento(0)
					.formaPago(FormasPago.efectivo)
					.total(21000)
					.build();

			//-----------------10-Agregar detalles al pedido-----------------
			pedido1.agregarDetallesPedido(detallePedido1);
			pedido1.agregarDetallesPedido(detallePedido2);
			//-----------------11-agregar pedidos al cliente-----------------
			cliente1.agregarPedidos(pedido1);
			//-----------------12-vincular el detalle pedido con el producto-----------------
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			//-----------------10-Asociar PEDIDO-FACTURA-----------------
			pedido1.setFactura(factura1);

			//-----------GUARDAR CLIENTE-----------
			clienteRepository.save(cliente1);
			//recuperar Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}



			//-----------------1-MOSTRAR RUBRO-----------------

			System.out.println("Se creo un nuevo rubro con los siguientes datos: ");
			System.out.printf( "Denominacion: "+ rubro1.getDenominacion());
			System.out.println("---------------------------------------------------");

			//-----------------2-MOSTRAR PRODUCTOS-----------------

			//-----------MOSTRAR DATOS DEL PRODUCTO-----------
			System.out.println("Se creo un producto con los siguientes datos:");
			producto1.mostrarProducto();
			System.out.println("---------------------------------------------------");

			//-----------MOSTRAR DATOS DEL PRODUCTO-----------
			System.out.println("Se creo un producto con los siguientes datos:");
			producto2.mostrarProducto();
			System.out.println("---------------------------------------------------");

			//-----------------3-MOSTRAR PRODUCTOS DEL RUBRO-----------------

			System.out.println("Se agrego el producto "+producto1.getDenominacion()+" al rubro "
					+rubro1.getDenominacion());

			System.out.println("Se agrego el producto "+producto2.getDenominacion()+" al rubro "
					+rubro1.getDenominacion());

			//-----------------5-MOSTRAR CLIENTE-----------------

			//-----------MOSTRAR DATOS DEL CLIENTE-----------
			System.out.println("Se creo un nuveo cliente con los siguientes datos: ");
			cliente1.mostrarCliente();
			System.out.println("---------------------------------------------------");

			//-----------------6-MOSTRAR DOMICILIOS-----------------

			//-----------MOSTRAR DATOS DEL DOMICILIO-----------
			System.out.println("Se creo un nuevo domicilio con los siguientes datos:");
			domicilio1.mostrarDomicilio();
			System.out.println("---------------------------------------------------");

			//-----------MOSTRAR DATOS DEL DOMICILIO-----------
			System.out.println("Se creo un nuevo domicilio con los siguientes datos:");
			domicilio2.mostrarDomicilio();
			System.out.println("---------------------------------------------------");

			//-----------------7-MOSTRAR DOMICILIOS DEL CLIENTE-----------------

			//-----------MOSTRAR DATOS DE LA RELACION-----------
			cliente1.mostrarDomicilios();


			//-----------------11-MOSTRAR DETALLE DE PEDIDO-----------------
			System.out.println("Se creo un nuevo detalle de pedido con exito");
			detallePedido1.mostrarDetallePedido();

			System.out.println("---------------------------------------------------");

			System.out.println("Se creo un nuevo detalle de pedido con exito");
			System.out.println("---------------------------------------------------");
			detallePedido2.mostrarDetallePedido();


			//-----------------12-MOSTRAR PEDIDO-----------------
			System.out.println("Se creo un nuevo pedido exitosamente");
			pedido1.mostrarPedido();

			System.out.println("---------------------------------------------------");
			//-----------MOSTRAR DATOS DE FACTURA-----------
			System.out.println("Se creo una nueva factura exitosamente");
			factura1.mostrarFactura();



			//-----------------MOSTRAR PEDIDOS DEL CLIENTE-----------------
			cliente1.mostrarPedidos();

			};

	}

}
