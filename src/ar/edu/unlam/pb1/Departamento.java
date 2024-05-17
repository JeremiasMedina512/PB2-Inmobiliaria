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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(departamento, piso);
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(piso, other.piso);
	}




	@Override
	public int compareTo(Object otroDepartamento) {
		return this.getCiudad().compareTo(((Propiedad) otroDepartamento).getCiudad());

	}

}
