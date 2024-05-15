package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;


public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private ArrayList<Casa> casas;
	private HashSet<Casa> casasUnicas;
	private ArrayList<Departamento> departamentos;
	private TreeSet<Departamento> departamentosOrdenadosPorUbicacion;
	private HashSet<Departamento> departamentosOrdenadosPorPrecio;
	private ArrayList<Ph> phs;
	private ArrayList<Campo> campos;
	private ArrayList<Terreno> terrenos;
	private HashSet<Cliente> clientes;
	private Venta ventas[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES = 100;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 3;
	private final Integer CANTIDAD_MAXIMA_DE_VENTAS = 100;

	public Inmobiliaria(String nombre, String direccion, String email, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.clientes = new HashSet<>();
		this.casas = new ArrayList<>();
		this.departamentos = new ArrayList<>();
		this.phs = new ArrayList<>();
		this.campos = new ArrayList<>();
		this.terrenos = new ArrayList<>();
		this.departamentosOrdenadosPorUbicacion = new TreeSet<>();
		this.departamentosOrdenadosPorPrecio = new HashSet<>();
		this.casasUnicas = new HashSet<>();
	}
	

	public Boolean agregarPropiedad(Casa casaNueva) {
		Boolean resultadoAgregacion = false;
		if (this.casas.size() == 0) {
			return this.casas.add(casaNueva);
		} else if (!existePropiedad(casaNueva)) {
			resultadoAgregacion = this.casas.add(casaNueva);
		}
		return resultadoAgregacion;
	}

	public Boolean existePropiedad(Casa casaABuscar) {
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).equals(casaABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean agregarPropiedad(Departamento nuevoDepartamento) {
		Boolean resultadoAgregacion = false;
		if (this.departamentos.size() == 0) {
			return this.departamentos.add(nuevoDepartamento);
		} else if (!existePropiedad(nuevoDepartamento)) {
			resultadoAgregacion = this.departamentos.add(nuevoDepartamento);

		}
		return resultadoAgregacion;
	}

	public Boolean existePropiedad(Departamento departamentoABuscar) {
		for (int i = 0; i < this.departamentos.size(); i++) {
			if (this.departamentos.get(i) != null) {
				if (this.departamentos.get(i).equals(departamentoABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean agregarPropiedad(Ph nuevoPh) {
		if (this.phs.size() == 0) {
			this.phs.add(nuevoPh);
			return true;
		} else if (!existePropiedad(nuevoPh)) {
			for (int i = 0; i < phs.size(); i++) {
				if (this.phs.get(i) == null) {
					return this.phs.add(nuevoPh);
				}
			}
		}
		return false;
	}

	public Boolean existePropiedad(Ph phABuscar) {
		for (int i = 0; i < this.phs.size(); i++) {
			if (this.phs.get(i) != null) {
				if (this.phs.get(i).equals(phABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean agregarPropiedad(Campo nuevoCampo) {
		if (this.campos.size() == 0) {
			return this.campos.add(nuevoCampo);
		} else if (!existePropiedad(nuevoCampo)) {
			for (int i = 0; i < campos.size(); i++) {
				if (this.campos.get(i) == null) {
					return this.campos.add(nuevoCampo);
				}
			}
		}
		return false;
	}

	public Boolean existePropiedad(Campo campoABuscar) {
		for (int i = 0; i < this.phs.size(); i++) {
			if (this.campos.get(i) != null) {
				if (this.campos.get(i).equals(campoABuscar)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean agregarPropiedad(Terreno nuevoTerreno) {
		if (this.terrenos.size() == 0) {
			return this.terrenos.add(nuevoTerreno);
		} else if (!existePropiedad(nuevoTerreno)) {
			for (int i = 0; i < terrenos.size(); i++) {
				if (this.terrenos.get(i) == null) {
					return this.terrenos.add(nuevoTerreno);
				}
			}
		}
		return false;
	}

	public Boolean existePropiedad(Terreno terrenoABuscar) {
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

	public Boolean buscarClientePorDni(Long clienteDni) {
		Cliente clienteABuscar = new Cliente(clienteDni);
		for (int i = 0; i < this.clientes.size(); i++) {
			if (this.clientes != null) {
				if (this.clientes.contains(clienteABuscar)) {
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

	public TreeSet<Departamento> ordenarDepartamentosPorUbicacion() {
		this.departamentosOrdenadosPorUbicacion.addAll(this.departamentos);
		for (Departamento i : departamentosOrdenadosPorUbicacion) {
			System.out.println(i.getCodigo() + ", " + i.getCiudad() + ", " + i.getCalle() + " " + i.getNumero());
		}
		return this.departamentosOrdenadosPorUbicacion;
	}

	public ArrayList<Casa> buscarPorRangoDePreciosDeCasas(Double minimo, Double maximo) {
		ArrayList<Casa> casasEnElRango = new ArrayList<>();
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getPrecio() <= minimo && maximo <= this.casas.get(i).getPrecio()) {
					casasEnElRango.add(this.casas.get(i));
				}
			}

		}
		for (Casa i : casasEnElRango) {
			if (i != null) {
				System.out.println(i.getCodigo() + ", " + i.getCiudad() + ", " + i.getCalle() + ", " + i.getNumero());
			}
		}
		return casasEnElRango;

	}

	public Boolean permutarCasaEntreClientes(Cliente clienteA, Cliente clienteB, Casa casaDelClienteA,
			Casa casaDelClienteB) {
		if (clienteA.getPoseePropiedadParaPermutar() && clienteB.getPoseePropiedadParaPermutar()) {
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

	public Integer getCANTIDAD_MAXIMA_DE_PROPIEDADES() {
		return CANTIDAD_MAXIMA_DE_PROPIEDADES;
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
		return this.departamentos;
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

	public ArrayList<Casa> buscarPorUbicacionDeCasas(String ubicacionABuscar) {
		ArrayList<Casa> casasEnUbicacion = new ArrayList<>();
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.casas.get(i) != null) {
				if (this.casas.get(i).getCiudad().equals(ubicacionABuscar)) {
					casasEnUbicacion.add(this.casas.get(i));
				}
			}

		}
		for (Casa i : casasEnUbicacion) {
			if (i != null) {
				System.out.println(i.getCodigo() + ", " + i.getCiudad() + ", " + i.getCalle() + ", " + i.getNumero());
			}
		}
		return casasEnUbicacion;

	}

	public ArrayList<Departamento> ordenarDepartamentosPorPrecio() {
		ArrayList<Departamento> departamentosOrdenadosPorPrecio = new ArrayList<>();
		departamentosOrdenadosPorPrecio.addAll(this.departamentos);
		for (int i = 0; i < departamentosOrdenadosPorPrecio.size(); i++) {
			for (int j = 0; j < departamentosOrdenadosPorPrecio.size() - 1; j++) {
				if (departamentosOrdenadosPorPrecio.get(j).getPrecio() > departamentosOrdenadosPorPrecio.get(j + 1)
						.getPrecio()) {
					Departamento temporalMayor = departamentosOrdenadosPorPrecio.get(j);
					departamentosOrdenadosPorPrecio.set(j, departamentosOrdenadosPorPrecio.get(j + 1));
					departamentosOrdenadosPorPrecio.set(j + 1, temporalMayor);
				}
			}
		}
		for(Departamento i: departamentosOrdenadosPorPrecio) {
			System.out.println(i.getCodigo() + ", " + i.getPrecio());
		}
		return departamentosOrdenadosPorPrecio;

	}

}
