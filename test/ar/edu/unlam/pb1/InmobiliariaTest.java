package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;

public class InmobiliariaTest {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Casa casa = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casa = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);

		resultadoEsperado = inmobiliaria.agregarPropiedad(casa);

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaDosCasasEnLaInmobiliaria() {
		Casa casaA = null;
		Casa casaB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.VENTA);

		inmobiliaria.agregarPropiedad(casaA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(casaB);

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queNoSePuedaDarDeAltaDosCasasConUnaMismaDireccion() {
		Casa casaA = null;
		Casa casaB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);

		inmobiliaria.agregarPropiedad(casaA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(casaB);

		assertFalse(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamenntoEnLaInmobiliaria() {
		Departamento departamento = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamento = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 1);

		resultadoEsperado = inmobiliaria.agregarPropiedad(departamento);

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentosEnLaInmobiliaria() {
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		departamentoB = new Departamento(2, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 3);

		inmobiliaria.agregarPropiedad(departamentoA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(departamentoB);

		assertTrue(resultadoEsperado);
	}

	@Test
	public void queNoSePuedaDarDeAltaDosDepartamentosConUnaMismaDireccion() {
		// calle, numero, piso, departamento y localidad.
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		departamentoB = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		inmobiliaria.agregarPropiedad(departamentoA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(departamentoB);

		assertFalse(resultadoEsperado);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Casa casaA = null;
		Casa casaB = null;
		Casa casaC = null;
		Double resultadoEsperado = 0.0;
		Double resultadoReal = 0.0;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.VENTA);
		casaC = new Casa(3, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.VENTA);
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.agregarPropiedad(casaC);
		resultadoEsperado = 500.0;
		resultadoReal = inmobiliaria.calcularElPromedioDeLasCasas();

		assertEquals(resultadoEsperado, resultadoReal, 0.01);

	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Departamento departamentoC = null;
		Double resultadoEsperado = 0.0;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.ALQUILER, 1, 1);
		inmobiliaria.agregarPropiedad(departamentoA);
		inmobiliaria.agregarPropiedad(departamentoB);
		inmobiliaria.agregarPropiedad(departamentoC);
		resultadoEsperado = 500.0;

		assertEquals(resultadoEsperado, inmobiliaria.calcularElPromedioDeLosDepartamentos(), 0.01);

	}

	@Test
	public void queLaBusquedaPorRangoDePreciosMeArrojeUnArrayNoNuloSiAplicanResultados() {
		Casa casaA = null;
		Casa casaB = null;
		Casa casaC = null;
		Double minimo = 500.0, maximo = 3000.0;
		ArrayList<Propiedad> propiedadesEnElRango = new ArrayList<>();
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 5000.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Suarez", 123, "Ciudadela", 1000.0, TipoDeOperacion.VENTA);
		casaC = new Casa(3, "Polledo", 123, "San Justo", 2000.0, TipoDeOperacion.VENTA);
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.agregarPropiedad(casaC);
		propiedadesEnElRango = inmobiliaria.buscarPorRangoDePreciosDePropiedades(minimo, maximo);
		assertNotNull(propiedadesEnElRango);

	}

	@Test
	public void queLaBusquedaPorUbicacionMeArrojeUnArrayNoNuloSiAplicanResultados() {
		String ubicacionABuscar = "Moron";
		ArrayList<Propiedad> propiedadesEnUbcacion = null;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa= new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		Departamento departamento = new Departamento(2, "Cordero", 123, "Ciudadela", 1000.0, TipoDeOperacion.VENTA,1,1);
		Ph ph = new Ph(3, "Venezuela", 123, "Moron", 2000.0, TipoDeOperacion.VENTA);
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(departamento);
		inmobiliaria.agregarPropiedad(ph);
//		inmobiliaria.agregarPropiedad(casaC);
		propiedadesEnUbcacion = inmobiliaria.buscarPorUbicacionDePropiedades(ubicacionABuscar);
		assertNotNull(propiedadesEnUbcacion);

	}

	@Test
	public void queUnaPersonaPuedaComprarUnaCasa() {
		Casa casa = null;
		Cliente cliente = null;
		Long dni = (long) 19189;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casa = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		cliente = new Cliente(dni, "Jeremias", "Medina");
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.addCliente(cliente);
		assertTrue(inmobiliaria.hacerVentaDePropiedad(cliente, casa));

	}

	@Test
	public void queAlAgregarDosClienteYUnoRepetidoElTamañoDelArraySeaDeDos() {
		Cliente clienteA = null, clienteB = null;
		Long dniA = (long) 1;
		Long dniB = (long) 2;
		Integer tamañoEsperado = 2;
		Integer tamañoDelArrayReal = null;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		clienteA = new Cliente(dniA, "Jeremias", "Medina");
		clienteB = new Cliente(dniB, "Alex", "Gutierrez");
		inmobiliaria.addCliente(clienteA);
		inmobiliaria.addCliente(clienteB);
		inmobiliaria.addCliente(clienteB);

		tamañoDelArrayReal = inmobiliaria.getClientes().size();
		assertEquals(tamañoEsperado, tamañoDelArrayReal);
	}

	@Test
	public void queSePuedanMostrarLosDepartamentosOrdenadosPorUbicacion() {
		Departamento departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1,
				1);
		Departamento departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.ALQUILER,
				1, 2);
		Departamento departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.ALQUILER,
				1, 3);
		Departamento departamentoD = new Departamento(4, "Cordero", 123, "Liniers", 500.0, TipoDeOperacion.ALQUILER, 1,
				4);
		Departamento departamentoE = new Departamento(4, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.ALQUILER,
				1, 4);
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		inmobiliaria.agregarPropiedad(departamentoA);
		inmobiliaria.agregarPropiedad(departamentoB);
		inmobiliaria.agregarPropiedad(departamentoC);
		inmobiliaria.agregarPropiedad(departamentoD);
		inmobiliaria.agregarPropiedad(departamentoE);
		assertNotNull(inmobiliaria.ordenarDepartamentosPorUbicacion());
	}

	@Test
	public void queSePuedanMostrarLasPropiedadesOrdenadosPorPrecio() {
		Departamento departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER, 1,
				1);
		Departamento departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela", 10.0, TipoDeOperacion.ALQUILER, 1,
				2);
		Departamento departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia", 5000.0,
				TipoDeOperacion.ALQUILER, 1, 3);
		Departamento departamentoD = new Departamento(4, "Cordero", 123, "Liniers", 70.0, TipoDeOperacion.ALQUILER, 1,
				4);
		Departamento departamentoE = new Departamento(5, "Cordero", 123, "Ramos Mejia", 1.0, TipoDeOperacion.ALQUILER,
				1, 4);
		Ph ph = new Ph(4, "Japon", 15, "San Martin",3500.0, TipoDeOperacion.VENTA);
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		inmobiliaria.agregarPropiedad(departamentoA);
		inmobiliaria.agregarPropiedad(departamentoB);
		inmobiliaria.agregarPropiedad(departamentoC);
		inmobiliaria.agregarPropiedad(departamentoD);
		inmobiliaria.agregarPropiedad(departamentoE);
		inmobiliaria.agregarPropiedad(ph);
		assertNotNull(inmobiliaria.ordenarDepartamentosPorPrecio());
	}
	
	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		Departamento departamento = new Departamento(2, "Cordero", 123, "Ciudadela", 300.0, TipoDeOperacion.VENTA, 1,
				1);
		Ph ph = new Ph(3, "Varela" , 156, "San Justo",200.0, TipoDeOperacion.ALQUILER);
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(departamento);
		inmobiliaria.agregarPropiedad(ph);	
		assertNotNull(inmobiliaria.buscarPropiedadesEnVenta());		
	}

	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER);
		Departamento departamento = new Departamento(2, "Cordero", 123, "Ciudadela", 300.0, TipoDeOperacion.ALQUILER, 1,
				1);
		Ph ph = new Ph(3, "Varela" , 156, "San Justo",200.0, TipoDeOperacion.ALQUILER);
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(departamento);
		inmobiliaria.agregarPropiedad(ph);	
		assertNull(inmobiliaria.buscarPropiedadesEnVenta());		
	}
	
	@Test
	public void queSePuedaConcretarVentaDeUnaPropiedad() {
		long dni = (long)15165;
		Boolean resultadoEsperado = false;
		Cliente cliente= new Cliente(dni, "Jeremias", "Medina");
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 0.0, TipoDeOperacion.VENTA);
		inmobiliaria.addCliente(cliente);
		inmobiliaria.agregarPropiedad(casa);
		resultadoEsperado =inmobiliaria.hacerVentaDePropiedad(cliente, casa);
		assertTrue(resultadoEsperado);
		
	}
	
	@Test
	public void queNoSePuedaConcretarVentaDeUnaPropiedadSiElTipoDeOperacionNoEsElCorrecto() {
		long dni = (long)15165;
		Boolean resultadoEsperado = false;
		Cliente cliente= new Cliente(dni, "Jeremias", "Medina");
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 0.0, TipoDeOperacion.ALQUILER);
		inmobiliaria.addCliente(cliente);
		inmobiliaria.agregarPropiedad(casa);
		resultadoEsperado =inmobiliaria.hacerVentaDePropiedad(cliente, casa);
		assertFalse(resultadoEsperado);
		
	}
	

	@Test
	public void queSePuedaConcretarUnAlquilerDeUnaPropiedad() {
		long dni = (long)15165;
		Boolean resultadoEsperado = false;
		Cliente cliente= new Cliente(dni, "Jeremias", "Medina");
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 0.0, TipoDeOperacion.ALQUILER);
		Date fechaLimite = new Date(2000,01,12);
		inmobiliaria.addCliente(cliente);
		inmobiliaria.agregarPropiedad(casa);
		resultadoEsperado =inmobiliaria.hacerAlquilerDePropiedad(cliente, casa, fechaLimite);
		assertTrue(resultadoEsperado);
		
	}
	
	@Test
	public void queSePuedaConcretarUnAlquilerDeUnaPropiedadSiElTipoDeOperacionNoEsElCorrecto() {
		long dni = (long)15165;
		Boolean resultadoEsperado = false;
		Cliente cliente= new Cliente(dni, "Jeremias", "Medina");
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casa = new Casa(1, "Cordero", 123, "Moron", 0.0, TipoDeOperacion.VENTA);
		Date fechaLimite = new Date(2000,01,12);
		inmobiliaria.addCliente(cliente);
		inmobiliaria.agregarPropiedad(casa);
		resultadoEsperado =inmobiliaria.hacerAlquilerDePropiedad(cliente, casa, fechaLimite);
		assertFalse(resultadoEsperado);
		
	}
	
	@Test
	public void queSePuedaPermutarDosPropiedadesEnVentaEntreDosClientes() {
		long dni = (long)15165;
		Boolean resultadoEsperado = false;
		Cliente clienteA= new Cliente(dni, "Jeremias", "Medina");
		dni = (long) 165156;
		Cliente clienteB= new Cliente(dni, "Matias", "Giron");
	
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		Casa casaA = new Casa(1, "Cordero", 123, "Moron", 0.0, TipoDeOperacion.VENTA);
		Casa casaB = new Casa(1, "Belgrano", 123, "San Justo", 0.0, TipoDeOperacion.VENTA);
		inmobiliaria.addCliente(clienteA);
		inmobiliaria.addCliente(clienteB);
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.hacerVentaDePropiedad(clienteA, casaA);
		inmobiliaria.hacerVentaDePropiedad(clienteB, casaB);
		resultadoEsperado = inmobiliaria.permutarCasaEntreClientes(clienteA, clienteB, casaA, casaB);
		assertTrue(resultadoEsperado);
		
	}
	
	

}
