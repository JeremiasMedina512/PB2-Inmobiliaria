package ar.edu.unlam.pb1;

import java.util.Objects;

public class Casa extends Propiedad{
	
	public Casa(Integer codigo, String calle, Integer numero, String ciudad, Double precio,
			TipoDeOperacion tipoDeOperacion) {
		super(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getCalle(),this.getCiudad(), this.getNumero());

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
		return Objects.equals(this.getCalle(), other.getCalle()) && Objects.equals(this.getCalle(), other.getCalle())
				&& Objects.equals(this.getNumero(), other.getNumero());
	}
	
	
	
	
	

	

	
	
	
	
	
	
}
