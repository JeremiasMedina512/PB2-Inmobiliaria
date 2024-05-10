package ar.edu.unlam.pb1;

import java.util.Objects;

public class Departamento extends Propiedad implements Comparable<Object> {

	private Integer piso;
	private Integer departamento;

	public Departamento(Integer codigo, String calle, Integer numero, String ciudad, Double precio,
			TipoDeOperacion tipoDeOperacion, Integer piso, Integer departamento) {
		super(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
		this.piso = piso;
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.codigo, super.ciudad, super.calle, super.numero, this.departamento, this.piso);
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
		return Objects.equals(getCodigo(), other.getCodigo()) && Objects.equals(getCiudad(), other.getCiudad())
				&& Objects.equals(getCalle(), other.getCalle()) && Objects.equals(getNumero(), other.getNumero());
	}

//	@Override
//	public int compareTo(Departamento otroDepartamento) {
//		return this.getCiudad().compareTo(otroDepartamento.getCiudad());
//	}

	@Override
	public int compareTo(Object otroDepartamento) {
		return this.getCiudad().compareTo(((Propiedad) otroDepartamento).getCiudad());

	}

}
