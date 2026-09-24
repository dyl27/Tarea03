package dominio;

import java.util.Date;

public class Cliente {

	private Integer idCliente;
	private String nombres;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private String correo;
	private Date fechaRegistro;

	public Integer getIdCliente() {
		return idCliente;
	  }
	public String getNombres() {
		return nombres;
	  }
	public String getApellidos() {
		return apellidos;
	  }
	public String getDni() {
		return dni;
	  }
	public String getDireccion() {
		return direccion;
	  }
	public String getTelefono() {
		return telefono;
	  }
	public String getCorreo() {
		return correo;
	  }
	public Date getFechaRegistro() {
		return fechaRegistro;
	  }
	public void setIdCliente( Integer idCliente ) {
		this.idCliente = idCliente;
	  }
	public void setNombres( String nombres ) {
		this.nombres = nombres;
	  }
	public void setApellidos( String apellidos ) {
		this.apellidos = apellidos;
	  }
	public void setDni( String dni ) {
		this.dni = dni;
	  }
	public void setDireccion( String direccion ) {
		this.direccion = direccion;
	  }
	public void setTelefono( String telefono ) {
		this.telefono = telefono;
	  }
	public void setCorreo( String correo ) {
		this.correo = correo;
	  }
	public void setFechaRegistro( Date fechaRegistro ) {
		this.fechaRegistro = fechaRegistro;
	  }
} 