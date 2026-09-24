package servicio;

import java.util.List;

import dominio.Credito;

public interface CreditoService {

	public void add( Credito credito );
	public void update( Credito credito );
	public void delete( Integer idCredito );
	public Credito getById( Integer idCredito );
	public List<Credito> getAll();
	public List<Credito> getByCliente( Integer idCliente );
}