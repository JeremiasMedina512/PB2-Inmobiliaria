package ar.edu.unlam.pb1;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Test;

public class InmobiliariaTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

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
		casaB = new Casa(2, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);

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
		casaB = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);

		inmobiliaria.agregarPropiedad(casaA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(casaB);

		assertFalse(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamenntoEnLaInmobiliaria() {
		Departamento departamento = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamento = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER,1,1);

		resultadoEsperado = inmobiliaria.agregarPropiedad(departamento);

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentosEnLaInmobiliaria() {
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron",500.0, TipoDeOperacion.ALQUILER,1,1);
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER,1,2);
		
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
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER,1,1);
		departamentoB = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER,1,1);

		inmobiliaria.agregarPropiedad(departamentoA);
		resultadoEsperado = inmobiliaria.agregarPropiedad(departamentoB);

		assertFalse(resultadoEsperado);
	}

	@Test
	public void queElPromedioDeLasCasasSeaQuinientos() {
		Casa casaA = null;
		Casa casaB = null;
		Casa casaC = null;
		Double resultadoEsperado = 0.0;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.VENTA);
		casaC = new Casa(3, "Cordero", 123, "Ramos Mejia", 500.0, TipoDeOperacion.VENTA);
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.agregarPropiedad(casaC);
		resultadoEsperado = 500.0;

		assertEquals(resultadoEsperado, inmobiliaria.calcularElPromedioDeLasCasas(), 0.01);

	}

	@Test
	public void queElPromedioDeLosDepartamentosSeaQuinientos() {
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Departamento departamentoC = null;
		Double resultadoEsperado = 0.0;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron",500.0, TipoDeOperacion.ALQUILER,1,1);
		departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela",500.0, TipoDeOperacion.ALQUILER,1,1);
		departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia",500.0, TipoDeOperacion.ALQUILER,1,1);
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
		Double minimo = 700.0, maximo = 3000.0;
		Casa[] casasEnElRango = null;
		System.out.println(casasEnElRango);
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Cordero", 123, "Ciudadela", 1000.0, TipoDeOperacion.VENTA);
		casaC = new Casa(3, "Cordero", 123, "San Justo", 2000.0, TipoDeOperacion.VENTA);
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.agregarPropiedad(casaC);
		casasEnElRango = inmobiliaria.rangoDePreciosDeCasas(minimo, maximo);
		System.out.println(casasEnElRango);
		for (Casa i : casasEnElRango) {
			System.out.println(i);
		}
		assertNotNull(null);

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
		assertTrue(cliente.comprarCasa(casa));

	}

	@Test
	public void queAparezcanLasCasasDeUnaPersonaQueComproUnaCasa() {
		Casa casaA = null;
		Casa casaB = null;
		Cliente cliente = null;
		Long dni = (long) 19189;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Rosas", 123, "Ciudadela", 511.0, TipoDeOperacion.VENTA);
		cliente = new Cliente(dni, "Jeremias", "Medina");
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.addCliente(cliente);
		cliente.comprarCasa(casaA);
		cliente.comprarCasa(casaB);
//		REVISAR
//		for(int i =0 ;i< cliente.getCasasCompradas().size();i++) {
//			System.out.println(cliente.getCasasCompradas());
//			System.out.println("toString "  + cliente.getCasasCompradas().toString());
//
//		}
		assertNotNull(cliente.getCasasCompradas());

	}

	@Test
	public void queUnaPersonaNoPuedaComprarUnaCasaConElTipoDeOperacionIncorrecto() {
		Casa casaA = null;
		Cliente cliente = null;
		Long dni = (long) 19189;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER);
//		casaB = new Casa(2,"Rosas", 123,"Ciudadela",511.0, TipoDeOperacion.VENTA);
		cliente = new Cliente(dni, "Jeremias", "Medina");
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.addCliente(cliente);
		cliente.comprarCasa(casaA);
		assertFalse(cliente.comprarCasa(casaA));
		;

	}

	@Test
	public void queDosPersonasPermutenSusCasasEntreEllos() {
		Casa casaA = null, casaB = null;
		Cliente clienteA = null, clienteB = null;
		Long dniA = (long) 19189;
		Long dniB = (long) 89181;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		casaA = new Casa(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.VENTA);
		casaB = new Casa(2, "Rosas", 123, "Ciudadela", 511.0, TipoDeOperacion.VENTA);
		clienteA = new Cliente(dniA, "Jeremias", "Medina");
		clienteB = new Cliente(dniB, "Alex", "Gutierrez");
		inmobiliaria.agregarPropiedad(casaA);
		inmobiliaria.agregarPropiedad(casaB);
		inmobiliaria.addCliente(clienteA);
		inmobiliaria.addCliente(clienteB);
		clienteA.comprarCasa(casaA);
		clienteB.comprarCasa(casaB);
		resultadoEsperado = inmobiliaria.permutarCasaEntreClientes(clienteA, clienteB, casaA, casaB);
		assertTrue(resultadoEsperado);

	}

	@Test // Hacer
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNoNuloSiAplicanResultados() {
		Casa casa = null;
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados(){
		Casa casa = null;
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
	public void queSePuedanMostrarLosDepartamentosOrdenadosPorUbicacion(){
		LinkedList<Departamento> departamentos = new LinkedList<Departamento>();
		Departamento departamentoA = new Departamento(1, "Cordero", 123, "Moron", 500.0, TipoDeOperacion.ALQUILER,1,1);
		Departamento departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela", 500.0, TipoDeOperacion.ALQUILER,1,2);
		Departamento departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia",500.0, TipoDeOperacion.ALQUILER,1,3);
		Departamento departamentoD = new Departamento(4, "Cordero", 123, "Liniers",500.0, TipoDeOperacion.ALQUILER,1,4);
		Departamento departamentoE = new Departamento(4, "Cordero", 123, "Ramos Mejia",500.0, TipoDeOperacion.ALQUILER,1,4);
		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		inmobiliaria.agregarPropiedad(departamentoA);
		inmobiliaria.agregarPropiedad(departamentoB);
		inmobiliaria.agregarPropiedad(departamentoC);
		inmobiliaria.agregarPropiedad(departamentoD);	
		inmobiliaria.agregarPropiedad(departamentoE);


		
		inmobiliaria.ordenarDepartamentosPorUbicacion();
		
		
		
		
		
		assertFalse(true);
		

	}


}


