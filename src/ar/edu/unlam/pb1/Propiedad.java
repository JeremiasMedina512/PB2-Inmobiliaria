package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Objects;

public class Propiedad {
	
	protected Integer codigo;
	protected String calle;
	protected Integer numero;
	protected String ciudad;
	protected Double precio;
	protected Boolean estaDisponible;
	protected TipoDeOperacion tipoDeOperacion;
	
	public Propiedad(Integer codigo, String calle, Integer numero, String ciudad, Double precio,
			TipoDeOperacion tipoDeOperacion) {
		this.codigo = codigo;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = true;
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
	public Propiedad() {
		
	}
	
	public Propiedad[] buscarPorRangoDePrecio(Integer minimo, Integer maximo) {
		
		return null;
	}
	
	public Double calcularPromedio(ArrayList<Casa> casa) {
	
		return null;
	}

	public Double calcularPromedio(Departamento departamento) {
		return 0.0;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(numero, other.numero);
	}
	
	
	
	


	
	
	
	
	

}
