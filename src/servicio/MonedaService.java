package servicio;

import java.util.List;

import dominio.Moneda;

public interface MonedaService {

	public void add( Moneda moneda );
	public void update( Moneda moneda );
	public void delete( Integer idMoneda );
	public Moneda getById( Integer idMoneda );
	public List<Moneda> getAll();
}