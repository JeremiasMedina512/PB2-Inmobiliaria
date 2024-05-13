package ar.edu.unlam.pb1;

import java.util.Objects;

public class Casa extends Propiedad{
	
	private static Integer codigoDeCasa = 0;
	
	public Casa(Integer codigo, String calle, Integer numero, String ciudad, Double precio,
			TipoDeOperacion tipoDeOperacion) {
		super(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
	}

	public Casa(String ciudad, String calle, Integer numero) {
		super(++codigoDeCasa, calle, ciudad, 0.0, TipoDeOperacion.VENTA);
		
	}


	
	
	
	
	

	

	
	
	
	
	
	
}
