package ar.edu.unlam.pb1;

public class Campo extends Propiedad{
	
	private Double metrosCuadrados;
	
	public Campo(Integer codigo, String calle, Integer numero, String ciudad, Double precio,
			TipoDeOperacion tipoDeOperacion, Double metrosCuadrados) {
		super(codigo, calle, numero, ciudad, precio, tipoDeOperacion);
		this.metrosCuadrados = metrosCuadrados;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
	

}
