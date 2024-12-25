package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZonaFitApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		// Crear un cliente de prueba
		Cliente cliente = new Cliente();
		cliente.setNombre("Juan");
		cliente.setApellido("Perez");
		cliente.setMembresia(1);

		System.out.println(cliente);
	}
}
