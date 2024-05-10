package ar.edu.unlam.pb1;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class InterfazInmobiliaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Integer opcionSeleccionada = 0;
		Inmobiliaria inmobiliaria = new Inmobiliaria("Inmobiliaria", "Calle 123", "emailArrobaGmail.com", "12345678");

		do {

			System.out.println("Menu de opciones");
			System.out.println("1. Agregar nueva propiedad");
			System.out.println("2. Modificar propiedad existente");
			System.out.println("3. Agregar clientes");
			System.out.println("4. Obtener listado de propiedades ordenado por precio");
			System.out.println("5. Obtener listado de propiedades ordenado por ubicacion");
			System.out.println("6.a Buscar propiedades ordenados por rango de precio");
			System.out.println("6.b Buscar propiedades ordenados por ubicacion");
			System.out.println("7. Realizar la venta de una propiedad");
			System.out.println("8. Realizar la venta de una propiedad");
			System.out.println("9. Salir");

			opcionSeleccionada = teclado.nextInt();

			switch (OpcionDeMenu.values()[opcionSeleccionada - 1]) {

			case AGREGAR_PROPIEDAD: // AGREGAR PROPIEDAD
//				agregarPropiedad(teclado, inmobiliaria);
				System.out.println(agregarPropiedad(teclado, inmobiliaria));
				break;
			case MODIFICAR_PROPIEDAD:
//				modificarPropiedad(teclado, inmobiliaria);
				System.out.println(modificarPropiedad(teclado, inmobiliaria));
				break;
			case AGREGAR_CLIENTE:
//				agregarCliente(teclado, inmobiliaria);
				System.out.println(agregarCliente(teclado, inmobiliaria));
				break;
			case OBTENER_LISTADO_POR_PRECIO:
				obtenerListadoDePropiedadesPorPrecio(inmobiliaria);
				break;
			case OBTENER_LISTADO_POR_UBICACION:
				break;
			case REALIZAR_VENTA:
//				System.out.println(realizarVenta(teclado, inmobiliaria));
				realizarVenta(teclado, inmobiliaria);
				break;
			case REALIZAR_ALQUILER:
//				System.out.println(realizarAlquiler(teclado, inmobiliaria));
				break;
			case SALIR:
				break;
			}

		} while (opcionSeleccionada != 9);

	}

	private static Boolean realizarVenta(Scanner teclado, Inmobiliaria inmobiliaria) {
		separador();
		System.out.println("Ingrese el codigo de la casa que desea vender");
		
		return true;
	}

	public static void buscarPropiedadesPorPrecioOUbicacion(Scanner teclado, Inmobiliaria inmobiliaria) {
		separador();
		Integer opcionDeBusqueda = 0;
		System.out.println("Ingrese alguna de las siguientes opciones:");
		System.out.println("1 - Buscar por precio ");
		System.out.println("2 - BUscar por ubicacion");
		opcionDeBusqueda = teclado.nextInt();
		switch (BusquedaDePropiedades.values()[opcionDeBusqueda - 1]) {
		case BUSCAR_POR_PRECIO:
			String[] propiedadesPorPrecio;
			Double precioMinimo;
			Double precioMaximo;
			System.out.println("Ingrese precio minimo:");
			precioMinimo = teclado.nextDouble();
			System.out.println("Ingrese precio maximo:");
			precioMaximo = teclado.nextDouble();
			propiedadesPorPrecio = inmobiliaria.buscarPropiedadesPorRangoDePrecios(precioMinimo, precioMaximo);
			for (String i : propiedadesPorPrecio) {
				System.out.println(i);
			}
			break;
		case BUSCAR_POR_UBICACION:
			String[] propiedadesPorLocalidad;
			String localidad;
			System.out.println("Ingrese localiad");
			localidad = teclado.next();
			propiedadesPorLocalidad = inmobiliaria.buscarPropiedadesPorUbicacion(localidad);
			for (int i = 0; i < propiedadesPorLocalidad.length; i++) {
				if (propiedadesPorLocalidad[i] != null) {
					System.out.println(i);
				}
			}
			break;

		}
	}

	public static Boolean agregarPropiedad(Scanner teclado, Inmobiliaria inmobiliaria) { //
		separador();
		Boolean resultadoOperacion = false;
		Casa nuevaCasa = null;
		Departamento nuevoDepartamento = null;
		Ph nuevoPh;
		Campo nuevoCampo;
		Terreno nuevoTerreno;
		Integer codigo;
		String calle;
		Integer numero;
		String ciudad;
		Double precio;
		TipoDeOperacion tipoDeOperacion = null;
		System.out.println("Agregar nueva propiedad");
		System.out.println("Ingrese codigo:");
		codigo = teclado.nextInt();
		System.out.println("Ingrese calle:");
		calle = teclado.next();
		System.out.println("Ingrese numero");
		numero = teclado.nextInt();
		System.out.println("Ingrese ciudad");
		ciudad = teclado.next();
		System.out.println("Ingrese precio");
		precio = teclado.nextDouble();
		System.out.println("Ingrese tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		switch (teclado.nextInt()) {
		case 1:
			tipoDeOperacion = TipoDeOperacion.VENTA;
			break;
		case 2:
			tipoDeOperacion = TipoDeOperacion.ALQUILER;
			break;
		}
		System.out.println("¿Desea agregar una casa o un departamento?");
		System.out.println("1: Casa");
		System.out.println("2: Departamento");
		System.out.println("3: PH");
		System.out.println("4: Campo");
		System.out.println("5: Terreno");

		switch (teclado.nextInt()) {
		case 1:
			nuevaCasa = new Casa(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
			resultadoOperacion = inmobiliaria.agregarPropiedad(nuevaCasa);
			break;
		case 2:
			Integer piso, departamento;
			System.out.println("Ingrese numero de piso");
			piso = teclado.nextInt();
			System.out.println("Ingrese departamento");
			departamento = teclado.nextInt();
			nuevoDepartamento = new Departamento(codigo, calle, numero, ciudad, piso, departamento, precio, tipoDeOperacion);
			resultadoOperacion = inmobiliaria.addDepartamento(nuevoDepartamento);
			break;
		case 3:
			nuevoPh = new Ph(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
			resultadoOperacion = inmobiliaria.addPh(nuevoPh);
			break;
		case 4:
			nuevoCampo = new Campo(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
			resultadoOperacion = inmobiliaria.addCampo(nuevoCampo);
			break;
		case 5:
			nuevoTerreno = new Terreno(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
			resultadoOperacion = inmobiliaria.addTerreno(nuevoTerreno);
			break;
		}
		return resultadoOperacion;

	}

	public static Boolean modificarPropiedad(Scanner teclado, Inmobiliaria inmobiliaria) { //
		separador();
		Integer codigoABuscar = null;
		Double nuevoPrecio = null;
		System.out.println("Ingrese codigo de propiedad a buscar para modificar su precio:");
		codigoABuscar = teclado.nextInt();
		System.out.println("Ingrese nuevo precio");
		nuevoPrecio = teclado.nextDouble();
		return inmobiliaria.modificarPropiedadExistente(codigoABuscar, nuevoPrecio);
	}

	public static Boolean agregarCliente(Scanner teclado, Inmobiliaria inmobiliaria) { //
		separador();
		Cliente cliente = null;
		Long dni;
		String nombre;
		System.out.println("Agregar cliente");
		System.out.println("Ingrese dni:");
		dni = teclado.nextLong();
		System.out.println("Ingrese nombre");
		nombre = teclado.next();
		cliente = new Cliente(dni, nombre, nombre);
		return inmobiliaria.addCliente(cliente);
	}

	public static void obtenerListadoDePropiedadesPorPrecio(Inmobiliaria inmobiliaria) {
		separador();
		inmobiliaria.obtenerListadoDePropiedadesPorPrecio();
	}


	public static void separador() {
		System.out.println("---------------------------");
	}

}
