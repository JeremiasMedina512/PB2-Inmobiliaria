package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Ph> phs;
	private ArrayList<Campo> campos;
	private ArrayList<Terreno> terrenos;
	private HashSet<Cliente> clientes;
//	private Casa casas[];
//	private Departamento departamentos[];
//	private Ph phs[];
//	private Terreno terrenos[];
//	private Campo campos[];
//	private Cliente clientes[];
	private Venta ventas[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES = 100;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 3;
	private final Integer CANTIDAD_MAXIMA_DE_VENTAS = 100;

	public Inmobiliaria(String nombre, String direccion, String email, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
//		this.propiedades = new Propiedad[CANTIDAD_MAXIMA_DE_PROPIEDADES];
//		this.casas = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES];
//		this.departamentos = new Departamento[CANTIDAD_MAXIMA_DE_PROPIEDADES];
//		this.clientes = new ArrayList[CANTIDAD_MAXIMA_DE_CLIENTES];
//		this.ventas = new Venta[this.CANTIDAD_MAXIMA_DE_VENTAS];
		this.clientes = new HashSet<>();
		this.casas = new ArrayList<>();
		this.departamentos = new ArrayList<>();
		this.phs = new ArrayList<>();
		this.campos = new ArrayList<>();
		this.terrenos = new ArrayList<>();
	}

	public Boolean addCasa(Casa casaNueva) {
		if (!existeCasa(casaNueva)) {
			for (int i = 0; i < casas.size(); i++) {
				if (this.casas.get(i) == null) {
					return this.casas.add(casaNueva);
				}
			}
		}
		return false;
	}

	public Boolean existeCasa(Casa casaABuscar) {
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).equals(casaABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addDepartamento(Departamento nuevoDepartamento) {
		if (!existeDepartamento(nuevoDepartamento)) {
			for (int i = 0; i < this.departamentos.size(); i++) {
				if (this.departamentos.get(i) == null) {
					return this.departamentos.add(nuevoDepartamento);
				}
			}
		}
		return false;
	}

	public Boolean existeDepartamento(Departamento departamentoABuscar) {
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				if (this.departamentos.get(i).equals(departamentoABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addPh(Ph nuevoPh) {
		if (existePh(nuevoPh)) {
			for (int i = 0; i < this.phs.size(); i++) {
				if (this.phs.get(i) == null) {
					return this.phs.add(nuevoPh);
				}
			}
		}

		return false;
	}

	public Boolean existePh(Ph phABuscar) {
		for (int i = 0; i < this.phs.size(); i++) {
			if (this.phs.get(i) != null) {
				if (this.phs.get(i).equals(phABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addCampo(Campo nuevoCampo) {
		for (int i = 0; i < this.campos.size(); i++) {
			if (this.campos.get(i) == null) {
				this.campos.add(nuevoCampo);
				return true;
			}
		}
		return null;
	}

	public Boolean existeCampo(Campo campoABuscar) {
		for (int i = 0; i < this.phs.size(); i++) {
			if (this.campos.get(i) != null) {
				if (this.campos.get(i).equals(campoABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean addTerreno(Terreno nuevoTerreno) {
		for (int i = 0; i < this.terrenos.size(); i++) {
			if (this.terrenos.get(i) == null) {
				this.terrenos.add(nuevoTerreno);
				return true;
			}
		}
		return null;
	}

	public Boolean existeTerreno(Terreno terrenoABuscar) {
		for (int i = 0; i < this.terrenos.size(); i++) {
			if (this.terrenos.get(i) != null) {
				if (this.terrenos.get(i).equals(terrenoABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean venderCasa(Casa casaAVender, Cliente clienteAlQueVender) {
		if (buscarCasa(casaAVender.getCodigo()) && buscarClientePorDni(clienteAlQueVender.getDni())) {
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
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getCodigo().equals(codigoDeCasa)) {
					return true;
				}
			}
		}
		return false;
	}

//	Cambiar a arrayList

	public Boolean buscarClientePorDni(Long clienteDni) {
		for (int i = 0; i < this.clientes.size(); i++) {
			if (this.clientes != null) {
				if (this.clientesgetDni().equals(clienteDni)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean modificarPropiedadExistente(Integer codigo, Double nuevoPrecio) {
		Boolean valorRetorno = false;
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getCodigo().equals(codigo)) {
					this.casas.get(i).setPrecio(nuevoPrecio);
					valorRetorno = true;
					i = this.casas.size();
				}
			}
		}
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				if (this.departamentos.get(i).getCodigo().equals(codigo)) {
					this.departamentos.get(i).setPrecio(nuevoPrecio);
					valorRetorno = true;
					i = this.departamentos.size();
				}
			}
		}
		return valorRetorno;
	}

	public Boolean addCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}
	

	public void obtenerListadoDePropiedadesPorPrecio() {
		Double[] preciosDeCasasYDepartamentos = new Double[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorPrecios = 0;
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				preciosDeCasasYDepartamentos[contadorPrecios] = this.departamentos.get(i).getPrecio();
				contadorPrecios++;
			}
		}
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				preciosDeCasasYDepartamentos[contadorPrecios] = this.casas.get(i).getPrecio();
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
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				acumuladorDePrecioDeCasas += this.casas.get(i).getPrecio();
				contador++;
			}
		}
		return acumuladorDePrecioDeCasas / contador;
	}

	public Double calcularElPromedioDeLosDepartamentos() {
		Double acumuladorDePrecioDeDepartamentos = 0.0;
		Double contador = 0.0;
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				acumuladorDePrecioDeDepartamentos += this.departamentos.get(i).getPrecio();
				contador++;
			}
		}
		return acumuladorDePrecioDeDepartamentos / contador;

	}

	public String[] buscarPropiedadesPorRangoDePrecios(Double precioMinimo, Double precioMaximo) {
		String[] propiedadesPorRangoDePrecios = new String[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorIndependiente = 0;
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (precioMinimo <= this.casas.get(i).getPrecio() && this.casas.get(i).getPrecio() <= precioMaximo) {
					propiedadesPorRangoDePrecios[contadorIndependiente] = this.casas.get(i).toString();
					contadorIndependiente++;
				}

			}
		}
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				if (precioMinimo <= this.departamentos.get(i).getPrecio()
						&& this.departamentos.get(i).getPrecio() <= precioMaximo) {
					propiedadesPorRangoDePrecios[contadorIndependiente] = this.departamentos.get(i).toString();
					contadorIndependiente++;
				}
			}
		}

		return propiedadesPorRangoDePrecios;
	}

	public String[] buscarPropiedadesPorUbicacion(String localidad) {
		String[] propiedadesPorUbicacion = new String[this.CANTIDAD_MAXIMA_DE_PROPIEDADES * 2];
		Integer contadorIndependiente = 0;
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getCiudad().equals(localidad)) {
					propiedadesPorUbicacion[contadorIndependiente] = "Codigo: " + this.casas.get(i).getCodigo()
							+ ", ciudad: " + this.casas.get(i).getCiudad();
					contadorIndependiente++;
				}

			}
		}
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				if (this.departamentos.get(i).getCiudad().equals(localidad)) {
					propiedadesPorUbicacion[contadorIndependiente] = "Codigo: " + this.departamentos.get(i).getCodigo()
							+ ", ciudad: " + this.departamentos.get(i).getCiudad();
					contadorIndependiente++;
				}
			}
		}
		return propiedadesPorUbicacion;
	}

//	VER	
	public void ordenarDepartamentosPorUbicacion() {
		for (int i = 0; i < this.departamentos.size(); i++) {
			for (int j = 0; j < this.departamentos.size(); j++) {
				if (this.departamentos.get(j).getCiudad().compareTo(this.departamentos.get(i).getCiudad()) > 0) {
					Departamento temp = this.departamentos[j];
					this.departamentos[j] = this.departamentos[j + 1];
					this.departamentos[j + 1] = temp;
				}

			}
		}
		for (Departamento i : this.departamentos) {
			System.out.println(i);
		}
	}



	public Integer getCANTIDAD_MAXIMA_DE_PROPIEDADES() {
		return CANTIDAD_MAXIMA_DE_PROPIEDADES;
	}

	public Casa[] rangoDePreciosDeCasas(Double minimo, Double maximo) {
		Casa[] casasDentroDelRango = new Casa[this.CANTIDAD_MAXIMA_DE_PROPIEDADES];

		Integer contador = 0;
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getPrecio() <= minimo && maximo <= this.casas.get(i).getPrecio()) {
					casasDentroDelRango[contador] = this.casas.get(i);
					contador++;
				}
			}
		}
		return casasDentroDelRango;
	}
	
	public Boolean permutarCasaEntreClientes(Cliente clienteA, Cliente clienteB, Casa casaDelClienteA, Casa casaDelClienteB) {
		if(clienteA.getPoseePropiedadParaPermutar() && clienteB.getPoseePropiedadParaPermutar()) {
			clienteA.getCasasCompradas().remove(casaDelClienteA);
			clienteB.getCasasCompradas().remove(casaDelClienteB);
			clienteA.comprarCasa(casaDelClienteB);
			clienteB.comprarCasa(casaDelClienteA);
			return true;
		}
		return false;
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

	public Integer getCANTIDAD_MAXIMA_DE_CLIENTES() {
		return CANTIDAD_MAXIMA_DE_CLIENTES;
	}

	public Integer getCANTIDAD_MAXIMA_DE_VENTAS() {
		return CANTIDAD_MAXIMA_DE_VENTAS;
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

	public void setCasas(ArrayList<Casa> casas) {
		this.casas = casas;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public ArrayList<Ph> getPhs() {
		return phs;
	}

	public void setPhs(ArrayList<Ph> phs) {
		this.phs = phs;
	}

	public ArrayList<Campo> getCampos() {
		return campos;
	}

	public void setCampos(ArrayList<Campo> campos) {
		this.campos = campos;
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	public void setTerrenos(ArrayList<Terreno> terrenos) {
		this.terrenos = terrenos;
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Venta[] getVentas() {
		return ventas;
	}

	public void setVentas(Venta[] ventas) {
		this.ventas = ventas;
	}
	
	

	
	
	

}
