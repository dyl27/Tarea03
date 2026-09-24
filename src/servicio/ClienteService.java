package servicio;

import java.util.List;

import dominio.Cliente;

public interface ClienteService {

	public void add( Cliente cliente );
	public void update( Cliente cliente );
	public void delete( Integer idCliente );
	public Cliente getById( Integer idCliente );
	public List<Cliente> getAll();
}