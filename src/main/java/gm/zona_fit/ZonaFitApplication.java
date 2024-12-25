package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;
	private	static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion.");// Levantar la fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion finalizada.");
	}

	@Override
	public void run(String... args) throws Exception {
		boolean salir = false;
		Scanner consola = new Scanner(System.in);

		while(!salir){
			logger.info("*** Aplicacion Zona Fit (GYM) ***");

			logger.info("""
				1. Listar Clientes
				2. Buscar Cliente
				3. Agregar Cliente
				4. Modificar Cliente
				5. Eliminar Cliente
				6. Salir
				Elige una de las anteriores opciones:\s""");

			var opcion = Integer.parseInt(consola.nextLine());

			switch (opcion){
				case 1 -> listarClientes();
				case 2 -> buscarCliente(consola);
				case 3 -> agregarCliente(consola);
				case 6 -> {
						salir=true;
				}
				default -> logger.info("Opcion Invalida.");
			}
		}
	}

	private void listarClientes(){
		logger.info("--- Listado de Clientes ---");
		List<Cliente> clientes = clienteServicio.listarClientes();
		clientes.forEach(cliente -> logger.info(cliente.toString()));
	}

	private void buscarCliente(Scanner consola){
		logger.info("--- Buscar Cliente por Id ---");
		logger.info("¿Cual es el id del cliente a buscar?: ");
		var idCliente = Integer.parseInt(consola.nextLine());

		var cliente = clienteServicio.buscarClientePorId(idCliente);

		logger.info(cliente.toString());
	}

	private void guardarCliente(Cliente cliente){
		clienteServicio.guardarCliente(cliente);
		logger.info("¡Cliente agregado con exito!");
		listarClientes();
	}

	private void agregarCliente(Scanner consola){
		logger.info("--- Agregar un nuevo cliente ---");
		logger.info("Nombre del cliente: ");
		var nombreCliente = consola.nextLine();

		logger.info("Apellido del cliente: ");
		var apellidoCliente = consola.nextLine();

		logger.info("Membresia del cliente: ");
		var membresiaCliente = Integer.parseInt(consola.nextLine());

		var cliente = new Cliente();
		cliente.setNombre(nombreCliente);
		cliente.setApellido(apellidoCliente);
		cliente.setMembresia(membresiaCliente);

		guardarCliente(cliente);
		logger.info("¡Cliente guardado con exito!");
		listarClientes();
	}
}
