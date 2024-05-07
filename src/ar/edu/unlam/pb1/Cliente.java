package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	private Long dni;
	private String nombre;
	private String apellido;
	private Boolean poseePropiedadParaPermutar;
	private ArrayList<Casa> casasCompradas;
	private ArrayList<Casa> casasAlquiladas;
	private ArrayList<Departamento> departamentosComprados;
	private ArrayList<Departamento> departamentosAlquilados;
	private ArrayList<Ph> phsComprados;
	private ArrayList<Ph> phsAlquilados;
	private ArrayList<Campo> camposComprados;
	private ArrayList<Campo> camposAlquilados;
	private ArrayList<Terreno> terrenosComprados;
	private ArrayList<Terreno> terrenosAlquilados;

	public Cliente(Long dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.poseePropiedadParaPermutar = false;
		this.casasAlquiladas = new ArrayList<>();
		this.casasCompradas = new ArrayList<>();
		this.departamentosAlquilados = new ArrayList<>();
		this.departamentosComprados = new ArrayList<>();
		this.phsAlquilados = new ArrayList<>();
		this.phsComprados = new ArrayList<>();
		this.camposAlquilados = new ArrayList<>();
		this.camposComprados = new ArrayList<>();
		this.terrenosAlquilados = new ArrayList<>();
		this.terrenosComprados = new ArrayList<>();
	}
	
	public Cliente(Long dni) {
		this.dni = dni;
	}

	public Boolean comprarCasa(Casa casaAComprar) {
		if (casaAComprar.getEstaDisponible().equals(true)
				&& casaAComprar.getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
			casaAComprar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			return this.casasCompradas.add(casaAComprar);
		}
		return false;
	}

	public Boolean alquilarCasa(Casa casaAAlquilar) {
		if (casaAAlquilar.getEstaDisponible().equals(true)
				&& casaAAlquilar.getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER)) {
			casaAAlquilar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.casasAlquiladas.add(casaAAlquilar);
		}
		return false;
	}

	public Boolean comprarDepartamento(Departamento departamentoAComprar) {
		if (departamentoAComprar.getEstaDisponible().equals(true)
				&& departamentoAComprar.getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
			departamentoAComprar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.departamentosComprados.add(departamentoAComprar);
		}
		return false;
	}

	public Boolean alquilerDepartamento(Departamento departamentoAAlquilar) {
		if (departamentoAAlquilar.getEstaDisponible().equals(true)
				&& departamentoAAlquilar.getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER)) {
			departamentoAAlquilar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.departamentosComprados.add(departamentoAAlquilar);
		}
		return false;
	}

	public Boolean comprarPh(Ph phAComprar) {
		if (phAComprar.getEstaDisponible().equals(true)
				&& phAComprar.getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
			phAComprar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.phsComprados.add(phAComprar);
		}
		return false;
	}

	public Boolean alquilarPh(Ph phAAlquilar) {
		if (phAAlquilar.getEstaDisponible().equals(true)
				&& phAAlquilar.getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER)) {
			phAAlquilar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.phsComprados.add(phAAlquilar);
		}
		return false;
	}

	public Boolean comprarCampo(Campo campoAComprar) {
		if (campoAComprar.getEstaDisponible().equals(true)
				&& campoAComprar.getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
			campoAComprar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.camposComprados.add(campoAComprar);
		}
		return false;
	}

	public Boolean alquilarCampo(Campo campoAAlquilar) {
		if (campoAAlquilar.getEstaDisponible().equals(true)
				&& campoAAlquilar.getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER)) {
			campoAAlquilar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			return this.camposAlquilados.add(campoAAlquilar);
		}
		return false;
	}
	
	public Boolean comprarTerreno(Terreno terrenoAComprar) {
		if (terrenoAComprar.getEstaDisponible().equals(true)
				&& terrenoAComprar.getTipoDeOperacion().equals(TipoDeOperacion.VENTA)) {
			terrenoAComprar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.terrenosComprados.add(terrenoAComprar);
		}
		return false;
	}
	
	public Boolean alquilerTerreno(Terreno terrenoAAlquilar) {
		if (terrenoAAlquilar.getEstaDisponible().equals(true)
				&& terrenoAAlquilar.getTipoDeOperacion().equals(TipoDeOperacion.ALQUILER)) {
			terrenoAAlquilar.setEstaDisponible(false);
			this.poseePropiedadParaPermutar = true;
			this.terrenosComprados.add(terrenoAAlquilar);
		}
		return false;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getPoseePropiedadParaPermutar() {
		return poseePropiedadParaPermutar;
	}

	public void setPoseePropiedadParaPermutar(Boolean poseePropiedadParaPermutar) {
		this.poseePropiedadParaPermutar = poseePropiedadParaPermutar;
	}

	public ArrayList<Casa> getCasasCompradas() {
		return casasCompradas;
	}

	public void setCasasCompradas(ArrayList<Casa> casasCompradas) {
		this.casasCompradas = casasCompradas;
	}

	public ArrayList<Casa> getCasasAlquiladas() {
		return casasAlquiladas;
	}

	public void setCasasAlquiladas(ArrayList<Casa> casasAlquiladas) {
		this.casasAlquiladas = casasAlquiladas;
	}

	public ArrayList<Departamento> getDepartamentosComprados() {
		return departamentosComprados;
	}

	public void setDepartamentosComprados(ArrayList<Departamento> departamentosComprados) {
		this.departamentosComprados = departamentosComprados;
	}

	public ArrayList<Departamento> getDepartamentosAlquilados() {
		return departamentosAlquilados;
	}

	public void setDepartamentosAlquilados(ArrayList<Departamento> departamentosAlquilados) {
		this.departamentosAlquilados = departamentosAlquilados;
	}

	public ArrayList<Ph> getPhsComprados() {
		return phsComprados;
	}

	public void setPhsComprados(ArrayList<Ph> phsComprados) {
		this.phsComprados = phsComprados;
	}

	public ArrayList<Ph> getPhsAlquilados() {
		return phsAlquilados;
	}

	public void setPhsAlquilados(ArrayList<Ph> phsAlquilados) {
		this.phsAlquilados = phsAlquilados;
	}

	public ArrayList<Campo> getCamposComprados() {
		return camposComprados;
	}

	public void setCamposComprados(ArrayList<Campo> camposComprados) {
		this.camposComprados = camposComprados;
	}

	public ArrayList<Campo> getCamposAlquilados() {
		return camposAlquilados;
	}

	public void setCamposAlquilados(ArrayList<Campo> camposAlquilados) {
		this.camposAlquilados = camposAlquilados;
	}

	public ArrayList<Terreno> getTerrenosComprados() {
		return terrenosComprados;
	}

	public void setTerrenosComprados(ArrayList<Terreno> terrenosComprados) {
		this.terrenosComprados = terrenosComprados;
	}

	public ArrayList<Terreno> getTerrenosAlquilados() {
		return terrenosAlquilados;
	}

	public void setTerrenosAlquilados(ArrayList<Terreno> terrenosAlquilados) {
		this.terrenosAlquilados = terrenosAlquilados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

}
