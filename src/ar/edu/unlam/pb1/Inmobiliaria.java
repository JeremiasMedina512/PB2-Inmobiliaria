package ar.edu.unlam.pb1;

import java.sql.Date;
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
	private ArrayList<Departamento> departamentos;
	private ArrayList<Ph> phs;
	private ArrayList<Campo> campos;
	private ArrayList<Terreno> terrenos;
	private HashSet<Cliente> clientes;
	private ArrayList<Propiedad> propiedades;
//	Crear una array de ventas, alquileres y permutas.
	private ArrayList<Venta> ventas;
	private ArrayList<Alquiler> alquileres;


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
		this.propiedades = new ArrayList<>();
		this.ventas = new ArrayList<>();
		this.alquileres = new ArrayList<>();
	}
	
	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(ArrayList<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
	public Boolean agregarPropiedad(Casa casaNueva) {
		Boolean resultadoAgregacion = false;
		if (this.casas.size() == 0) {
			this.propiedades.add(casaNueva);
			return this.casas.add(casaNueva);
		} else if (!existePropiedad(casaNueva)) {
			resultadoAgregacion = this.casas.add(casaNueva);
			this.propiedades.add(casaNueva);
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
			this.propiedades.add(nuevoDepartamento);
			return this.departamentos.add(nuevoDepartamento);
		} else if (!existePropiedad(nuevoDepartamento)) {
			this.propiedades.add(nuevoDepartamento);
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
			this.propiedades.add(nuevoPh);
			this.phs.add(nuevoPh);
			return true;
		} else if (!existePropiedad(nuevoPh)) {
			for (int i = 0; i < phs.size(); i++) {
				if (this.phs.get(i) == null) {
					this.propiedades.add(nuevoPh);
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
			this.propiedades.add(nuevoCampo);
			return this.campos.add(nuevoCampo);
		} else if (!existePropiedad(nuevoCampo)) {
			for (int i = 0; i < campos.size(); i++) {
				if (this.campos.get(i) == null) {
					this.propiedades.add(nuevoCampo);
					return this.campos.add(nuevoCampo);
				}
			}
		}
		return false;
	}

	public Boolean existePropiedad(Campo campoABuscar) {
		for (int i = 0; i < this.campos.size(); i++) {
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
			this.propiedades.add(nuevoTerreno);
			return this.terrenos.add(nuevoTerreno);
		} else if (!existePropiedad(nuevoTerreno)) {
			for (int i = 0; i < terrenos.size(); i++) {
				if (this.terrenos.get(i) == null) {
					this.propiedades.add(nuevoTerreno);
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
		for(int i = 0; i < this.propiedades.size(); i++) {
			if (this.propiedades.get(i).getCodigo().equals(codigo)) {
				this.propiedades.get(i).setPrecio(nuevoPrecio);
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
		TreeSet<Departamento> departamentosOrdenadosPorUbicacion = new TreeSet<>();
		departamentosOrdenadosPorUbicacion.addAll(this.departamentos);
		for (Departamento i : departamentosOrdenadosPorUbicacion) {
			System.out.println(i.getCodigo() + ", " + i.getCiudad() + ", " + i.getCalle() + " " + i.getNumero());
		}
		return departamentosOrdenadosPorUbicacion;
	}

	public ArrayList<Propiedad> buscarPorRangoDePreciosDePropiedades(Double minimo, Double maximo) {
		ArrayList<Propiedad> propiedadesEnElRango = new ArrayList<>();
		for (int i = 0; i < this.casas.size(); i++) {
			if (this.propiedades.get(i) != null) {
				if (this.propiedades.get(i).getPrecio() <= maximo &&
						this.propiedades.get(i).getPrecio() >= minimo) {
					propiedadesEnElRango.add(this.propiedades.get(i));
				}
			}

		}
		for (Propiedad i : propiedadesEnElRango) {
				System.out.println(i);
			
		}
		return propiedadesEnElRango;

	}

	public Boolean permutarCasaEntreClientes(Cliente clienteA, Cliente clienteB, Propiedad casaDelClienteA,
			Propiedad casaDelClienteB){
		Integer ubicacionClienteA = 0;
		Integer ubicacionClienteB =0;
		Propiedad propiedadClienteA = null;
		Propiedad propiedadClienteB =null;
		ubicacionClienteA = buscarClienteEnVentas(clienteA);
		ubicacionClienteB= buscarClienteEnVentas(clienteB);
		if(ubicacionClienteA != -1 && ubicacionClienteB!= -1) {
			propiedadClienteA = this.ventas.get(ubicacionClienteA).getPropiedad();
			propiedadClienteB = this.ventas.get(ubicacionClienteB).getPropiedad();
			this.ventas.get(ubicacionClienteA).setPropiedad(propiedadClienteB);
			this.ventas.get(ubicacionClienteB).setPropiedad(propiedadClienteA);
			return true;
		}

		return false;
	
	}
	
	private Integer buscarClienteEnVentas(Cliente cliente) {
		for(int i = 0; i< this.ventas.size();i++) {
			if(this.ventas.get(i).getCliente().equals(cliente)) {
				return i;
			}
		}
		return -1;
	}
	
	private Integer buscarPropiedadEnVentas(Propiedad propiedad) {
		for(int i = 0; i< this.ventas.size();i++) {
			if(this.ventas.get(i).getPropiedad().equals(propiedad)) {
				return i;
			}
		}
		return -1;
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

	public ArrayList<Propiedad> buscarPorUbicacionDePropiedades(String ubicacionABuscar) {
		ArrayList<Propiedad> propiedadesEnUbcacion = new ArrayList<>();
		for (int i = 0; i < this.propiedades.size(); i++) {
			if (this.propiedades.get(i) != null) {
				if (this.propiedades.get(i).getCiudad().equals(ubicacionABuscar)) {
					propiedadesEnUbcacion.add(this.propiedades.get(i));
				}
			}

		}
		for (Propiedad i : propiedadesEnUbcacion) {
			if (i != null) {
				System.out.println(i.getCodigo() + ", " + i.getCiudad() + ", " + i.getCalle() + ", " + i.getNumero());
			}
		}
		return propiedadesEnUbcacion;

	}

	public ArrayList<Propiedad> ordenarDepartamentosPorPrecio() {
		ArrayList<Propiedad> propiedadesOrdenadosPorPrecio = new ArrayList<>();
		propiedadesOrdenadosPorPrecio.addAll(this.propiedades);
		for (int i = 0; i < propiedadesOrdenadosPorPrecio.size(); i++) {
			for (int j = 0; j < propiedadesOrdenadosPorPrecio.size() - 1; j++) {
				if (propiedadesOrdenadosPorPrecio.get(j).getPrecio() > propiedadesOrdenadosPorPrecio.get(j + 1)
						.getPrecio()) {
					Propiedad temporalMayor = propiedadesOrdenadosPorPrecio.get(j);
					propiedadesOrdenadosPorPrecio.set(j, propiedadesOrdenadosPorPrecio.get(j + 1));
					propiedadesOrdenadosPorPrecio.set(j + 1, temporalMayor);
				}
			}
		}
		for(Propiedad i: propiedadesOrdenadosPorPrecio) {
			System.out.println(i.getCodigo() + ", " + i.getPrecio());
		}
		return propiedadesOrdenadosPorPrecio;

	}

	public ArrayList<Propiedad> buscarPropiedadesEnVenta() {
		ArrayList<Propiedad> propiedadesEnVenta = new ArrayList<>();
		
		if(this.propiedades.size() != 0) {
			for(int i =0; i < this.propiedades.size()-1;i++) {
				if(this.propiedades.get(i).getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
					propiedadesEnVenta.add(this.propiedades.get(i));
				}
			}
		}
		if(propiedadesEnVenta.size() == 0) {
			return null;
		}
		
		for(Propiedad i: propiedadesEnVenta) {
			System.out.println(i);
		}
		
		return propiedadesEnVenta;
	}
	
	public Boolean hacerVentaDePropiedad(Cliente cliente, Propiedad propiedad) {
		Boolean resultado = false;
		if(buscarClientePorDni(cliente.getDni())) {
			for(int i = 0; i < this.propiedades.size(); i++) {
				if(this.propiedades.get(i).equals(propiedad)) {
					if (this.propiedades.get(i).getTipoDeOperacion().equals(TipoDeOperacion.VENTA) && this.propiedades.get(i).getEstaDisponible().equals(true)) {
						Venta venta = new Venta(cliente, propiedad);
						this.propiedades.get(i).setEstaDisponible(false);
						this.ventas.add(venta);
						resultado = true;
						i = this.propiedades.size();
					}
				}
			}
		}else {
			resultado = false;
		}
		return resultado;
	}
	
	public Boolean hacerAlquilerDePropiedad(Cliente cliente, Propiedad propiedad, Date fechaLimite) {
		Boolean resultado = false;
		if(buscarClientePorDni(cliente.getDni())) {
			for(int i = 0; i < this.propiedades.size(); i++) {
				if(this.propiedades.get(i).equals(propiedad)) {
					if (this.propiedades.get(i).getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER) && this.propiedades.get(i).getEstaDisponible().equals(true)) {
						Alquiler alquiler = new Alquiler(cliente, propiedad, fechaLimite);			
						this.propiedades.get(i).setEstaDisponible(false);
						this.alquileres.add(alquiler);
						resultado = true;
						i = this.propiedades.size();
					}
				}
			}
		}else {
			resultado = false;
		}
		return resultado;
	}


}
