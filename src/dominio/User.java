package dominio;

public class User {

	private String nombre;
	private String edad = "0";
	private String password;
	private String genero;
	private String pais;
	private String sobreTi;
	private String[] comunidad;
	private Boolean listaCorreo;
		
	public String getNombre() {
		return nombre;
	  }
	public String getEdad() {
		return edad;
	  }		
	public String getPassword() {
		return password;
	  }
	public String getGenero() {
		return genero;
	  }
	public String getPais() {
		return pais;
	  }
	public String getSobreTi() {
		return sobreTi;
	  }
	public String[] getComunidad() {
		return comunidad;
	  }
	public Boolean getListaCorreo() {
		return listaCorreo;
  	  }
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	  }
	public void setEdad( String edad ) {
		this.edad = edad;
	  }	
	public void setPassword( String password ) {
		this.password = password;
	  }
	public void setGenero( String genero ) {
		this.genero = genero;
	  }
	public void setPais( String pais ) {
		this.pais = pais;
	  }
	public void setSobreTi( String sobreTi ) {
		this.sobreTi = sobreTi;
	  }
	public void setComunidad(String[] comunidad) {
		this.comunidad = comunidad;
	  }
	public void setListaCorreo( Boolean listaCorreo ) {
		this.listaCorreo = listaCorreo;
	  }	
}
