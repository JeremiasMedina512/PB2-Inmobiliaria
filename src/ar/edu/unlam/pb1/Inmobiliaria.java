package ar.edu.unlam.pb1;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private Propiedad propiedades[];
	private Casa casas[];
	private Departamento departamentos[];
	private Ph phs[];
	private Terreno terrenos[];
	private Campo campos[];
	private Cliente clientes[];
	private Venta ventas[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES = 100;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 3;
	private final Integer CANTIDAD_MAXIMA_DE_VENTAS = 100;

	public Inmobiliaria(String nombre, String direccion, String email, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.propiedades = new Propiedad[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.casas = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.departamentos = new Departamento[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.clientes = new Cliente[CANTIDAD_MAXIMA_DE_CLIENTES];
		this.ventas = new Venta[this.CANTIDAD_MAXIMA_DE_VENTAS];
	}

	public Boolean addCasa(Casa casa) {
		if (!existeCasa(casa)) {
			for (int i = 0; i < casas.length; i++) {
				if (this.casas[i] == null) {
					this.casas[i] = casa;
					return true;
				}
			}
			return false;
		}
		return false;
	}

	private Boolean existeCasa(Casa casa) {
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				if (this.casas[i].equals(casa)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addDepartamento(Departamento departamento) {
		if (!existeDepartamento(departamento)) {
			for (int i = 0; i < this.departamentos.length; i++) {
				if (this.departamentos[i] == null) {
					this.departamentos[i] = departamento;
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	private Boolean existeDepartamento(Departamento departamento) {
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				if (this.departamentos[i].equals(departamento)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addPh(Ph nuevoPh) {
		for (int i = 0; i < this.phs.length; i++) {
			if (this.phs[i] == null) {
				this.phs[i] = nuevoPh;
				return true;
			}
		}
		return null;
	}

	public Boolean addCampo(Campo nuevoCampo) {
		for (int i = 0; i < this.campos.length; i++) {
			if (this.campos[i] == null) {
				this.campos[i] = nuevoCampo;
				return true;
			}
		}
		return null;
	}

	public Boolean addTerreno(Terreno nuevoTerreno) {
		for (int i = 0; i < this.terrenos.length; i++) {
			if (this.terrenos[i] == null) {
				this.terrenos[i] = nuevoTerreno;
				return true;
			}
		}
		return null;
	}

	public Boolean venderCasa(Casa casaAVender, Cliente clienteAlQueVender) {
		if (buscarCasa(casaAVender.getCodigo()) && buscarCliente(clienteAlQueVender.getDni())) {
			for (int i = 0; i < this.ventas.length; i++) {
				if (this.ventas[i] == null) {
					this.ventas[i] = new Venta(clienteAlQueVender, casaAVender);
					this.ventas[i].getCasa().setEstaDisponible(false);
					return true;
				}
			}
		}
		return false;
	}

	public Boolean buscarCasa(Integer codigoDeCasa) {
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				if (this.casas[i].getCodigo().equals(codigoDeCasa)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean buscarCliente(Long clienteDni) {
		for (int i = 0; i < this.clientes.length; i++) {
			if (this.clientes[i] != null) {
				if (this.clientes[i].getDni().equals(clienteDni)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean modificarPropiedadExistente(Integer codigo, Double nuevoPrecio) {
		Boolean valorRetorno = false;
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				if (this.casas[i].getCodigo().equals(codigo)) {
					this.casas[i].setPrecio(nuevoPrecio);
					valorRetorno = true;
					i = this.casas.length;
				}
			}
		}
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				if (this.departamentos[i].getCodigo().equals(codigo)) {
					this.departamentos[i].setPrecio(nuevoPrecio);
					valorRetorno = true;
					i = this.departamentos.length;
				}
			}
		}
		return valorRetorno;
	}

	public Boolean addCliente(Cliente cliente) {
		Boolean retorno = false;
		for (int i = 0; i < this.clientes.length; i++) {
			if (this.clientes[i] != null) {
				if (this.clientes[i].getDni().equals(cliente.getDni())) {
					return retorno;
				}
			}
		}
		for (int i = 0; i < this.clientes.length; i++) {
			if (this.clientes[i] == null) {
				this.clientes[i] = cliente;
				retorno = true;
				i = clientes.length;
			}
		}
		return retorno;
	}

	public void obtenerListadoDePropiedadesPorPrecio() {
		Double[] preciosDeCasasYDepartamentos = new Double[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorPrecios = 0;
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				preciosDeCasasYDepartamentos[contadorPrecios] = this.departamentos[i].getPrecio();
				contadorPrecios++;
			}
		}
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				preciosDeCasasYDepartamentos[contadorPrecios] = this.casas[i].getPrecio();
				contadorPrecios++;
			}
		}

		for (int i = 0; i < preciosDeCasasYDepartamentos.length; i++) {
			for (int j = 0; j < contadorPrecios - 1; j++) {
				Double temporalMayor = null;
				if (preciosDeCasasYDepartamentos[j] > preciosDeCasasYDepartamentos[j + 1]) {
					temporalMayor = preciosDeCasasYDepartamentos[j];
					preciosDeCasasYDepartamentos[j] = preciosDeCasasYDepartamentos[j + 1];
					preciosDeCasasYDepartamentos[j + 1] = temporalMayor;
				}
			}
		}

		for (int i = 0; i < preciosDeCasasYDepartamentos.length; i++) {
			if (preciosDeCasasYDepartamentos[i] != null) {
				System.out.println(preciosDeCasasYDepartamentos[i]);

			}
		}

	}

	public Double calcularElPromedioDeLasCasas() {
		Double acumuladorDePrecioDeCasas = 0.0;
		Double contador = 0.0;
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				acumuladorDePrecioDeCasas += this.casas[i].getPrecio();
				contador++;
			}
		}
		return acumuladorDePrecioDeCasas / contador;
	}

	public Double calcularElPromedioDeLosDepartamentos() {
		Double acumuladorDePrecioDeDepartamentos = 0.0;
		Double contador = 0.0;
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				acumuladorDePrecioDeDepartamentos += this.departamentos[i].getPrecio();
				contador++;
			}
		}
		return acumuladorDePrecioDeDepartamentos / contador;

	}

	public String[] buscarPropiedadesPorRangoDePrecios(Double precioMinimo, Double precioMaximo) {
		String[] propiedadesPorRangoDePrecios = new String[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorIndependiente = 0;
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				if (precioMinimo <= this.casas[i].getPrecio() && this.casas[i].getPrecio() <= precioMaximo) {
					propiedadesPorRangoDePrecios[contadorIndependiente] = this.casas[i].toString();
					contadorIndependiente++;
				}

			}
		}
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				if (precioMinimo <= this.departamentos[i].getPrecio()
						&& this.departamentos[i].getPrecio() <= precioMaximo) {
					propiedadesPorRangoDePrecios[contadorIndependiente] = this.departamentos[i].toString();
					contadorIndependiente++;
				}
			}
		}

		return propiedadesPorRangoDePrecios;
	}

	public String[] buscarPropiedadesPorUbicacion(String localidad) {
		String[] propiedadesPorUbicacion = new String[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorIndependiente = 0;
		for (int i = 0; i < this.casas.length; i++) {
			if (this.casas[i] != null) {
				if (this.casas[i].getCiudad().equals(localidad)) {
					propiedadesPorUbicacion[contadorIndependiente] = "Codigo: " + this.casas[i].getCodigo()
							+ ", ciudad: " + this.casas[i].getCiudad();
					contadorIndependiente++;
				}

			}
		}
		for (int i = 0; i < this.departamentos.length; i++) {
			if (this.departamentos[i] != null) {
				if (this.departamentos[i].getCiudad().equals(localidad)) {
					propiedadesPorUbicacion[contadorIndependiente] = "Codigo: " + this.departamentos[i].getCodigo()
							+ ", ciudad: " + this.departamentos[i].getCiudad();
					contadorIndependiente++;
				}
			}
		}
		return propiedadesPorUbicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Propiedad[] getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Propiedad[] propiedades) {
		this.propiedades = propiedades;
	}

	public Casa[] getCasas() {
		return casas;
	}

	public void setCasas(Casa[] casas) {
		this.casas = casas;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}

	public Integer getCANTIDAD_MAXIMA_DE_PROPIEDADES() {
		return CANTIDAD_MAXIMA_DE_PROPIEDADES;
	}

	public Casa[] rangoDePreciosDeCasas(Double minimo, Double maximo) {
		Casa[] casasDentroDelRango = new Casa[this.CANTIDAD_MAXIMA_DE_PROPIEDADES];

		Integer contador = 0;
		for(int i = 0; i < this.casas.length;i++) {
			if (this.casas[i] != null) {
				if (this.casas[i].getPrecio()<= minimo && maximo<= this.casas[i].getPrecio()) {
					casasDentroDelRango[contador] = this.casas[i];
					contador++;
				}
			}
		}
		return casasDentroDelRango;
	}

}
