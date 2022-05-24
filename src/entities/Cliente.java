package entities;

public class Cliente {

	private String user;
	private String password;
	private Boolean habilitado;
	private CuentaCorriente cc;
	private CajaDeAhorro ca;
	
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CuentaCorriente getCc() {
		return cc;
	}
	public void setCc(CuentaCorriente cc) {
		this.cc = cc;
	}
	public CajaDeAhorro getCa() {
		return ca;
	}
	public void setCa(CajaDeAhorro ca) {
		this.ca = ca;
	}
	
	
	public Cliente() {
		this.setHabilitado(false);
	}
}
