package ar.edu.unlam.pb1;

public class Cliente {
	
	Long dni;
	String nombre;
	
	public Cliente(Long dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
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
	
	

}
