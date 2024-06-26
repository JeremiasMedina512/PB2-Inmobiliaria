package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.Scanner;

import ar.edu.unlam.pb1.*;

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

		resultadoEsperado = inmobiliaria.addCasa(casa);

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

		inmobiliaria.addCasa(casaA);
		resultadoEsperado = inmobiliaria.addCasa(casaB);

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

		inmobiliaria.addCasa(casaA);
		resultadoEsperado = inmobiliaria.addCasa(casaB);

		assertFalse(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamenntoEnLaInmobiliaria() {
		Departamento departamento = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamento = new Departamento(1, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);

		resultadoEsperado = inmobiliaria.addDepartamento(departamento);

		assertTrue(resultadoEsperado);

	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentosEnLaInmobiliaria() {
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);
		departamentoB = new Departamento(1, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);

		inmobiliaria.addDepartamento(departamentoA);
		resultadoEsperado = inmobiliaria.addDepartamento(departamentoB);

		assertTrue(resultadoEsperado);
	}

	@Test
	public void queNoSePuedaDarDeAltaDosDepartamentosConUnaMismaDireccion() {
		// calle, numero, piso, departamento y localidad.
		Departamento departamentoA = null;
		Departamento departamentoB = null;
		Boolean resultadoEsperado = false;

		Inmobiliaria inmobiliaria = new Inmobiliaria("Remax", "Varela 123", "example@gmail.com", "123456789");
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);
		departamentoB = new Departamento(2, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);

		inmobiliaria.addDepartamento(departamentoA);
		resultadoEsperado = inmobiliaria.addDepartamento(departamentoB);

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
		inmobiliaria.addCasa(casaA);
		inmobiliaria.addCasa(casaB);
		inmobiliaria.addCasa(casaC);
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
		departamentoA = new Departamento(1, "Cordero", 123, "Moron", 1, 1, 500.0, TipoDeOperacion.ALQUILER);
		departamentoB = new Departamento(2, "Cordero", 123, "Ciudadela",1,1, 500.0, TipoDeOperacion.ALQUILER);
		departamentoC = new Departamento(3, "Cordero", 123, "Ramos Mejia",1,1,500.0, TipoDeOperacion.ALQUILER);
		inmobiliaria.addDepartamento(departamentoA);
		inmobiliaria.addDepartamento(departamentoB);
		inmobiliaria.addDepartamento(departamentoC);
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
		inmobiliaria.addCasa(casaA);
		inmobiliaria.addCasa(casaB);
		inmobiliaria.addCasa(casaC);
		casasEnElRango= inmobiliaria.rangoDePreciosDeCasas(minimo,maximo);
		System.out.println(casasEnElRango);
		for(Casa i: casasEnElRango) {
			System.out.println(i);
		}
		assertNotNull(casasEnElRango);

	}



	

}
