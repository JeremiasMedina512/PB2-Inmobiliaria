package ar.edu.unlam.pb1;

import java.util.ArrayList;

public class Venta {
	
	private Cliente cliente;
	private Propiedad propiedad;
	
	public Venta(Cliente cliente, Propiedad propiedad) {
		super();
		this.cliente = cliente;
		this.propiedad = propiedad;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Propiedad getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	
	
	

}
