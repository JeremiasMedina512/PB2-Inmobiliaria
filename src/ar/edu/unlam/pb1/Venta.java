package ar.edu.unlam.pb1;

public class Venta {
	
	private Cliente cliente;
	private Casa casa;
	
	public Venta(Cliente cliente, Casa casa) {
		super();
		this.cliente = cliente;
		this.casa = casa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	
	
	

}
