package dominio;

public class Moneda {

	private Integer idMoneda;
	private String nombre;
	private String simbolo;

	public Integer getIdMoneda() {
		return idMoneda;
	  }
	public String getNombre() {
		return nombre;
	  }
	public String getSimbolo() {
		return simbolo;
	  }
	public void setIdMoneda( Integer idMoneda ) {
		this.idMoneda = idMoneda;
	  }
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	  }
	public void setSimbolo( String simbolo ) {
		this.simbolo = simbolo;
	  }
}
