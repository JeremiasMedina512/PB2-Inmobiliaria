package ar.edu.unlam.pb1;

import java.util.Objects;

public class Departamento {

	private Integer codigo;
	private String calle;
	private Integer numero;
	private String ciudad;
	private Integer piso;
	private Integer departamento;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipoDeOperacion;

	public Departamento(Integer codigo, String calle, Integer numero, String ciudad, Integer piso, Integer departamento, Double precio,
			TipoDeOperacion tipoDeOperacion) {
		this.codigo = codigo;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.piso = piso;
		this.departamento = departamento;
		this.precio = precio;
		this.estaDisponible = true;
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public Integer getPiso() {
		return piso;
	}



	public void setPiso(Integer piso) {
		this.piso = piso;
	}



	public Integer getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
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
		return Objects.hash(calle, ciudad, departamento, numero, piso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(departamento, other.departamento) && Objects.equals(numero, other.numero)
				&& Objects.equals(piso, other.piso);
	}


	
	

}
