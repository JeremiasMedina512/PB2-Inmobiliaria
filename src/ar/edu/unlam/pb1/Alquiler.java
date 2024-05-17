package ar.edu.unlam.pb1;

import java.sql.Date;

public class Alquiler {
	
	private Cliente cliente;
	private Propiedad propiedad;
	private Date fehcaLimite;
	
	public Alquiler(Cliente cliente, Propiedad propiedad, Date fehcaLimite) {
		super();
		this.cliente = cliente;
		this.propiedad = propiedad;
		this.fehcaLimite = fehcaLimite;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Date getFehcaLimite() {
		return fehcaLimite;
	}

	public void setFehcaLimite(Date fehcaLimite) {
		this.fehcaLimite = fehcaLimite;
	}
	
	
	
	
	
	

}
